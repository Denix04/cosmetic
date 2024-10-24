package com.delhi.gui.panel;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.gui.Frame;

public class newProdAttrPanel extends JPanel {

    private Frame frm;
    private DefaultTableModel table;

    private JLabel attrLbl;
    private JLabel valorLbl;

    private JTextField attrText;
    private JTextField valorText;

    private JButton submitBtn;
    private JButton cancelBtn;

    public newProdAttrPanel(Frame frm, DefaultTableModel table) {
        setLayout(null);
        this.frm = frm;
        this.table = table;

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        attrLbl = new JLabel("Attributo:");
        valorLbl = new JLabel("Valor:");

        attrText = new JTextField();
        valorText = new JTextField();

        submitBtn = new JButton("Agregar");
        cancelBtn = new JButton("Cancelar");

        attrLbl.setBounds(30,30,100,30);
        valorLbl.setBounds(30,80,100,30);

        attrText.setBounds(150,30,100,30);
        valorText.setBounds(150,80,100,30);

        submitBtn.setBounds(200,140,100,40);
        cancelBtn.setBounds(30,140,100,40);
    }

    private void addCmp() {
        add(attrLbl);
        add(valorLbl);
        add(attrText);
        add(valorText);
        add(submitBtn);
        add(cancelBtn);
    }

    private void addActions() {
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] row = {attrText.getText(), valorText.getText()};
                table.addRow(row);
                frm.dispose();
            }
        });
    }
    
}
