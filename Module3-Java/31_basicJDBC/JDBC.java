import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JdbcSQLite {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:school.db"; // Database path

        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connected to the database.");

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)");
            stmt.executeUpdate("INSERT INTO students (name, age) VALUES ('Alice', 20), ('Bob', 22)");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Print results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " | " + name + " | " + age);
            }

            // Close everything
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}