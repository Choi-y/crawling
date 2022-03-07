package Covid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbDAO {
    static void UploadToDB(ArrayList<CovidVO> CV) {
        String driver = "org.mariadb.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/**?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
        String user="root";
        String pw="12345";
        Connection con;
        String sql;

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, pw);
            if(con!=null)
            {
                System.out.println("접속 성공");
            }

            sql = "insert into covid(gu, num) values (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, CV.get(0).getGu());
            pst.setString(2, CV.get(0).getNum());
            pst.executeUpdate();

            System.out.println("Upload Complete");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
