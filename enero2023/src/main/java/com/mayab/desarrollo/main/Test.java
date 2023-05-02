package com.mayab.desarrollo.main;

import org.hibernate.Session;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistencia.DAOUsuario;
import com.mayab.desarrollo.servicios.UsuarioServicio;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		DAOUsuario dao = new DAOUsuario();
		/*
		Usuario user = new Usuario();
		user.setNombre("UsuarioDAO");
		user.setEmail("mail@mail.mail");	
		user.setPassword("Constrasena");
		int idUser = dao.createUser(user);
		user.setId(idUser);
		
		Usuario user2 = new Usuario();
		user2.setNombre("UsuarioDAO2");
		user2.setEmail("mail2@mail.mail");
		user2.setPassword("Constrasena2");
		int idUser2 = dao.createUser(user2);
		user2.setId(idUser2);
		
		
		//Delete
		dao.deleteUser(2);
		
		//Update
		dao.updatePassword(user, "passwordNueva100");
		
		//find
		List<Usuario> lista = dao.findAll();
		for(Usuario u : lista) {
			System.out.println("ID: " + u.getId());
			System.out.println("Nombre: " + u.getNombre());
			System.out.println("Password: " + u.getPassword());
			System.out.println();
		}
		*/
		//
		
		Usuario userU = new Usuario();
		userU.setNombre("UsuarioUnico1");
		userU.setEmail("mailUnico1@mail.mail");
		userU.setPassword("123456");
		
		UsuarioServicio servicio = new UsuarioServicio(dao);
		boolean isCreate = servicio.crearUsuario(userU.getNombre(), userU.getEmail(),userU.getPassword());
		System.out.println("Result = " + isCreate);
		
		String cont = servicio.recuperarPassword(userU.getNombre(), userU.getEmail());
		System.out.println("Result = " + cont);
		
	}
}
