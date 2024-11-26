import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5c_url2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Retrieve username from query string
            String userName = request.getParameter("userName");

            // Themed HTML Response
            out.println("<html><head><title>Next Page</title>");
            out.println("<style>");
            out.println("body { background-color: #d1c4e9; font-family: 'Comic Sans MS', sans-serif; text-align: center; padding: 20px; }");
            out.println("h1 { color: #673ab7; }");
            out.println(".box { background-color: #ede7f6; padding: 20px; border-radius: 15px; display: inline-block; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }");
            out.println("</style></head><body>");

            // Display username
            out.println("<h1>Hello again, " + userName + "!</h1>");
            out.println("<div class='box'>");
            out.println("<p>Keep exploring and learning!</p>");
            out.println("</div>");

            out.println("</body></html>");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
