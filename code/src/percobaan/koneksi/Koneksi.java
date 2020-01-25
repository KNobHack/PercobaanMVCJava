package percobaan.koneksi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Fahmi
 */
public class Koneksi {
    static Connection con;
    public static Connection connection(){
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("java_mvc");
            data.setUser("root");
            data.setPassword("");
            try{
                con = data.getConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return con;
    }
}
