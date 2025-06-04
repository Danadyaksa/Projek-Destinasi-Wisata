/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatawisata;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.datawisataimplement;

public class datawisataDAO implements datawisataimplement {
    Connection connection;
    
    final String select = "SELECT * FROM destinasi_wisata_indonesia";
    final String insert = "INSERT INTO destinasi_wisata_indonesia (Place_Name, Description, Category, City, Price, Rating) VALUES (?, ?, ?, ?, ?, ?)";
    final String update = "UPDATE destinasi_wisata_indonesia SET Place_Name=?, Description=?, Category=?, City=?, Price=?, Rating=? WHERE Place_Id=?";
    final String delete = "DELETE FROM destinasi_wisata_indonesia WHERE Place_Id=?";
    
    public datawisataDAO(){
        connection = connector.connection();
    }

    
    @Override
    public void insert(datawisata p) {
        try (PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, p.getNama());
            statement.setString(2, p.getDeskripsi());
            statement.setString(3, p.getKategori());
            statement.setString(4, p.getKota());
            statement.setString(5, p.getHarga());
            statement.setString(6, p.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                p.setId(rs.getInt(1));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(datawisata p) {
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setString(1, p.getNama());
            statement.setString(2, p.getDeskripsi());
            statement.setString(3, p.getKategori());
            statement.setString(4, p.getKota());
            statement.setString(5, p.getHarga());
            statement.setString(6, p.getNilai());
            statement.setInt(7, p.getId());
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<datawisata> getAll() {
        List<datawisata> dp = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datawisata wisata = new datawisata();
                wisata.setId(rs.getInt("Place_Id"));
                wisata.setNama(rs.getString("Place_Name"));
                wisata.setDeskripsi(rs.getString("Description"));
                wisata.setKategori(rs.getString("Category"));
                wisata.setKota(rs.getString("City"));
                wisata.setHarga(rs.getString("Price"));
                wisata.setNilai(rs.getString("Rating"));
                dp.add(wisata);
            }
        } catch(SQLException ex){
            Logger.getLogger(datawisataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }

    @Override
    public List<datawisata> search(String keyword, String Category) {
        List<datawisata> dp = new ArrayList<>();
        try {
            String query = "SELECT * FROM destinasi_wisata_indonesia WHERE " + Category + " LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                datawisata wisata = new datawisata();
                wisata.setId(rs.getInt("Place_Id"));
                wisata.setNama(rs.getString("Place_Name"));
                wisata.setDeskripsi(rs.getString("Description"));
                wisata.setKategori(rs.getString("Category"));
                wisata.setKota(rs.getString("City"));
                wisata.setHarga(rs.getString("Price"));
                wisata.setNilai(rs.getString("Rating"));
                dp.add(wisata);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(datawisataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
    
    
}
