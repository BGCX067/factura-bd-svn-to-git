package negocio;

import datos.CiudadDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ciudad {
    private int idCiudad;
    private String nombre;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void grabar() {
        try {
            CiudadDB ciudadDB = new CiudadDB();
            ciudadDB.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() {
        try {
        CiudadDB ciudadDB = new CiudadDB();
            ciudadDB.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        try {
        CiudadDB ciudad = new CiudadDB();
            ciudad.eliminar(this.idCiudad);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar() {
        try {
            Ciudad aux;
            CiudadDB ciudadDB = new CiudadDB();
            aux = ciudadDB.buscar(this.idCiudad);
        setNombre(aux.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
