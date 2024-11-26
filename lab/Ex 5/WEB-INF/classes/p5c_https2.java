import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class p5c_https2 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        try {  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  

            // Retrieve session and fetch stored adventurer's name
            HttpSession session = request.getSession(false);  
            String adventurerName = (String) session.getAttribute("adventurer_name");  

            // Display a welcome back message
            out.println("<html><body style='font-family:Comic Sans MS; background-color:#f9f7d9;'>");
            out.println("<h1>Hello Again, Brave " + adventurerName + "!</h1>");
            out.println("<p>Your journey awaits! Be prepared for new challenges and exciting treasures.</p>");
            out.println("</body></html>");
            out.close();  
        } catch(Exception e) {  
            System.out.println(e);  
        }  
    }
}  
