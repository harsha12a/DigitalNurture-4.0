import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class StudentDAO {
    public StudentDAO() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER NOT NULL)";
        try (Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:school.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // INSERT new student
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE student by ID
    public void updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Student Table ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " | " + name + " | " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Insert a new student
        studentDAO.insertStudent("Alice", 20);
        studentDAO.insertStudent("Bob", 22);

        // Update a student
        studentDAO.updateStudent(1, "Alice Smith", 21);

        // Retrieve all students
        studentDAO.getAllStudents();
    }
}