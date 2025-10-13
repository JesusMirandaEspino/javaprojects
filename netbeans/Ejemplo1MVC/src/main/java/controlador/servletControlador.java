/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import modelo.Rectangulo;

/**
 *
 * @author jesus
 */

@WebServlet("/servletControlador")
public class servletControlador extends HttpServlet{
    
    @Override
   protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException{
   
       
       String accion = request.getParameter("accion");
       
       
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSession = new Rectangulo(3,4);
        Rectangulo recApplication = new Rectangulo(5,6);
       

        if("agregar".equals(accion)){
            request.setAttribute("rectanguloRequest", recRequest);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSession);
            
            
            ServletContext aplicacion = this.getServletContext();
            aplicacion.setAttribute("rectanguloAplicacion", recApplication);
            
            request.setAttribute("mensaje", "Variables agregadas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if("listar".equals(accion)){
                
         request.getRequestDispatcher("WEB-INF/alcance.jsp").forward(request, response);
        
        }else{
            request.setAttribute("mensaje", "fallo");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }        

   }
    
}
