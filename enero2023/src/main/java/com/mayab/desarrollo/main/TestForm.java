package com.mayab.desarrollo.main;

import javax.swing.JOptionPane;

import com.mayab.desarrollo.vistas.LoginForm;

public class TestForm {

	public static void main(String[] args) {
		try {
			LoginForm form = new LoginForm();
			form.setSize(300,100);
			form.setVisible(true);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
