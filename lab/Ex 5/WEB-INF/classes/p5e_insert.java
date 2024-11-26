import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p5e_insert extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KidsApp", "root", "");

            String sql = "INSERT INTO kids1 (Name, Age) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setInt(2, Integer.parseInt(request.getParameter("age")));

            pstmt.executeUpdate();
            out.println("<html><body><h2>Data Inserted Successfully!</h2></body></html>");

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<html><body><h2>Error: " + e.getMessage() + "</h2></body></html>");
        }
    }
}