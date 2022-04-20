package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        /* データベースURL */
        String url = "jdbc:mysql://localhost/test?characterEncoding=UTF-8&useSSL=false";

        /* データベースのユーザとパスワード */
        String user = "test";
        String password = "test";

        /* SQL文 */
        String sql = "UPDATE test1 SET name = ? WHERE id = ?";

        try {
            /* コネクション */
            Connection con = DriverManager.getConnection(url, user, password);
            /* ステートメント */
            PreparedStatement pstmt = con.prepareStatement(sql);

            // プレースホルダに値の設定
            pstmt.setString(1,"testX");
            pstmt.setInt(2,2);

            // SQL文の実行（更新）
            pstmt.executeUpdate();

            // SQL文の更新
            sql = "SELECT * FROM test1";

            /* ステートメント */
            pstmt = con.prepareStatement(sql);

            // SQL文の実行（参照）
            ResultSet res = pstmt.executeQuery();

            // ResultSetの操作
            while (res.next()) {
                // 実行結果の表示
                System.out.print("ID：" + res.getInt("id") + " ");
                System.out.print("名前：" + res.getString("name") + "\n");
            }
        } catch (SQLException e) {
            // SQLのエラー発生時の処理
            e.printStackTrace();
        }
    }
}