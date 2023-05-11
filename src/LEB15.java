import java.sql.*;

public class LEB15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "mysql@sit";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData= result.getMetaData();

            for (int i= 1; i<= rsMetaData.getColumnCount(); i++){
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
                System.out.println();
            }
                while (result.next()) {
                    for (int i= 1; i<= rsMetaData.getColumnCount(); i++)
                        System.out.printf("%-12s\t", result.getObject(i));
                    System.out.println();}
                connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
