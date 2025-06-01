import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    public AccountDAO() {
        // Initialize the database connection
        try (Connection conn = connect()) {
            // Create table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "balance REAL NOT NULL DEFAULT 0.0)";
            conn.createStatement().execute(createTableSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:bank.db");
    }

    public void transfer(int fromId, int toId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = connect()) {
            conn.setAutoCommit(false); // Start transaction

            try (
                    PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                    PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {
                // Debit
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();

                // Credit
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();

                // If both succeed, commit
                conn.commit();
                System.out.println("Transfer successful!");

            } catch (SQLException e) {
                System.out.println("Transfer failed, rolling back.");
                conn.rollback(); // Rollback on error
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBalances() {
        try (Connection conn = connect();
                var stmt = conn.createStatement();
                var rs = stmt.executeQuery("SELECT * FROM accounts")) {

            System.out.println("\n--- Account Balances ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println(id + " | " + name + " | $" + balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();

        // Show balances before transfer
        dao.showBalances();

        // Perform a transfer: Alice (id=1) sends $100 to Bob (id=2)
        dao.transfer(1, 2, 100.0);

        // Show balances after transfer
        dao.showBalances();
    }
}