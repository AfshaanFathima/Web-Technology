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

            out.println("<html><body><h2>Names of Kids with Age " + request.getParameter("age") + "</h2>");
            while (rs.next()) {
                out.println("<p>" + rs.getString("Name") + "</p>");
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
