import java.sql.*;

public class DBConnection {

    private final String url = "jdbc:postgresql://localhost:5432/hw14";
    private final String user = "postgres";
    private final String password = "root";


    public Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw14", "postgres", "root");
            System.out.println("Connection to the PostgreSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void addUser(String login, String password) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.connect();
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO users VALUES ('" + login + "','" + password + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getAllUsers() {
        ResultSet rs = null;
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.connect();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users";
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getUser(String login) {
        ResultSet resultSet = null;
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.connect();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE login = '" + login + "';";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
