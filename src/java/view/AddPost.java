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

    String[] CATEGORIES;

    // make use of initialization parameter
    public void init() {
        String categories_list = getInitParameter("categories-list");
        if (categories_list == null) {
            categories_list = DEFAULT_CATEGORIES;
        }
        CATEGORIES = categories_list.split(",");
    }
    // initialize default
    private static final String DEFAULT_CATEGORIES = "Personal,Travel";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String siteName="JSP Blog";
        try {
            out.println("<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>");
            out.println("<head><title>Add a new post : Admin -"+siteName+"</title>");
            out.println("<meta http-equiv='content-type' content='application/xhtml+xml; charset=UTF-8' />");
            out.println("<link rel='stylesheet' type='text/css' media='screen' href='../css/NIITSpecialStyle.css' />");
            out.println("</head>");
            out.println("<body><div id='wrap'><div id='header'>");
            out.println("<h1 id='logo-text'><a href='index.jsp' title=''>"+siteName+"</a></h1>");
            out.println("<p id='slogan'>JSP based blogging system</p>");
            out.println("<div  id='nav'><ul>");
            out.println("<li class='first' id='current'><a href='index.jsp'>Home</a></li>");
            out.println("<li><a href='AddPost.view'>Add New Post</a></li>");
            out.println("<li><a href='./'>List all posts</a></li>");
            out.println("<li><a href='Logout.do'>Logout</a></li>");
            out.println("</ul></div>");
            out.println("<div id='header-image'></div></div>");
            out.println("<div id='content-outer' class='clear'><div id='content-wrap'>");
            out.println("<div id='content'><div id='left'>");

            //code for the form and main body for writing a post            
            out.println("<h2>Write your post</h2>");
            out.println("<form action='AddNewPost.do' method='post'>");
            out.println("<strong>Title:</strong> <input type='text' name='title' size='40'/><br/>");
            out.println("<strong>Category:</strong>");
            out.println("<select name='category'>");
            out.println("<option value='UNKNOWN'>select..</option>");
            for (int i = 0; i < CATEGORIES.length; i++) {
                out.print("<option value='" + CATEGORIES[i] + "'");
                out.println(">" + CATEGORIES[i] + "</option>");
            }
            out.println("</select><br/>");
            out.println("<strong>Body:</strong> <input type='text' name='body' size='40' /><br/>");
            out.println("<input type='submit' name='Submit'/>");
            out.println("</form>");

            out.println("</div></div></div></div>");
            out.println("<div id='footer-bottom'><div class='bottom-left'><p>&copy; 2012 <strong>Santosh G.S.</strong>&nbsp; &nbsp; &nbsp;</p></div>");
            out.println("<div class='bottom-right'><p><a href='http://www.santoshgs.com/'>Say hi!</a>");
            out.println("</p></div></div></div></body></html>");
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