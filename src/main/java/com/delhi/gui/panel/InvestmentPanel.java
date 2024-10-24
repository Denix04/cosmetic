package com.delhi.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.gui.Frame;
import com.delhi.controller.*;
import com.delhi.entity.Investment;
import com.delhi.entity.Product;

public class InvestmentPanel extends JPanel {

    private DefaultTableModel invsTblMod;
    private JTable invsTbl;
    private JButton backBtn;
    private JButton newBtn;
    private Frame frm;

    public InvestmentPanel(Frame frm) {
        setLayout(null);

        this.frm = frm;

        backBtn = new JButton("Volver");
        newBtn = new JButton("Nuevo");
        initTblModel();
        invsTbl = new JTable(invsTblMod);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn.setBounds(0,0,100,30);
        newBtn.setBounds(101,0,100,30);
        invsTbl.setBounds(40,40,920,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newBtn);
        add(invsTbl);
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
        //TODO change for Investements
        String[] columnNames = {"fecha", "monto", "description"};
        invsTblMod = new DefaultTableModel(columnNames, 0);
        invsTblMod.addRow(columnNames);

        //Investment pc = new Investment();

        //for(Investment elem : pc.findAll()) {
            //Object[] row = {};
            //invsTblMod.addRow(row);
        //}
    }
    
}
