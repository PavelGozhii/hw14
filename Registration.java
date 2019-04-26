import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = "/registration")
public class Registration extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ResultSet resultSet = dbConnection.getUser(login);
        try {
            if (resultSet.next()) {
                out.print("You already registered: " + login);
            } else {
                dbConnection.addUser(login, password);
                out.print("You registered, " + login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
