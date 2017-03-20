/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pirasalbe
 */
public class listInfo extends HttpServlet {

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
        
        //get session
        HttpSession session = request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<head>\n" +
                        "<title>Info</title>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">" +
                        "</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            
            //title
            out.println("<div class=\"row\">" +
                        "<div class=\"jumbotron text-center\"><h2>Some Info</h2></div>" +
                        "</div>");
            
            //value
            Enumeration e = session.getAttributeNames();
            while(e.hasMoreElements()){
                String name = (String)e.nextElement();
                out.println("<div class=\"row\">" +
                        "<div class=\"alert alert-success col-sm-4\">" + name + ": "+ session.getAttribute(name) +"</div>" +
                        "</div><br>");
            }
            
            //session
            out.println("<div class=\"row\">" +
                        "<div class=\"alert alert-success col-sm-4\">ID: " + session.getId() +"</div>" +
                        "</div><br>");
            out.println("<div class=\"row\">" +
                        "<div class=\"alert alert-success col-sm-4\">Creation time: " + new Timestamp(session.getCreationTime()) +"</div>" +
                        "</div><br>");
            out.println("<div class=\"row\">" +
                        "<div class=\"alert alert-success col-sm-4\">Last access: " + new Timestamp(session.getLastAccessedTime()) +"</div>" +
                        "</div><br>");
            
            out.println("</div>");
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
