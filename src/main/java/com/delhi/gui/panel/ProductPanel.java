package com.delhi.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.gui.Frame;

public class ProductPanel extends JPanel {

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;
    private JButton backBtn;
    private JButton newBtn;
    private Frame frm;

    public ProductPanel(Frame frm) {
        setLayout(null);

        this.frm = frm;

        backBtn = new JButton("Volver");
        newBtn = new JButton("Nuevo");
        initTblModel();
        prodTbl = new JTable(prodTblMod);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn.setBounds(0,0,100,30);
        newBtn.setBounds(101,0,100,30);
        prodTbl.setBounds(30, 30,500,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newBtn);
        add(prodTbl);
    }

    private void addActions() {

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame newFrm = new Frame(400,400);
                NewProdPanel npp = new NewProdPanel(newFrm);
                newFrm.add(npp);
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
