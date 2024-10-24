package com.delhi.gui.panel;

import com.delhi.controller.StockCtr;
import com.delhi.entity.*;
import com.delhi.gui.Frame;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockPanel extends JPanel {
    private Frame frm;

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;

    private JButton backBtn;
    private JButton newStockBtn;

    public StockPanel(Frame frm) {
        setLayout(null);

        this.frm = frm;


        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn = new JButton("Volver");
        newStockBtn = new JButton("Nuevo");

        backBtn.setBounds(0,0,100,30);
        newStockBtn.setBounds(101,0,100,30);

        initTblModel();
        prodTbl = new JTable(prodTblMod);
        prodTbl.setBounds(40, 40,920,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newStockBtn);
        add(prodTbl);
    }

    private void addActions() {

        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });

        newStockBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(400,400);
                NewStockPanel nsp = new NewStockPanel(frm);
                frm.add(nsp);
            }
        });
    }

    private void initTblModel() {
        String[] columnNames = {"Fecha Compra", "Producto","Atributos"};
        prodTblMod = new DefaultTableModel(columnNames, 0);
        prodTblMod.addRow(columnNames);

        StockCtr stockCtr = new StockCtr();

        for(Stock stock : stockCtr.findAll()) {
            Object[] row = {stock.getBuyDate(), stock, stock.getProduct().getProvider(),"..."};
            prodTblMod.addRow(row);
        }
    }
    
    
}
