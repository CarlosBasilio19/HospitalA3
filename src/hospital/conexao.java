
package hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {
  
  public Connection conexaohosp() throws SQLException{ 
         Connection conn = null;  
         
        try {
         String url = "jdbc:mysql://localhost:3306/Hospital?user=root&password=";

conn = DriverManager.getConnection(url);
String newUser = "admin";
String query = "CREATE USER ?@'localhost' IDENTIFIED BY ?";
PreparedStatement pstmnt = conn.prepareStatement(query);
pstmnt.setString(1, newUser);
pstmnt.setString(2, "6363");
pstmnt.executeUpdate();

    
String grantQuery = "GRANT ALL PRIVILEGES ON Hospital.* TO ?@'localhost'";
PreparedStatement grantPstmt = conn.prepareStatement(grantQuery);
grantPstmt.setString(1, newUser);
grantPstmt.executeUpdate();

        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
        return conn;

         
         
  } 
}


