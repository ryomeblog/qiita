package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) {
		try {
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost/test?characterEncoding=UTF-8",
		               "test",
		               "test"
		               );
		       Statement st = conn.createStatement();
		       ResultSet rs = st.executeQuery("select * from test1");

		       while(rs.next()) {
		           int id = rs.getInt("id");
		           String name = rs.getString("name");
		           System.out.println("ID："+id+" 名前:"+name);
		       }
		       rs.close();
		       st.close();
		       conn.close();
		       System.exit(0);
		   } catch (ClassNotFoundException e) {
		       System.out.println("ドライバを読み込めませんでした "+ e);
		   } catch (SQLException e) {
		       System.out.println("データベース接続エラー"+ e);
		   }
	}
}