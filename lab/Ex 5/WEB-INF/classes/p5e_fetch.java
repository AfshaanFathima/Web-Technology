import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p5e_fetch extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KidsApp", "root", "");

            String sql = "SELECT Name FROM kids1 WHERE Age = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(request.getParameter("age")));

            ResultSet rs = pstmt.executeQuery();

            out.println("<html><head><style>");
            out.println("body { font-family: 'Comic Sans MS', sans-serif; background-color: #FFFBF0; color: #444; text-align: center; padding: 20px; }");
            out.println("h2 { color: #FF6F61; font-size: 2em; }");
            out.println("p { font-size: 1.2em; color: #444; }");
            out.println("</style></head><body>");
            out.println("<h2> Names of Kids with Age " + request.getParameter("age") + " </h2>");

            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                out.println("<p>" + rs.getString("Name") + "</p>");
            }
            if (!hasResults) {
                out.println("<p>No kids found with the given age.</p>");
            }

            out.println("</body></html>");

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<html><body><h2>Error: " + e.getMessage() + "</h2></body></html>");
        }
    }
}
