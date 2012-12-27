package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posts;

/**
 * @author Santosh
 */
public class AdminList extends HttpServlet {
           // initialize static variable so that count increases each time class is called and not object
            static int count;
           // make a list of list, so that each post is saved as a list inside of a list.
            static LinkedList[] ListOLists = (LinkedList[]) new LinkedList[100];
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieval of context items
        ServletContext context = getServletContext();
        List postsList = (List) context.getAttribute("postsList");

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Admin : List of all posts</title>");
            out.println("</head>");
            out.println("<body bgcolor='grey'>");
            out.println("<table width='800' align='center'>");
            out.println("<tr bgcolor='#ffeeee'>");
            out.println("<td>");
            out.println("&diams;<a href='AddPost.view'>New Post</a>&emsp;");
            out.println("&diams;<a href='..'>Visit Site</a>&emsp;");
            out.println("&diams;<a href=''>Logout</a>&emsp;");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<table width='800' border='0' bgcolor='#ceecec' align='center'>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<h1>My Blog</h1>");
            out.println("<tr width='640'>");
            out.println("<td>");
            out.println("<h2>List of all posts</h2>");
            out.println("<ol>");
            
            ListOLists[count] = new LinkedList();
            ListOLists[count] = (LinkedList) postsList;
            for (int i = 0; i < count + 1; i++) {
                Iterator items = ListOLists[i].iterator();
                while (items.hasNext()) {
                    Posts posts = (Posts) items.next();
                    out.println("<li> <strong>Title: " + posts.getTitle() + "</strong>");
                    out.println("<br /><small> Category: " + posts.getCategory() + "</small><br />");
                    out.println(posts.getBody() + "</li><br />");
                }
            }
            count++;
            
            out.println("</ol>");         
            out.println("</td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("</table>");
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
