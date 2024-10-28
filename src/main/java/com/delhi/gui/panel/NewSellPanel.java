package com.delhi.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Optional;

import javax.swing.*;

import com.delhi.entity.*;
import com.delhi.gui.*;
import com.delhi.controller.*;

public class NewSellPanel extends JPanel{
    private Frame frm;

    private JButton cancelBtn;
    private JButton submitBtn;

    private JLabel buyDateLbl;
    private JTextField buyDateTxt;

    private JLabel sellDateLbl;
    private JTextField sellDateTxt;

    private JLabel buyPriceLbl;
    private JTextField buyPriceTxt;

    private JLabel sellPriceLbl;
    private JTextField sellPriceTxt;

    private JLabel prodLbl;
    private DefaultComboBoxModel<Stock> prodMdList;
    private JComboBox<Stock> prodList;

    public NewSellPanel(Frame frm) {
        setLayout(null);
        this.frm = frm;

        initCmp();
        addCmp();
        addActions();
    }

    public NewSellPanel(Frame frm, Stock stock) {
        setLayout(null);
        this.frm = frm;

        initCmp(stock);
        addCmp();
        addActions();
    }

    private void initCmp() {
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Guardar");

        buyDateLbl = new JLabel("Fecha de Compra");
        buyDateTxt = new JTextField(LocalDate.now().toString());

        sellDateLbl = new JLabel("Fecha de Venta");
        sellDateTxt = new JTextField(LocalDate.now().toString());

        buyPriceLbl = new JLabel("Precio Compra: ");
        buyPriceTxt = new JTextField();

        sellPriceLbl = new JLabel("Precio Venta: ");
        sellPriceTxt = new JTextField();

        prodLbl = new JLabel("Precio Compra: ");
        initTblModel();
        prodList = new JComboBox<>(prodMdList);

        buyDateLbl.setBounds   (20,20,150,30);
        buyDateTxt.setBounds   (200,20,150,30);

        sellDateLbl.setBounds   (20,70,150,30);
        sellDateTxt.setBounds   (200,70,150,30);

        buyPriceLbl.setBounds(20,100,150,30);
        buyPriceTxt.setBounds(200,100,150,30);

        sellPriceLbl.setBounds(20,140,150,30);
        sellPriceTxt.setBounds(200,140,150,30);

        prodLbl.setBounds   (20,200,100,30);
        prodList.setBounds  (20,250,100,30);

        cancelBtn.setBounds (100,350,100,40);
        submitBtn.setBounds (200,350,100,40);
    }

    private void initCmp(Stock stock) {
        initCmp();
        buyDateTxt.setText(stock.getBuyDate().toString());
        buyPriceTxt.setText(Double.toString(stock.getBuyPrice()));
        prodMdList.setSelectedItem(stock);
    }

    private void addCmp() {
        add(cancelBtn);
        add(submitBtn);

        add(buyDateLbl);
        add(buyDateTxt);
        add(sellDateLbl);
        add(sellDateTxt);

        add(buyPriceLbl);
        add(buyPriceTxt);
        add(sellPriceLbl);
        add(sellPriceTxt);

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
                Optional<LocalDate> buyDate = getBuyDate();
                Optional<Double> buyPrice = getBuyPrice();

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
            }
        });
    }

    private void initTblModel() {
        prodMdList = new DefaultComboBoxModel<>();

        StockCtr stockCtr = new StockCtr();
        prodMdList.addAll(stockCtr.findAll());
    }

    private Optional<LocalDate> getBuyDate() {
        Optional<LocalDate> ret;
        try {
            ret = Optional.of(LocalDate.parse(buyDateTxt.getText()));
        } catch (Exception e) {
            ret = Optional.empty();
        }
        return ret;
    }

    private Optional<Double> getBuyPrice() {
        Optional<Double> ret;
        try {
            ret = Optional.of(Double.parseDouble(buyPriceTxt.getText()));
        } catch (Exception e) {
            ret = Optional.empty();
        }
        return ret;
    }
}
