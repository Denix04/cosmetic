package com.delhi.gui.panel;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewProdPanel extends JPanel {

    private JFrame frm;

    private JLabel nameLbl;
    private JLabel brandLbl;
    private JLabel provLbl;
    private JLabel attrLbl;

    private JTextField nameTxt;
    private JTextField brandTxt;
    private JTextField provTxt;

    private DefaultTableModel attrTblMdl;
    private JTable attrTbl;

    private JButton saveBtn;
    private JButton cleanBtn;
    private JButton cnlBtn;

    public NewProdPanel(JFrame frm) {
        setLayout(null);
        setBackground(Color.white);
        this.frm = frm;

        nameLbl = new JLabel("Nombre: ");
        nameTxt = new JTextField();
        brandLbl = new JLabel("Marca: ");
        brandTxt = new JTextField();
        provLbl = new JLabel("Proveedor: ");
        provTxt = new JTextField();
        attrLbl = new JLabel("Agregar atributos:");

        saveBtn = new JButton("Guardar");
        cleanBtn = new JButton("Limpiar");
        cnlBtn = new JButton("Cancelar");

        initCmp();
        addCmp();
        addActions();
    }

    public void initCmp(){
        nameLbl.setBounds   (30,30,100,20); 
        nameTxt.setBounds   (150,30,200,20); 

        brandLbl.setBounds  (30,60,100,20); 
        brandTxt.setBounds  (150,60,200,20); 

        provLbl.setBounds   (30,90,100,20); 
        provTxt.setBounds   (150,90,200,20); 

        attrLbl.setBounds   (30,120,200,20); 

        saveBtn.setBounds   (30,360,100,30); 
        cleanBtn.setBounds  (150,360,100,30); 
        cnlBtn.setBounds    (270,360,100,30); 
    }

    public void addCmp(){
        add(nameLbl);   add(nameTxt);
        add(brandLbl);  add(brandTxt);
        add(provLbl);   add(provTxt);
        add(attrLbl);
        add(saveBtn);   add(cleanBtn);  add(cnlBtn);
    }

    public void addActions() {
        cnlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });
    }
}
