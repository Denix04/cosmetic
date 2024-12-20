package com.delhi.gui.panel;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.Optional;

import javax.swing.*;

import com.delhi.entity.*;
import com.delhi.gui.*;
import com.delhi.gui.panel.util.Text;
import com.delhi.controller.*;

public class NewStockPanel extends JPanel{
    private Frame frm;

    private JButton cancelBtn;
    private JButton submitBtn;

    private JLabel buyDateLbl;
    private JTextField buyDateTxt;

    private JLabel buyPriceLbl;
    private JTextField buyPriceTxt;

    private JLabel prodLbl;
    private DefaultComboBoxModel<Product> prodMdList;
    private JComboBox<Product> prodList;

    public NewStockPanel(Frame frm) {
        setLayout(null);
        this.frm = frm;

        initCmp();
        addCmp();
        addActions();
    }

    private void initCmp() {
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Guardar");

        buyDateLbl = new JLabel("Fecha");
        buyDateTxt = new JTextField(LocalDate.now().toString());

        buyPriceLbl = new JLabel("Precio Compra: ");
        buyPriceTxt = new JTextField();

        prodLbl = new JLabel("Precio Compra: ");
        initTblModel();
        prodList = new JComboBox<>(prodMdList);

        buyDateLbl.setBounds   (20,20,150,30);
        buyDateTxt.setBounds   (200,20,150,30);

        buyPriceLbl.setBounds(20,100,150,30);
        buyPriceTxt.setBounds(200,100,150,30);

        prodLbl.setBounds   (20,100,100,30);
        prodList.setBounds  (20,150,100,30);

        cancelBtn.setBounds (100,350,100,40);
        submitBtn.setBounds (200,350,100,40);
    }

    private void addCmp() {
        add(cancelBtn);
        add(submitBtn);

        add(buyDateLbl);
        add(buyDateTxt);

        add(buyPriceLbl);
        add(buyPriceTxt);

        add(prodLbl);
        add(prodList);
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
                StockCtr stockCtr = new StockCtr();
                Optional<LocalDate> buyDate = Text.getDate(buyDateTxt);
                Optional<Double> buyPrice = Text.getDouble(buyPriceTxt);

                if(buyDate.isEmpty()) {
                    buyDateTxt.setText("");
                    return;
                }
                if(buyPrice.isEmpty()) {
                    buyPriceTxt.setText("");
                    return;
                }
                stockCtr.create(
                        new Stock((Product)prodMdList.getSelectedItem(),buyDate.get(), buyPrice.get()));

                frm.dispose();
            }
        });
    }

    private void initTblModel() {
        prodMdList = new DefaultComboBoxModel<>();

        ProductCtr prodCtr = new ProductCtr();
        prodMdList.addAll(prodCtr.findAll());
    }
}
