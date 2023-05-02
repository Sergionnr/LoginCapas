package com.mayab.desarrollo.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.main.HibernateUtil;

public class DAOUsuario implements iUsuarioDAO {

	public int createUser(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la sesión de la libreria
		session.beginTransaction(); //inicia la creación de la acción
		int id = (int) session.save(usuario); //Crea, regresa la llave primaria y dice que se va a referir a tal usuario
		session.getTransaction().commit(); //ejecuta la acción
		session.close(); //cierra la conexión con la base de datos
		return id;
	}

	public boolean deleteUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario u = session.get(Usuario.class, id); //Decirle a qué usuario se refiere ya que necesita el objeto, no el id
		session.delete(u); //Elimina y dice que se va a referir a tal usuario
		session.getTransaction().commit();
		session.close();
		return true;
	}

	
	public Usuario findByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario user = session.get(Usuario.class, id); //Regresa el usuario
		session.close();
		return user;
		//No usa tranasaction porque no actualiza la informacióin de la base de datos
		//Aquí solo se usa el session.get para obtener la información y regresarla
	}

	
	public List<Usuario> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = session.createQuery("FROM Usuario").list();
		session.close();
		return lista;
		//Cuando queremos regresar un cconjunto de datos o bajo una condición específica, es decir, requerir de un query, se debe usar esta implementación refiriendose a los nombres de las clases, no de la base de datos
	}

	
	public Usuario updatePassword(Usuario usuario, String nuevaPassword) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Usuario toUpdate = session.get(Usuario.class, usuario.getId()); //Regresa el usuario que se quiere actualizar para modificarlo aquí
		toUpdate.setPassword(nuevaPassword); //Se actualiza desde aquí el usuario
		session.getTransaction().commit(); //Se manda el usuario nuevo para actializarlo a la base de datos
		session.close();
		return toUpdate;
	}
	
	public Usuario findByName(String name) {
		Usuario user = new Usuario();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("FROM Usuario WHERE nombre =:nombre").setParameter("nombre", name);
		try {
			user = (Usuario) qry.getSingleResult();
		}
		catch(NoResultException e) {
			user = null;
		}
		session.close();
		return user;
		//No usa tranasaction porque no actualiza la informacióin de la base de datos
		//Aquí solo se usa el session.get para obtener la información y regresarla
	}
	
	public Usuario findByMail(String mail) {
		Usuario user = new Usuario();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("FROM Usuario WHERE email =:email").setParameter("email", mail);
		try {
			user = (Usuario) qry.getSingleResult();
		}
		catch(NoResultException e) {
			user = null;
		}
		session.close();
		return user;
	}
}
