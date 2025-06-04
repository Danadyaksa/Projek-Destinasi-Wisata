package controller;

import java.util.List;
import DAOdatawisata.datawisataDAO;
import model.*;
import view.MainView;
import DAOImplement.datawisataimplement;
import javax.swing.JTable;
// import javax.swing.JOptionPane; // Jika perlu

public class datawisatacontroller {
    MainView frame; // Untuk MainView
    datawisataimplement impldatawisata;
    List<datawisata> dp;

    // KONSTRUKTOR (1): Untuk MAINVIEW - JANGAN DIUBAH DARI KODEMU
    public datawisatacontroller(MainView frame) {
        this.frame = frame;
        this.impldatawisata = new datawisataDAO(); // Sesuai kodemu
        // dp = impldatawisata.getAll(); // Pemanggilan data di isitabel() saja
    }

    // KONSTRUKTOR (2): BARU, Untuk USERVIEW
    public datawisatacontroller() {
        this.impldatawisata = new datawisataDAO();
        this.frame = null; // Tidak ada MainView frame untuk UserView
    }

    public void isitabel(JTable targetTable) { // <--- METHOD INI HARUS ADA
        dp = impldatawisata.getAll();
        modeltabeldatawisata mp = new modeltabeldatawisata(dp);
        targetTable.setModel(mp);
    }
    // METHOD UNTUK MAINVIEW - JANGAN DIUBAH DARI KODEMU
    public void isitabel() {
        if (this.frame == null) {
            System.err.println("Controller: frame MainView null di isitabel()");
            return;
        }
        dp = impldatawisata.getAll();
        modeltabeldatawisata mp = new modeltabeldatawisata(dp);
        frame.getTableData().setModel(mp);
    }

    // METHOD UNTUK MAINVIEW - JANGAN DIUBAH DARI KODEMU
    public void search(String keyword, String Category) {
        if (this.frame == null) {
            System.err.println("Controller: frame MainView null di search()");
            return;
        }
        dp = impldatawisata.search(keyword, Category); // Sesuai DAO: search(keyword, Category)
        modeltabeldatawisata mp = new modeltabeldatawisata(dp);
        frame.getTableData().setModel(mp);
    }

    // METHOD CRUD UNTUK MAINVIEW - JANGAN DIUBAH DARI KODEMU
    public void insert() {
        if (this.frame == null) return;
        datawisata data = new datawisata();
        data.setNama(frame.getJTxtjudul().getText());
        data.setDeskripsi(frame.getJTxtgenre().getText());
        data.setKategori(frame.getJTxtpenulis().getText());
        data.setKota(frame.getJTxtpenerbit().getText());
        data.setHarga(frame.getJTxtlokasi().getText());
        data.setNilai(frame.getJTxtstok().getText()); // Di MainView.java kamu ini JTxtrating tapi di model datawisata itu setNilai()
        impldatawisata.insert(data);
    }

    public void update() {
        if (this.frame == null) return;
        datawisata data = new datawisata();
        data.setId(Integer.parseInt(frame.getJTxtid().getText()));
        data.setNama(frame.getJTxtjudul().getText());
        data.setDeskripsi(frame.getJTxtgenre().getText());
        data.setKategori(frame.getJTxtpenulis().getText());
        data.setKota(frame.getJTxtpenerbit().getText());
        data.setHarga(frame.getJTxtlokasi().getText());
        data.setNilai(frame.getJTxtstok().getText()); // Di MainView.java kamu ini JTxtrating tapi di model datawisata itu setNilai()
        impldatawisata.update(data);
    }

    public void delete() {
        if (this.frame == null) return;
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldatawisata.delete(id);
    }


    // === METHOD BARU KHUSUS UNTUK USERVIEW ===

    /**
     * Mengisi JTable pada UserView dengan semua data destinasi.
     * @param targetTable JTable yang ada di UserView.
     */
    public void isiTabelUntukUserView(JTable targetTable) {
        dp = impldatawisata.getAll();
        modeltabeldatawisata mp = new modeltabeldatawisata(dp);
        targetTable.setModel(mp);
    }

    /**
     * Melakukan pencarian untuk UserView dan mengisi JTable-nya.
     * @param targetTable JTable yang ada di UserView.
     * @param keyword Kata kunci pencarian.
     * @param category Kategori pencarian.
     */
    public void cariUntukUserView(JTable targetTable, String keyword, String category) {
        if (category == null || category.isEmpty()) {
            isiTabelUntukUserView(targetTable);
            return;
        }
        if (keyword.isEmpty()) {
            isiTabelUntukUserView(targetTable);
            return;
        }
        dp = impldatawisata.search(keyword, category); // Menggunakan method search dari DAO
        modeltabeldatawisata mp = new modeltabeldatawisata(dp);
        targetTable.setModel(mp);
    }
}