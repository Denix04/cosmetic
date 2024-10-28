package com.delhi.gui.panel;

import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.controller.ProductCtr;
import com.delhi.entity.Product;
import com.delhi.gui.Frame;

public class NewProdPanel extends JPanel {

    private JFrame frm;

    private JLabel nameLbl;
    private JLabel brandLbl;
    private JLabel provLbl;

    private JTextField nameTxt;
    private JTextField brandTxt;
    private JTextField provTxt;

    private DefaultTableModel attrTblMdl;
    private JTable attrTbl;
    private JButton newAttrBtn;

    private JButton saveBtn;
    private JButton cleanBtn;
    private JButton cnlBtn;

    public NewProdPanel(JFrame frm) {

        setLayout(null);
        setBackground(Color.white);
        this.frm = frm;

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp(){
        nameLbl = new JLabel("Nombre: ");
        nameTxt = new JTextField();
        brandLbl = new JLabel("Marca: ");
        brandTxt = new JTextField();
        provLbl = new JLabel("Proveedor: ");
        provTxt = new JTextField();

        saveBtn = new JButton("Guardar");
        cleanBtn = new JButton("Limpiar");
        cnlBtn = new JButton("Cancelar");

        newAttrBtn = new JButton("Agregar Attributo");
        initTblModel();
        attrTbl = new JTable(attrTblMdl);
        nameLbl.setBounds   (30,30,100,20); 
        nameTxt.setBounds   (150,30,200,20); 

        brandLbl.setBounds  (30,60,100,20); 
        brandTxt.setBounds  (150,60,200,20); 

        provLbl.setBounds   (30,90,100,20); 
        provTxt.setBounds   (150,90,200,20); 

        newAttrBtn.setBounds(30,120,200,20);
        attrTbl.setBounds   (30,150,190,100);

        saveBtn.setBounds   (30,360,100,30); 
        cleanBtn.setBounds  (150,360,100,30); 
        cnlBtn.setBounds    (270,360,100,30); 
    }

    private void addCmp(){
        add(nameLbl);   add(nameTxt);
        add(brandLbl);  add(brandTxt);
        add(provLbl);   add(provTxt);
        add(newAttrBtn);add(attrTbl);
        add(saveBtn);   add(cleanBtn);  add(cnlBtn);
    }

    private void addActions() {
        cnlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });

        newAttrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(400,400);
                NewProdAttrPanel pap = new NewProdAttrPanel(frm, attrTblMdl);
                frm.add(pap);
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String,String> attr = new HashMap<>();

                for(int i = 1; i<attrTblMdl.getRowCount(); i++) {
                    attr.put(attrTblMdl.getValueAt(i, 0).toString(), 
                             attrTblMdl.getValueAt(i, 1).toString());
                }
                ProductCtr prodCtr = new ProductCtr();
                prodCtr.create(new Product(attr,nameTxt.getText(),brandTxt.getText(),provTxt.getText()));
                frm.dispose();
            }
        });

        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTxt.setText("");
                brandTxt.setText("");
                provTxt.setText("");
                for(int i = 1; i<attrTblMdl.getRowCount(); i++)
                    attrTblMdl.removeRow(i);
            }
        });
    }

    private void initTblModel() {
        String[] columnNames = {"Atributo","Valor"};
        attrTblMdl = new DefaultTableModel(columnNames, 0);
        attrTblMdl.addRow(columnNames);
    }
}
