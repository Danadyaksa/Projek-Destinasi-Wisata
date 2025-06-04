/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import DAOdatawisata.reviewDAO;
import model.review;
import java.sql.*;
import java.util.*;
import koneksi.connector;

/**
 *
 * @author LENOVO
 */

public class reviewDAOimplement implements reviewDAO {
    Connection conn = connector.connection();

    @Override
    public void insert(review r) {
        String sql = "INSERT INTO review (id_wisata, id_user, komentar, rating, gambar_path) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getId_wisata());
            ps.setInt(2, r.getId_user());
            ps.setString(3, r.getKomentar());
            ps.setInt(4, r.getRating());
            ps.setString(5, r.getGambar_path());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<review> getReviewsByWisataId(int id_wisata) {
        List<review> list = new ArrayList<>();
        // bisa ditambahkan nanti
        return list;
    }
}

