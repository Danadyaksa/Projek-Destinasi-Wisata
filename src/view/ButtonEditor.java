/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import javax.swing.JCheckBox;

/**
 *
 * @author LENOVO
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private JTable table;
    private boolean clicked;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        button = new JButton("Review");
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // penting supaya getCellEditorValue dipanggil
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    button.setText("Review"); // pastikan tombol tetap muncul
    clicked = true;
    return button;
}

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            int selectedRow = table.getSelectedRow();
            Object id = table.getValueAt(selectedRow, 0); // Ambil ID dari kolom pertama
            table.setRowSelectionInterval(selectedRow, selectedRow);
            new ReviewForm().setVisible(true);
        }
        clicked = false;
        return "Review";
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
