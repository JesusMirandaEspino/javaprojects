
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
@WebServlet("/Servlet")
public class Servelet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
            //Leer los parametros del formulario html
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            System.out.println("usuario = " + usuario);
            System.out.println("password = " + password);

            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<body>");
            out.print("El parametro usuario es:" + usuario);
            out.print("<br/>");
            out.print("El parametro password es:" + password);
            out.print("</body>");
            out.print("</html>");
            out.close();
            }
}
