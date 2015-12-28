package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.Ciudad;

public class CiudadDB {

    public boolean grabar(Ciudad ciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO \"Ciudad\"(nombre)VALUES ('"+ciudad.getNombre()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return db.ingreso(query);
    }
    public int modificar(Ciudad ciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="UPDATE \"Ciudad\" SET \"idCiudad\"="+ciudad.getIdCiudad()+", nombre='"+ciudad.getNombre()+"'WHERE idciudad="+ciudad.getIdCiudad();
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public int eliminar(int idciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="delete from ciudad where idciudad=" + idciudad ;
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public Ciudad buscar(int idciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="select * from ciudad where idciudad =" + idciudad ;
        ResultSet resultado = db.seleccion(query);
        Ciudad ciudad=null;
        if (resultado!=null) {
            resultado.next();
            ciudad = new Ciudad();
            ciudad.setIdCiudad(resultado.getInt("idcedula"));
            ciudad.setNombre(resultado.getString("nombre"));
        }
        db.cerrarConexion();
        return ciudad;
    }
    public ArrayList listar() throws SQLException {
       OperacionesBase db = new OperacionesBase();
        String query="select * from ciudad ";
        ResultSet resultado = db.seleccion(query);
        Ciudad ciudad=null;
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            ciudad = new Ciudad();
            ciudad.setIdCiudad(resultado.getInt(1));
            ciudad.setNombre(resultado.getString(2));
            todos.add(ciudad);
        }
        db.cerrarConexion();
        return todos;
    }

}
