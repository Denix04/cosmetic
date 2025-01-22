package com.delhi.gui.panel;

import javax.swing.*;

import com.delhi.controller.ClientCtr;
import com.delhi.entity.Client;
import com.delhi.gui.Frame;

public class NewClientPanel extends JPanel {
    private Frame frm;

    private JButton cancelBtn;
    private JButton submitBtn;

    private JLabel nameLbl;
    private JTextField nameTxt;

    private JLabel surnameLbl;
    private JTextField surnameTxt;

    public NewClientPanel(Frame frm) {
        this.frm = frm;
        setLayout(null);

        initCmp();
        addCmp();
        addActions();
    }

    public void initCmp() {
        cancelBtn = new JButton("Cancelar");
        submitBtn = new JButton("Guardar");

        nameLbl = new JLabel("Nombre");
        nameTxt = new JTextField();

        surnameLbl = new JLabel("Apellido");
        surnameTxt = new JTextField();

        nameLbl.setBounds   (30,30,100,30);
        nameTxt.setBounds   (150,30,100,30);
        surnameLbl.setBounds(30,60,100,30);
        surnameTxt.setBounds(150,60,100,30);

        cancelBtn.setBounds (30,300,100,40);
        submitBtn.setBounds (200,300,100,40);
    }

    public void addCmp() {
        add(nameLbl);
        add(nameTxt);
        add(surnameLbl);
        add(surnameTxt);
        add(cancelBtn);
        add(submitBtn);

    }

    public void addActions() {
        cancelBtn.addActionListener(e -> frm.dispose());

        submitBtn.addActionListener(e -> {
            ClientCtr clientCtr = new ClientCtr();
            clientCtr.create(
                    new Client(nameTxt.getText(),surnameTxt.getText()));
            frm.dispose();
        });

    }
    
}
