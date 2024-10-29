package com.delhi.gui.panel;

import com.delhi.controller.StockCtr;
import com.delhi.entity.*;
import com.delhi.gui.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockPanel extends JPanel {
    private StockCtr stockCtr;
    private Frame frm;

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;

    private JButton backBtn;
    private JButton newStockBtn;
    private JButton sellBtn;
    private JButton deleteBtn;

    public StockPanel(Frame frm) {

        stockCtr = new StockCtr();
        this.frm = frm;

        setLayout(null);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn = new JButton("Volver");
        newStockBtn = new JButton("Nuevo");
        sellBtn = new JButton("Vender");
        deleteBtn = new JButton("Eliminar");

        backBtn.setBounds(0,0,99,30);
        newStockBtn.setBounds(101,0,99,30);
        sellBtn.setBounds(201,0,99,30);
        deleteBtn.setBounds(301,0,99,30);

        initTblModel();
        prodTbl = new JTable(prodTblMod);
        prodTbl.setBounds(40, 40,920,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newStockBtn);
        add(sellBtn);
        add(prodTbl);
    }

    private void addActions() {

        backBtn.addActionListener(e -> frm.dispose());

        newStockBtn.addActionListener(e -> {
            Frame nsf = new Frame(400,400);
            NewStockPanel nsp = new NewStockPanel(nsf);
            nsf.add(nsp);
        });

        sellBtn.addActionListener(e -> sellFromTbl());

        deleteBtn.addActionListener(e -> deletingFromTbl());
    }

    private void initTblModel() {
        String[] columnNames = {"Fecha Compra", "Producto","Atributos"};
        prodTblMod = new DefaultTableModel(columnNames, 0);
        prodTblMod.addRow(columnNames);

        for(Stock stock : stockCtr.findAll()) {
            Object[] row = {stock.getBuyDate(), stock, stock.getProduct().getProvider(),"..."};
            prodTblMod.addRow(row);
        }
    }

    private void deletingFromTbl() {
        int row = prodTbl.getSelectedRow();

        Stock prod = (Stock) prodTblMod.getValueAt(row, 1);
        Long prodId = prod.getId();
        stockCtr.delete(prodId);

        prodTblMod.removeRow(row);
    }

    private void sellFromTbl() {
        int row = prodTbl.getSelectedRow();
        Stock stock = (Stock) prodTblMod.getValueAt(row, 1);
        Long stockId = stock.getId();

        Frame sellFrame = new Frame(400, 400);
        NewSellPanel sellPanel = new NewSellPanel(sellFrame, stock);
        sellFrame.add(sellPanel);

        stockCtr.delete(stockId);
        prodTblMod.removeRow(row);
    }
}
