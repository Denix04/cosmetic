package com.delhi.gui.panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delhi.controller.ClientCtr;
import com.delhi.entity.Client;
import com.delhi.gui.Frame;

public class ClientPanel extends JPanel {
    private Frame frm;

    private JButton backBtn;
    private JButton newBtn;

    private JScrollPane clientSP;

    public ClientPanel(Frame frm) {
        this.frm = frm;

        setLayout(null);

        initCmp();
        addCmp();
        addActions();
    }

    public void initCmp() {
        backBtn = new JButton("Volver");
        newBtn = new JButton("Nuevo");

        initClientSP();

        backBtn.setBounds   (0,0,99,30);
        newBtn.setBounds    (101,0,99,30);
        clientSP.setBounds  (40,40,920,600);
    }

    public void addCmp() {
        add(backBtn);
        add(newBtn);
        add(clientSP);
    }

    public void addActions() {
        backBtn.addActionListener(e -> frm.dispose());

        newBtn.addActionListener(e -> {
            Frame newClientFrm = new Frame(400, 400);
            NewClientPanel newClientPanel = new NewClientPanel(newClientFrm);
            newClientFrm.add(newClientPanel);
        });
    }

    public void initClientSP() {
        clientSP = new JScrollPane();

        ClientCtr clientCtr = new ClientCtr();

        for(Client client : clientCtr.findAll()) {
            JPanel clientPnl = new JPanel();
            JLabel clientName = new JLabel(client.toString());
            JButton clientPurchases = new JButton("Compras");
            clientPnl.add(clientName);
            clientPnl.add(clientPurchases);

            add(clientPnl);
        }
    }
    
}
