/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author aksno
 */
public class connector {
    static Connection con;
    
    public static Connection connection(){
        if (con==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("wisata_db");
            data.setUser("root");
            data.setPassword("");
            try{
                con = data.getConnection();
                System.out.println("Koneksi Berhasil");
            }catch(SQLException ex){
                 ex.printStackTrace();
                 System.out.println("Koneksi Gagal");
            }
        }
     
        return con;
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
