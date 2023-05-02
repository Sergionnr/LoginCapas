package com.mayab.desarrollo.vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mayab.desarrollo.persistencia.*;
import com.mayab.desarrollo.servicios.UsuarioServicio;
public class CambiarPassword extends JFrame implements ActionListener{

    //initialize button, panel, label, and text field
    JButton b1, b2;
    JPanel newPanel;
    JLabel userLabel, oldPassLabel, newPassLabel;
    final JTextField  textField1, textField2, textField3;

    public CambiarPassword() throws HeadlessException {
        //public
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Password");
        setSize(300,100);
        userLabel = new JLabel();
        userLabel.setText("Username");
        textField1 = new JTextField(15); 
        oldPassLabel = new JLabel();
        oldPassLabel.setText("Password Orignial");
        textField2 = new JPasswordField(15);  
        newPassLabel = new JLabel();
        newPassLabel.setText("Nueva Password");  
        textField3 = new JPasswordField(15);   
        b1 = new JButton("Guardar");
        b2 = new JButton("Cancelar");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(oldPassLabel);
        newPanel.add(textField2);
        newPanel.add(newPassLabel);  
        newPanel.add(textField3); 
        newPanel.add(b1);       
        newPanel.add(b2);        
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);   
        setTitle("Cambiar password");      
    }
    

    public void cancelChanges(){
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userValue = textField1.getText();    
        String oldPassValue = textField2.getText();   
        String newPassValue = textField3.getText();    

        DAOUsuario dao = new DAOUsuario();
        UsuarioServicio servicio = new UsuarioServicio(dao);


        //check whether the credentials are authentic or not
        if (servicio.changePassword(userValue, oldPassValue, newPassValue)) {  //if authentic, navigate user to a new page

            NewPage page = new NewPage();

            page.setVisible(true);

            JLabel wel_label = new JLabel("Se ha actualizado su password");
            page.getContentPane().add(wel_label);
        }
        else{
            System.out.println("Por favor, reingrese su password");
        }
    }
}