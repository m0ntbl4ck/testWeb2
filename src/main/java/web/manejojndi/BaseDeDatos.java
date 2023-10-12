
package web.manejojndi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mont_
 */
@WebServlet(name = "BaseDeDatos", urlPatterns = {"/BaseDeDatos"})

public class BaseDeDatos extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BaseDeDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BaseDeDatos at " + request.getContextPath() + "</h1>");
            out.println("<p>"+queryBaseDatos()+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String queryBaseDatos(){
        StringBuilder outString  =  new StringBuilder("");
        
        try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/empresa?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false",
                "root",
                "user"
        );
        PreparedStatement prestmt = con.prepareStatement("SELECT * FROM empleados");
        ResultSet rs = prestmt.executeQuery();
                ) {
            
            int fila= 1;
            
            while(rs.next()){
                 outString.append("=== Fila "+fila++ +" ===<br/>");
                 outString.append("Id empleados: "+ rs.getInt(1)+"<br/>");
                  outString.append("Nombres: "+ rs.getString(2)+"<br/>");
                   outString.append("Apellidos: "+ rs.getString(3)+"<br/>");
                    outString.append("Fecha de Nacimiento: "+ rs.getDate(4)+"<br/>");
                     outString.append("Salario: "+ rs.getDouble(5)+"<br/>");
                      outString.append("Cargo: "+ rs.getString(6)+"<br/>");
                      outString.append("<hr/>");
            }
            
        } catch (SQLException e) {
            return "SQL Exception "+e.getMessage();
        } catch(Exception er){
            return "Otra Excepction "+er.getMessage();
        }
        return outString.toString();
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
