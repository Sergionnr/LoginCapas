package com.mayab.desarrollo.servicios;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistencia.DAOUsuario;

public class UsuarioServicio {
	private DAOUsuario dao;
	
	public UsuarioServicio(DAOUsuario d) {
		dao = d;
	}
	
	public boolean login(String user, String pass) {
		boolean result = false;
		Usuario usuario = dao.findByName(user);
		if(usuario != null) {
			if(usuario.getPassword().equals(pass)) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean crearUsuario(String nombre, String mail, String pass) {
		boolean result = false;
		Usuario a = dao.findByName(nombre);
		Usuario b = dao.findByMail(mail);
		if(a == null && b == null) {
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setEmail(mail);
			u.setPassword(pass);
			int usuario = dao.createUser(u);
			result = true;
		}
		return result;
	}
	
	public String recuperarPassword(String nombre, String mail) {
		String pass = null;
		Usuario a = dao.findByName(nombre);
		if(a != null && a.getEmail().equals(mail)) {
			System.out.println("Se le mando un correo con su password");
			pass = a.getPassword();
		}
		return pass;
	}
	public boolean changePassword(String name, String antiguaPassword, String nuevaPassword){
        Usuario usuario;
        if(login(name, antiguaPassword)){
            usuario = dao.findByName(name);
            dao.updatePassword(usuario, nuevaPassword);
            return true;
        }
        else{
            return false;
        }
    }
}
