/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santosh
 */
public class AddPost extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String[] CATEGORIES;

    // make use of initialization parameter
    public void init()
    {
        String categories_list = getInitParameter("categories-list");
        if(categories_list==null)
        {
            categories_list=DEFAULT_CATEGORIES;
        }
        CATEGORIES=categories_list.split(",");
    }
    
    // initialize default
    private static final String DEFAULT_CATEGORIES="Personal,Travel";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewPost</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table align='right'>");
            out.println("<tr bgcolor='#ffeeee'>");
            out.println("<td>");
            out.println("<ul>");
            out.println("<li><a href=''>New Post</a>&emsp;</li>");
            out.println("<li><a href=''>New Page</a>&emsp;</li>");
            out.println("<li><a href='..'>Visit Site</a>&emsp;</li>");
            out.println("<li><a href=''>Logout</a>&emsp;</li>");
            out.println("</ul>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            
//code for the form and main body for writing a post            
            out.println("<p>");
            out.println("<form action='AddNewPost.do' method='post'>");
            out.println("<strong>Title:</strong> <input type='text' name='title' size='40'/><br/>");
            out.println("<strong>Category:</strong>");
            out.println("<select name='category'>");
            out.println("<option value='UNKNOWN'>select..</option>");
            for(int i=0;i<CATEGORIES.length;i++)
            {
                out.print("<option value='"+CATEGORIES[i]+"'");
                out.println(">"+CATEGORIES[i]+"</option>");
            }
            out.println("</select><br/>");
            out.println("<strong>Body:</strong> <input type='text' name='body' size='40' /><br/>");
            out.println("<input type='submit' name='Submit'/>");
            out.println("</form>");
            out.println("</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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