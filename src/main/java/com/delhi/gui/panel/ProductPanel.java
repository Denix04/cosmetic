package com.delhi.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductPanel extends JPanel {

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;
    private JButton backBtn;
    private Frame frm;

    public ProductPanel(Frame frm) {
        setLayout(null);

        this.frm = frm;

        backBtn = new JButton("Volver");
        initTblModel();
        prodTbl = new JTable(prodTblMod);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn.setBounds(0,0,100,30);
        prodTbl.setBounds(30, 30,500,500);
    }

    private void addCmp() {
        add(backBtn);
        add(prodTbl);
    }

    private void addActions() {

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });

    }

    private void initTblModel() {
        String[] columnNames = {"Producto","Marca","Provedor","Atributos"};
        prodTblMod = new DefaultTableModel(columnNames, 0);
        prodTblMod.addRow(columnNames);

        Object[] row1 = {"p","m","p","attr"};
        prodTblMod.addRow(row1);
    }
    
}
