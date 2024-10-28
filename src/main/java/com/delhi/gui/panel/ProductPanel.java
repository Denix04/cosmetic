package com.delhi.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.gui.Frame;
import com.delhi.controller.*;
import com.delhi.entity.Product;

public class ProductPanel extends JPanel {

    private ProductCtr prodCtr;
    private Frame frm;

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;
    private JButton backBtn;
    private JButton newBtn;
    private JButton deleteBtn;

    public ProductPanel(Frame frm) {

        prodCtr = new ProductCtr();
        this.frm = frm;

        setLayout(null);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn = new JButton("Volver");
        newBtn = new JButton("Nuevo");
        deleteBtn = new JButton("Eliminar");

        initTblModel();
        prodTbl = new JTable(prodTblMod);

        backBtn.setBounds(0,0,99,30);
        newBtn.setBounds(101,0,99,30);
        deleteBtn.setBounds(201,0,99,30);
        prodTbl.setBounds(40,40,920,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newBtn);
        add(deleteBtn);
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

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletingFromTbl();
            }
        });
    }

    private void initTblModel() {
        String[] columnNames = {"Producto","Marca","Provedor","Atributos"};
        prodTblMod = new DefaultTableModel(columnNames, 0);
        prodTblMod.addRow(columnNames);

        for(Product elem : prodCtr.findAll()) {
            Object[] row = {elem,elem.getBrand(),elem.getProvider(),"..." };
            prodTblMod.addRow(row);
        }
    }

    private void deletingFromTbl() {
        int row = prodTbl.getSelectedRow();
        int col = prodTbl.getSelectedColumn();

        Product prod = (Product) prodTblMod.getValueAt(row, 0);
        Long prodId = prod.getId();
        prodCtr.delete(prodId);

        prodTblMod.removeRow(row);
    }
}
