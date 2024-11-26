import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class p5c_https1 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        try {  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  

            // Retrieve adventurer's name from the request
            String adventurerName = request.getParameter("userName");  
            out.println("<html><body style='font-family:Comic Sans MS; background-color:#f9f7d9;'>");
            out.println("<h1>Welcome, Brave " + adventurerName + "!</h1>");  

            // Store adventurer's name in a session
            HttpSession session = request.getSession();  
            session.setAttribute("adventurer_name", adventurerName);  

            // Provide a link to the next part of the adventure
            out.println("<p>Your adventure has just begun. Click below to continue!</p>");
            out.println("<a href='sessid2' style='font-size:20px; color:#ff6f61;'>Continue Your Adventure</a>");           
            out.println("</body></html>");
            out.close();  
        } catch(Exception e) {
            System.out.println(e);  
        }  
    }
}  
