package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import cliente.*;
import dominio.Personaje;

public class Conector {

	private String url = "primeraBase.bd";
	Connection connect;

	public void connect() {
		try {
			Servidor.log.append("Estableciendo conexión con la base de datos..." + System.lineSeparator());
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			Servidor.log.append("Conexión con la base de datos establecida con éxito." + System.lineSeparator());
		} catch (SQLException ex) {
			Servidor.log.append("Fallo al intentar establecer la conexión con la base de datos. " + ex.getMessage() + System.lineSeparator());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			Servidor.log.append("Error al intentar cerrar la conexión con la base de datos." + System.lineSeparator());
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public boolean registrarUsuario(Usuario user) {
		ResultSet result = null;
		try {
			PreparedStatement st1 = connect.prepareStatement("select * from registro where usuario= ? ");
			st1.setString(1, user.getNombreUsuario());
			result = st1.executeQuery();

			if (!result.next()) {

				PreparedStatement st = connect.prepareStatement("insert into registro (usuario, password, idPersonaje) values (?,?,?)");
				st.setString(1, user.getNombreUsuario());
				st.setString(2, user.getPassword());
				st.setInt(3, user.getIdPj());
				st.execute();
				Servidor.log.append("El usuario " + user.getNombreUsuario() + " se ha registrado." + System.lineSeparator());
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			Servidor.log.append("El usuario " + user.getNombreUsuario() + " ya se encuentra en uso." + System.lineSeparator());
			System.err.println(ex.getMessage());
			return false;
		}

	}

	public boolean registrarPersonaje(Personaje p1, Usuario u1) {

		try {
			PreparedStatement st = connect.prepareStatement(
					"insert into personaje (idInventario, idMochila,casta,raza,fuerza,destreza,inteligencia,saludTope,energiaTope,nombre,experiencia,nivel,idAlianza) values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			st.setInt(1, -1);
			st.setInt(2, -1);
			st.setString(3, p1.getCasta().getNombreCasta());
			st.setString(4, p1.getNombreRaza());
			st.setInt(5, p1.getFuerza());
			st.setInt(6, p1.getDestreza());
			st.setInt(7, p1.getInteligencia());
			st.setInt(8, p1.getSaludTope());
			st.setInt(9, p1.getEnergiaTope());
			st.setString(10, p1.getNombre());
			st.setInt(11, 0);
			st.setInt(12, 1);
			st.setInt(13, -1);
			st.execute();

			ResultSet rs = st.getGeneratedKeys();
			if (rs != null && rs.next()) {
				int idPersonaje = rs.getInt(1);

				p1.setIdPersonaje(idPersonaje);

				PreparedStatement st3 = connect.prepareStatement("update registro set idPersonaje=? where usuario=? and password=?");
				st3.setInt(1, idPersonaje);
				st3.setString(2, u1.getNombreUsuario());
				st3.setString(3, u1.getPassword());
				st3.execute();
				if (this.registrarInventarioMochila(idPersonaje)) {
					Servidor.log.append("El usuario " + u1.getNombreUsuario() + " ha creado el personaje " + p1.getIdPersonaje() + System.lineSeparator());
					return true;
				}
			}
			return false;

		} catch (SQLException e) {
			Servidor.log.append("Error al intentar crear el personaje " + p1.getNombre() + System.lineSeparator());
			e.printStackTrace();
			return false;
		}

	}

	public boolean registrarInventarioMochila(int idInventarioMochila) {
		try {
			PreparedStatement st1 = connect.prepareStatement(
					"insert into inventario(idInventario,manos1,manos2,pie,cabeza,pecho,accesorio) values (?,-1,-1,-1,-1,-1,-1)");
			st1.setInt(1, idInventarioMochila);
			PreparedStatement st2 = connect.prepareStatement(
					"insert into mochila(idMochila,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20) values(?,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)");
			st2.setInt(1, idInventarioMochila);

			st1.execute();
			st2.execute();

			PreparedStatement st3 = connect.prepareStatement("update personaje set idInventario=? where idPersonaje=?");
			st3.setInt(1, idInventarioMochila);
			st3.setInt(2, idInventarioMochila);

			PreparedStatement st4 = connect.prepareStatement("update personaje set idMochila=? where idPersonaje=?");
			st4.setInt(1, idInventarioMochila);
			st4.setInt(2, idInventarioMochila);

			st3.execute();
			st4.execute();
			Servidor.log.append("Se ha registrado el inventario de " + idInventarioMochila + System.lineSeparator());
			return true;

		} catch (SQLException e) {
			Servidor.log.append("Error al registrar el inventario de " + idInventarioMochila + System.lineSeparator());
			e.printStackTrace();
			return false;
		}
	}

	public boolean loguearUsuario(Usuario user) {
		ResultSet result = null;
		try {
			PreparedStatement st = connect
					.prepareStatement("select * from registro where usuario = ? AND password = ? ");
			st.setString(1, user.getNombreUsuario());
			st.setString(2, user.getPassword());
			result = st.executeQuery();

			if (result.next()) {
				Servidor.log.append("El usuario " + user.getNombreUsuario() + " ha iniciado sesión." + System.lineSeparator());
				return true;
			}

			return false;

		} catch (SQLException e) {
			Servidor.log.append("El usuario " + user.getNombreUsuario() + " fallo al iniciar sesión." + System.lineSeparator());
			e.printStackTrace();
			return false;
		}

	}

	public PaquetePersonaje getPersonaje(Usuario user) {
		ResultSet result = null;
		try {
			PreparedStatement st = connect.prepareStatement("select * from registro where usuario = ?");
			st.setString(1, user.getNombreUsuario());
			result = st.executeQuery();
			int idPersonaje = result.getInt("idPersonaje");
			
			st = connect.prepareStatement("select * from personaje where idPersonaje = ?");
			st.setInt(1, idPersonaje);
			result = st.executeQuery();
			String raza = result.getString("raza");

			PaquetePersonaje personaje = new PaquetePersonaje();
			personaje.setIdPersonaje(idPersonaje);
			personaje.setNombreRaza(raza);
		
			return personaje;
			
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
		return new PaquetePersonaje(-1, null, -1, -1, -1);
	}
}
