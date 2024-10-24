package com.delhi.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.gui.Frame;
import com.delhi.controller.*;
import com.delhi.entity.Investment;
import com.delhi.entity.Product;

public class FinancePanel extends JPanel {

    private DefaultTableModel fncTblMod;
    private JTable fncTbl;
    private JButton backBtn;
    private JButton newBtn;
    private JButton invBtn;
    private Frame frm;

    public FinancePanel(Frame frm) {
        setLayout(null);

        this.frm = frm;

        backBtn = new JButton("Volver");
        newBtn = new JButton("Nuevo");
        invBtn = new JButton("Inversiones");
        initTblModel();
        fncTbl = new JTable(fncTblMod);

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        backBtn.setBounds(1,0,99,30);
        newBtn.setBounds(101,0,99,30);
        invBtn.setBounds(201,0,99,30);
        fncTbl.setBounds(40,40,920,500);
    }

    private void addCmp() {
        add(backBtn);
        add(newBtn);
        add(invBtn);
        add(fncTbl);
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

        invBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frm = new Frame(1000, 700);
                InvestmentPanel fp = new InvestmentPanel(frm);
                frm.add(fp);
            }
        });

    }

    private void initTblModel() {
        //TODO change for Finance
        String[] columnNames = {"Temporalidad",  "Neto", "Ganancia"};
        fncTblMod = new DefaultTableModel(columnNames, 0);
        fncTblMod.addRow(columnNames);

        //Investment pc = new Investment();

        //for(Investment elem : pc.findAll()) {
            //Object[] row = {};
            //fncTblMod.addRow(row);
        //}
    }
    
}
