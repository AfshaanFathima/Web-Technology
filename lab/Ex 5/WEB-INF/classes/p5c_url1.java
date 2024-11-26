import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5c_url1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Retrieve the username from the request
            String userName = request.getParameter("userName");

            // Themed HTML Response
            out.println("<html><head><title>Welcome</title>");
            out.println("<style>");
            out.println("body { background-color: #fce4ec; font-family: 'Comic Sans MS', sans-serif; text-align: center; padding: 20px; }");
            out.println("h1 { color: #e91e63; }");
            out.println(".box { background-color: #f8bbd0; padding: 20px; border-radius: 15px; display: inline-block; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }");
            out.println("a { text-decoration: none; color: white; background-color: #e91e63; padding: 10px 20px; border-radius: 5px; font-weight: bold; }");
            out.println("a:hover { background-color: #d81b60; }");
            out.println("</style></head><body>");

            // Welcome message
            out.println("<h1>Hi " + userName + "!</h1>");
            out.println("<div class='box'>");
            out.println("<p>Welcome to the Kids Learning App!</p>");
            out.println("<a href='urlHandler2?userName=" + userName + "'>Go to Next Page</a>");
            out.println("</div>");

            out.println("</body></html>");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
