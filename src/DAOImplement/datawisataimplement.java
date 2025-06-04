/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author rska
 */
public interface datawisataimplement {
    public void insert(datawisata p);
    public void update(datawisata p);
    public void delete(int id);
    public List<datawisata> getAll();
    public List<datawisata> search(String keyword, String Category); // Tambahan
}
