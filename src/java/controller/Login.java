package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Santosh
 */
public class Login extends HttpServlet {

    String defaultLogin = "admin";
    String defaultPassword = "123";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html");
            if ((username.equals(defaultLogin)) && (password.equals(defaultPassword))) {
                out.println("<html><body>");
                out.println("Thank you, " + username + ". You are now logged into the system. <a href='admin'>Click here</a> to continue.");
                out.println("</body></html>");
            }
            else
            {
                out.println("Login failure. <a href='login.jsp'>Try again?</a>");
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
