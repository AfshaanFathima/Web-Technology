import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        
        // Fetch the selected radio button value
        String selectedAnimal = request.getParameter("animal");
        
        // Generate HTML response
        PrintWriter out = response.getWriter();
        String title = "Animal Selection";
        
        out.println("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<title>" + title + "</title>\n" +
            "<style>\n" +
            "    body {\n" +
            "        background-color: #fce4ec; /* Soft pink background */\n" +
            "        font-family: 'Comic Sans MS', sans-serif; /* Fun and playful font */\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    h1 {\n" +
            "        color: #ff66b2; /* Pink title */\n" +
            "        font-size: 36px;\n" +
            "    }\n" +
            "    p {\n" +
            "        font-size: 24px;\n" +
            "        color: #ff3385; /* Darker pink for the selected animal text */\n" +
            "    }\n" +
            "    .button {\n" +
            "        font-size: 18px;\n" +
            "        padding: 10px 20px;\n" +
            "        background-color: #ff66b2;\n" +
            "        color: white;\n" +
            "        border: none;\n" +
            "        border-radius: 5px;\n" +
            "        cursor: pointer;\n" +
            "    }\n" +
            "    .button:hover {\n" +
            "        background-color: #ff3385; /* Darker pink on hover */\n" +
            "    }\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <h1>" + title + "</h1>\n" +
            "    <p><b>You selected:</b> " + 
            (selectedAnimal != null ? selectedAnimal : "No animal selected") + "</p>\n" +
            "    <a href=\"javascript:history.back()\"><button class=\"button\">Go Back</button></a>\n" +
            "</body>\n" +
            "</html>"
        );
    }
}
