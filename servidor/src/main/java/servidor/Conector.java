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
	//private String url = "C:\\Users\\Nicolas\\primeraBase.bd";
	Connection connect;

	public void connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public boolean registrarUsuario(Usuario user) {// la tabla se llama registro
		ResultSet result = null;
		try {
			PreparedStatement st1 = connect.prepareStatement("select * from registro where usuario= ? ");
			st1.setString(1, user.getNombre_usuario());
			result = st1.executeQuery();

			if (!result.next()) {

				PreparedStatement st = connect
						.prepareStatement("insert into registro (usuario, password, idPersonaje) values (?,?,?)");
				st.setString(1, user.getNombre_usuario());
				st.setString(2, user.getPassword_usuario());
				st.setInt(3, user.getIdPj());
				st.execute();
				// System.out.println("Se registro al usuario!");
				return true;
			} else {
				// System.out.println("Ya se usa ese user");
				return false;
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			// System.out.println("User repetido");
			return false;
		}

	}
	
	
	public boolean registrarPersonaje(Personaje p1,Usuario u1) {

		try {
			
			PreparedStatement st = connect.prepareStatement(
					"insert into personaje (idInventario, idMochila,casta,raza,fuerza,destreza,inteligencia,saludTope,energiaTope,nombre,experiencia,nivel,idAlianza) values (?,?,?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
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
			if (rs != null && rs.next()) 
				{ int idPersonaje = rs.getInt(1);
			
			
			 PreparedStatement st3 = connect.prepareStatement("update registro set idPersonaje=? where usuario=? and password=?");
			st3.setInt(1, idPersonaje);
			st3.setString(2, u1.getNombre_usuario());
			st3.setString(3, u1.getPassword_usuario());
			st3.execute();
			if(this.registrarInventarioMochila(idPersonaje))
				return true;
			}
				return false;
		
			} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

	public boolean registrarInventarioMochila(int idInventarioMochila) {
		ResultSet result = null;
		try {
	
			PreparedStatement st1 = connect.prepareStatement("insert into inventario(idInventario,manos1,manos2,pie,cabeza,pecho,accesorio) values (?,-1,-1,-1,-1,-1,-1)");
			st1.setInt(1, idInventarioMochila);
		     PreparedStatement st2 = connect.prepareStatement("insert into mochila(idMochila,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20) values(?,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)");
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
		    return true;
		    
			
			
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean loguearUsuario(Usuario user) {
		ResultSet result = null;
		try {
			PreparedStatement st = connect
					.prepareStatement("select * from registro where usuario = ? AND password = ? ");
			st.setString(1, user.getNombre_usuario());
			st.setString(2, user.getPassword_usuario());
			result = st.executeQuery();

			if (result.next()) {
				// System.out.println("Se logueo!");
				return true;
			}
			// System.out.println("No se logueo!");

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void mostrarUsuarios() {
		ResultSet result = null;
		try {
			PreparedStatement st = connect.prepareStatement("select * from registro");
			result = st.executeQuery();
			while (result.next()) {
				System.out.print("Usuario:");
				System.out.println(result.getString("usuario"));

				System.out.print("Password: ");
				System.out.println(result.getString("password"));

				System.out.print("ID Personaje: ");
				System.out.println(result.getInt("idPersonaje"));

				System.out.println("=======================");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void borrarRegistro() {
		try {
			PreparedStatement st = connect.prepareStatement("delete from registro");
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
