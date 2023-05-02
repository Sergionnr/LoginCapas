package com.mayab.desarrollo.persistencia;
import com.mayab.desarrollo.entities.Usuario;

import java.util.List;

public interface iUsuarioDAO {
	public int createUser(Usuario usuario); //Crear el usuario, regresa el id
	public boolean deleteUser(int id);
	public Usuario findByID(int id);
	public List<Usuario> findAll();
	public Usuario updatePassword(Usuario  usuario, String nuevaPassword);
	public Usuario findByName(String name);
	public Usuario findByMail(String mail);
}
