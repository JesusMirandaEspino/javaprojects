/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */
@WebServlet(name = "CookiesServelest", urlPatterns = {"/CookiesServelest"})
public class CookiesServelest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        boolean nuevoUsuario = true;
        Cookie[] cookies = request.getCookies();
        int contador = 0;
        
        if( cookies != null ){
            for( Cookie c:cookies ){
                if( c.getName().equals("visitanterecurente") && c.getValue().equals("si")){
                    nuevoUsuario = false;
                }
            }
        }
        
        
        for( Cookie c:cookies ){
            if( "contadorVisitas".equals(c.getName())){
                contador = Integer.parseInt(c.getValue());
            }
        }
        
        contador++;
        Cookie contadorVisitas = new Cookie("contadorVisitas" , Integer.toString(contador));
        contadorVisitas.setMaxAge(3600);
        response.addCookie(contadorVisitas);
        
        String mensaje;
        if( nuevoUsuario ){
            Cookie visitanteCookie = new Cookie("visitanterecurente" , "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookiesServelest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Servlet CookiesServelest at " + mensaje + "</p>");
            out.println("<p>Contador " + contador + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
