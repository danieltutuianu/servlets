import java.sql.*;

public class Db {

    static final String DB_URL = "jdbc:mysql://remotemysql.com/qkWmw4LFNu";

    static final String USER = "qkWmw4LFNu";
    static final String PASS = "RjLR038LDQ";
    private static Connection conn;
    private static Statement stmt;

    public static void doConnection() throws SQLException {
        if(conn == null) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

    public static Integer register(String username,String email, String password, String firstname, String lastname, String dob) {

        User user = null;

        try {
            doConnection();
            String registerString = "INSERT INTO" +
                    "       Users_v2 " +
                    "SET " +
                    "     username = '"+username+"' " +
                    "     ,email = '"+email+"' " +
                    "     ,password = '"+password+"' " +
                    "     ,firstname = '"+firstname+"' " +
                    "     ,lastname = '"+lastname+"' " +
                    "     ,dob = '"+dob+"' " +
                    "";

            String[] returnId = { "id" };
            PreparedStatement statement = conn.prepareStatement(registerString, returnId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                return null;
            }

            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
    public static User login(String username, String password) {

        User user = null;

        try {
            doConnection();
            stmt = conn.createStatement();
            String loginString = "" +
                    "SELECT * " +
                    "FROM " +
                    "       Users_v2 " +
                    "WHERE " +
                    "      (username = '" + username + "' OR email = '" + username + "' )" +
                    "  AND password = '" + password + "' " +
                    "LIMIT 1";

            System.out.println(loginString);
            ResultSet rs = stmt.executeQuery(loginString);


            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;

    }


    public static Boolean checkUsernameAvailability( String username) {

        try {
            doConnection();
            stmt = conn.createStatement();
            String loginString = "" +
                    "SELECT * " +
                    "FROM " +
                    "       Users_v2 " +
                    "WHERE " +
                    "      username = '" + username + "'" +
                    "LIMIT 1";

            System.out.println(loginString);
            ResultSet rs = stmt.executeQuery(loginString);


            if (rs.next()) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


        return true;
    }

    public static Boolean checkEmailAvailability( String email) {

        try {
            doConnection();
            stmt = conn.createStatement();
            String loginString = "" +
                    "SELECT * " +
                    "FROM " +
                    "       Users_v2 " +
                    "WHERE " +
                    "      email = '" + email + "'" +
                    "LIMIT 1";

            System.out.println(loginString);
            ResultSet rs = stmt.executeQuery(loginString);


            if (rs.next()) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


        return true;
    }
}
