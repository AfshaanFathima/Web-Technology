import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5c_cookie extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();

            // Fetch user input
            String in_data = request.getParameter("userin");

            // Create and set the cookie
            Cookie c = new Cookie("MagicCookie", in_data);
            response.addCookie(c);

            // Kids-themed response
            pwriter.print("<html><body style='font-family: Comic Sans MS; background-color: #FFDDC1; text-align: center;'>");
            pwriter.print("<h1 style='color: #FF6F61;'> Magic Cookie Created! </h1>");
            pwriter.print("<p>Your magical word is now stored in a cookie called <b>MagicCookie</b>!</p>");
            pwriter.print("<p>Cookie Value: <b>" + in_data + "</b></p>");
            pwriter.print("<img src='https://www.peer39.com/hubfs/Firefly%20A%20bunch%20of%20computers.%20Each%20computer%20has%20a%20cookie%20that%20is%20breaking%20inside%20of%20each%20screen%209794.jpg' alt='Cookie Magic' width='200'>");
            pwriter.print("<p style='color: #6A0572;'>Keep exploring the magic world of cookies!</p>");
            pwriter.print("</body></html>");

            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
