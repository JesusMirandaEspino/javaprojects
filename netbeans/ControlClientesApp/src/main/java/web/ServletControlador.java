/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.ClienteDAOJDBC;
import Dominio.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author jesus
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException{
        
        System.out.println("Se ejecuta");
        this.accionDefault(request, response);
    }
    
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response )throws IOException, ServletException{
        List<Cliente> listaClientes = new ClienteDAOJDBC().listar();
        System.out.println("clientes: " + listaClientes);
        HttpSession session = request.getSession();
        
        session.setAttribute("listaClientes", listaClientes);
        session.setAttribute("totalClientes", listaClientes.size());
        request.setAttribute("saldoTotal", this.calcularSaldoTotal(listaClientes));
        
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
        response.sendRedirect("clientes.jsp");
        
    }
    
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal = 0; 
        
        for(Cliente cliente:clientes ){
            saldoTotal+=cliente.getSaldo();
        }
        
        return saldoTotal;
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String accion = request.getParameter("accion");
        
        
        if( accion != null ){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                    
                case "editar":
                    this.editarCliente(request, response);
                    break;
                    
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                    
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                    
                default:
                    this.accionDefault(request, response);
            
            }
        
        }else{
            this.accionDefault(request, response);
        }
        
        
    }
    
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if( saldoString != null && !"".equals(saldoString) ){
            saldo = Double.parseDouble(saldoString);
        }
        
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        
        int registrosModificados = new ClienteDAOJDBC().insertar(cliente);
        
        System.out.println("Clientes Modificados: " + registrosModificados);
        
        this.accionDefault(request, response);
    }
    
    
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        
        Cliente cliente = new ClienteDAOJDBC().encontrar(new Cliente(id_cliente));
        
        request.setAttribute("cliente", cliente);
        
        String JSPEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        
        request.getRequestDispatcher(JSPEditar).forward(request, response);
    }
    
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if( saldoString != null && !"".equals(saldoString) ){
            saldo = Double.parseDouble(saldoString);
        }
        
        Cliente cliente = new Cliente(id_cliente, nombre, apellido, email, telefono, saldo);
        
        int registrosModificados = new ClienteDAOJDBC().actualizar(cliente);
        
        System.out.println("Clientes Modificados: " + registrosModificados);
        
        this.accionDefault(request, response);
    }
    
    
    
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        
        Cliente cliente = new Cliente(id_cliente);
        
        int registrosModificados = new ClienteDAOJDBC().borrar(cliente);
        
        System.out.println("Clientes Modificados: " + registrosModificados);
        
        this.accionDefault(request, response);;
    }
    
    
}
