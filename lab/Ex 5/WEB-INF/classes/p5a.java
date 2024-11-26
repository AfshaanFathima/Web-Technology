import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5a extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #ffe4e1; /* Pastel pink */");
        out.println("    font-family: 'Comic Sans MS', cursive, sans-serif;");
        out.println("    color: #333;");
        out.println("    text-align: center;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println("h1 {");
        out.println("    color: #ff69b4; /* Hot pink */");
        out.println("    font-size: 48px;");
        out.println("    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
