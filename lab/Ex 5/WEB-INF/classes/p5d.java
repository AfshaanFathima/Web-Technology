import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5d extends HttpServlet {
    public void init() {
        // Initial setup if needed
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");

        // Fetch user data from request parameters (i.e., from the form)
        String username = request.getParameter("uname");

        // Get the session object
        HttpSession session = request.getSession();

        // If session is new, initialize the user-specific hit count
        if (username != null && !username.isEmpty()) {
            Integer userhitCount = (Integer) session.getAttribute(username + "_hitCount");

            if (userhitCount == null) {
                // If no hit count found, initialize it to 0 for this user
                userhitCount = 0;
            }

            // Increment the user-specific hit count
            userhitCount++;

            // Store the updated count in session using username as key
            session.setAttribute(username + "_hitCount", userhitCount);

            // Send response to the user
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3><b>User: " + username + "</b></h3>");
            out.println("<h4>Page User Visits: " + userhitCount + "</h4>");
            out.println("</body></html>");
        } else {
            // If username is not provided, ask for the username
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Error: Please provide a username to track visits.</h3>");
            out.println("</body></html>");
        }
    }

    public void destroy() {
        // Cleanup resources if needed
    }
}
