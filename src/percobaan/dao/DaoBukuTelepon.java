package percobaan.dao;

/**
 *
 * @author Fahmi
 */

import percobaan.koneksi.Koneksi;
import percobaan.model.Bukutelepon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoBukuTelepon implements ImplementBukuTelepon{
    Connection connection;
    final String insert = "INSERT INTO buku_telepon (nomor, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE buku_telepon set nomor = ? , nama = ?, alamat = ? WHERE id = ? ;";
    final String delete = "DELETE FROM buku_telepon WHERE id = ? ;";
    final String select = "SELECT * FROM buku_telepon;";
    final String cari  = "SELECT * FROM buku_telepon WHERE nama LIKE ? OR alamat LIKE ? OR nomor LIKE ?;";
    public DaoBukuTelepon(){
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert (Bukutelepon b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getNomor());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setId(rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void update (Bukutelepon b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getNomor());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getAlamat());
            statement.setInt(4, b.getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setId(rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete (int id){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public List<Bukutelepon> getALL(){
        List<Bukutelepon> lb = null;
        try{
            lb = new ArrayList<Bukutelepon>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Bukutelepon b = new Bukutelepon();
                b.setId(rs.getInt("id"));
                b.setNomor(rs.getString("nomor"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(DaoBukuTelepon.class.getName()).log(Level.SEVERE,null,e);
        }
        return lb;
    }
    
    @Override
    public List<Bukutelepon> getCari(String cari){
        List<Bukutelepon> lb = null;
        try{
            lb = new ArrayList<Bukutelepon>();
            PreparedStatement st = connection.prepareStatement(this.cari);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            Bukutelepon b = new Bukutelepon();
                b.setId(rs.getInt("id"));
                b.setNomor(rs.getString("nomor"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        }catch(SQLException e){
            Logger.getLogger(DaoBukuTelepon.class.getName()).log(Level.SEVERE,null,e);
        }
        return lb;
    }
}
