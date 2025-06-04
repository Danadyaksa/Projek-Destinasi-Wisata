/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatawisata;
import model.review;
import java.util.List;
/**
 *
 * @author LENOVO
 */

public interface reviewDAO {
    void insert(review r);
    List<review> getReviewsByWisataId(int id_wisata);
}