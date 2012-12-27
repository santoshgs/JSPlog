package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posts;

/**
 *
 * @author Santosh
 */
public class AddNewPost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // get all parameters from previous form
        String Post_title = request.getParameter("title");
        String Post_category = request.getParameter("category");
        String Post_body = request.getParameter("body");

//        PrintWriter out = response.getWriter(); // used to write webpage output
        PrintWriter PostWriter = null; // used to write to file


        // testing to find out where post.txt is saved. Path can be seen in source.
//        File dir1 = new File(".");
//        out.println("<!--");
//        out.println("Current dir : " + dir1.getCanonicalPath());
//        out.println("-->");
        // end of test block

//        String PostFile = Post_title + ".html"; // file output and file type

        String PostFile = "index.txt";

        try {
            // begin writing to file

            PostWriter = new PrintWriter(new FileWriter(PostFile, true));

            //formatting for post to appear as HTML

            PostWriter.print("<div class='entry'>");
            PostWriter.print("<h3>");
            PostWriter.print(Post_title);
            PostWriter.print("</h3>");
            PostWriter.println();
            PostWriter.print("<center>Posted in category:<strong> ");
            PostWriter.print(Post_category);
            PostWriter.print("</strong></center>");
            PostWriter.println();
            PostWriter.print("<p>");
            PostWriter.print(Post_body);
            PostWriter.print("</p>");
            PostWriter.print("</div>");
            PostWriter.println();


            // add to model
            Posts posts = new Posts(Post_title, Post_category, Post_body);

            request.setAttribute("posts", posts);

            // Create a list to save all the posts
            ServletContext context = getServletContext();
            List postsList = new LinkedList();
            context.setAttribute("postsList", postsList);
            postsList.add(posts);

            //forward to admin list page
            RequestDispatcher view = request.getRequestDispatcher("./");
            view.forward(request, response);

        } catch (Exception e) {
            System.err.println(e);
        } finally {
//            out.close();
            if (PostWriter != null) {
                try {
                    PostWriter.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
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
