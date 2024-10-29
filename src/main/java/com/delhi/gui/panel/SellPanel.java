package com.delhi.gui.panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.controller.SellCtr;
import com.delhi.entity.Sell;
import com.delhi.gui.*;

public class SellPanel extends JPanel {
    private SellCtr sellCtr;
    private Frame frm;

    private DefaultTableModel prodTblMod;
    private JTable prodTbl;
    private JButton backBtn;
    private JButton newSellBtn;

    public SellPanel(Frame frm) {
        sellCtr = new SellCtr();
        this.frm = frm;

        setLayout(null);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn = new JButton("Volver");
        newSellBtn = new JButton("Nuevo");
        initTblModel();
        prodTbl = new JTable(prodTblMod);

        backBtn.setBounds(0,0,99,30);
        newSellBtn.setBounds(101,0,99,30);
        prodTbl.setBounds(40,40,920,600);
    }

    private void addCmp() {
        add(backBtn);
        add(newSellBtn);
        add(prodTbl);
    }

    private void addActions() {
        backBtn.addActionListener(e -> frm.dispose());

        newSellBtn.addActionListener(e -> {
            Frame newSellFrm = new Frame(400,400);
            NewSellPanel newSellPanel = new NewSellPanel(newSellFrm);
            newSellFrm.add(newSellPanel);
        });
    }

    private void initTblModel() {
        String[] columnNames = {"Producto","Cliente","Met Pago", "Total"};
        prodTblMod = new DefaultTableModel(columnNames, 0);
        prodTblMod.addRow(columnNames);

        for(Sell sell: sellCtr.findAll()) {
            Object[] row = {
                sell.getProduct(),
                sell.getClient(),
                sell.getPaymentMethod(),
                sell.getSalePrice()
            };

            prodTblMod.addRow(row);
        }
    }
}
