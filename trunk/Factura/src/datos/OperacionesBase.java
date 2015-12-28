/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oza
 */
public class OperacionesBase {
    DatabaseManager db = new DatabaseManager();

	public boolean ingreso (String query) throws SQLException
	{		
		Connection var= db.getConnection();
		Statement stmt = var.createStatement();
		boolean resultado=stmt.execute(query);
		var.commit();
                
		return resultado;
	}
	 
	public ResultSet seleccion (String query) throws SQLException
	{		
		Connection var= db.getConnection();
		Statement stmt = var.createStatement();
		ResultSet resultado=stmt.executeQuery(query);
                var.commit();
		return resultado;
	}
	 public int modificacioneliminacion (String query) throws SQLException
	{		
		Connection var= db.getConnection();
		Statement stmt = var.createStatement();
		int resultado=stmt.executeUpdate(query);
                var.commit();
		return resultado;
	}
	 
	public void cerrarConexion() throws SQLException{
		db.getConnection().close();
	}
}
