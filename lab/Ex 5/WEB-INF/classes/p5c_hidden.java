import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5c_hidden extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        // Retrieve data from the form
        String userName = request.getParameter("userName");
        String appName = request.getParameter("appName");

        // Response with a themed message
        pwriter.println("<html><head><title>Welcome!</title>");
        pwriter.println("<style>");
        pwriter.println("body { background-color: #fbe7c6; font-family: 'Comic Sans MS', sans-serif; text-align: center; padding: 20px; }");
        pwriter.println("h1 { color: #ff6f61; }");
        pwriter.println(".box { background-color: #ffe4b5; padding: 20px; border-radius: 15px; display: inline-block; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }");
        pwriter.println("</style></head><body>");
        pwriter.println("<h1>Hello " + userName + "!</h1>");
        pwriter.println("<div class='box'>");
        pwriter.println("<p>Welcome to <strong>" + appName + "</strong>. Have fun learning and exploring!</p>");
        pwriter.println("</div>");
        pwriter.println("</body></html>");

        pwriter.close();
    }
}
