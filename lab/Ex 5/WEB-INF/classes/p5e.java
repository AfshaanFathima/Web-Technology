import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5e extends HttpServlet {
    public void init() {
        // Initial setup if needed
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");

        // Fetch user data from request parameters
        String username = request.getParameter("uname");

        // Get the session object
        HttpSession session = request.getSession();

        // Handle user hit count logic
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: 'Comic Sans MS', sans-serif; background-color: #FFFBF0; color: #444; text-align: center; padding: 20px; }");
        out.println("h1 { color: #FF6F61; font-size: 2.5em; }");
        out.println("p { font-size: 1.2em; }");
        out.println("div { margin: 20px auto; padding: 15px; background-color: #FFF5E4; border: 2px solid #FF6F61; border-radius: 15px; width: 60%; box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1); }");
        out.println("</style>");
        out.println("</head><body>");

        if (username != null && !username.isEmpty()) {
            // Get or initialize the user-specific hit count
            Integer userhitCount = (Integer) session.getAttribute(username + "_hitCount");
            if (userhitCount == null) {
                userhitCount = 0;
            }
            userhitCount++; // Increment the hit count
            session.setAttribute(username + "_hitCount", userhitCount); // Update session attribute

            // Display user-specific data
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<div>");
            out.println("<p> This is your <strong>" + userhitCount + "</strong> visit to this page!</p>");
            out.println("<p>Keep exploring and learning! </p>");
            out.println("</div>");
        } else {
            // Display error if username is missing
            out.println("<h1>Error</h1>");
            out.println("<p style='color:red;'>🚨 Please provide a username to track your visits.</p>");
        }

        out.println("</body></html>");
    }

    public void destroy() {
        // Cleanup resources if needed
    }
}
