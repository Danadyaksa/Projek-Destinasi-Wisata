/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author aksno
 */
public class modeltabeldatawisata extends AbstractTableModel{

    List<datawisata> dp;
    public modeltabeldatawisata(List<datawisata>dp) {
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA WISATA";
            case 2:
                return "DESKRIPSI";
            case 3:
                return "KATEGORI";
            case 4:
                return "KOTA";
            case 5:
                return "HARGA";
            case 6:
                return "RATING";
            case 7:
                return "Review";
            default:
                return null;
        }
    }
    

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getNama();
            case 2:
                return dp.get(row).getDeskripsi();
            case 3:
                return dp.get(row).getKategori();
            case 4:
                return dp.get(row).getKota();
            case 5:
                return dp.get(row).getHarga();
            case 6:
                return dp.get(row).getNilai();
            case 7:
                return dp.get(row).getReview();
            default:
                return null;
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
    if (columnIndex == 7) {
        return Object.class; // Wajib agar JButton bisa muncul
    }
    return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
    return column == 7; // Hanya kolom "Review" yang bisa diklik
    }
    
}


