package pe.sis.elclan.DAO;

import pe.sis.elclan.Clases.ventas;

/**
 *
 * @author sistemas03 yasub huaman
 */
public interface ventasDAO {
   
    /* EQUIPOS DE VENTAS*/
    public String darBajaEquipo(String codUnidad, String codEquipo) throws Exception;
    public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo) throws Exception;
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) throws Exception;
    public ventas listarEquipos(String codUnidad, String codEquipo) throws Exception;
    
    /* UNIDADES DE VENTAS*/
    public String darBajaUnidad(String codUnidad) throws Exception;
    public String actualizarUnidad(String codUnidad, String desUnidad, String usuario) throws Exception;
    public String guardarUnidad(String desUnidad, String usuario) throws Exception;
    public ventas listarUnidades(String codUnidad) throws Exception;
}
