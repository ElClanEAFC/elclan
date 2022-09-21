package pe.sis.elclan.DAO;

import pe.sis.elclan.Clases.ventas;

/**
 *
 * @author sistemas03 yasub huaman
 */
public interface ventasDAO {
    
    
    /* ORGANIGRAMA UNIDADES*/
        public String darbajaEstructuraUnidad(String codEstructura, String usuario ) throws Exception;
        public String actualizarEstructuraUnidad(String codEstructura, String codPerfil, String numOrden, String usuario) throws Exception;
    public ventas listarEstructuraUnidadDatos(String codEstructura) throws Exception; /* PARA CASOS DE ACTUALIZAR*/
    public ventas listarEstructuraUnidades(String codUnidad) throws Exception;
    public String registrarEstructuraUnidad(String codUnidad, String codPerfil, String numOrden, String usuario) throws Exception;
    
    /* ORGANIGRAMA GENERAL DE VENTAS*/
    public ventas listarDiagramaVentas() throws Exception;
    
    /* ORGANIGRAMA EQUIPOS*/
    public String guardarVendEstruc(String codVendedor, String codEstructura, String fecInicio, String usuario) throws Exception;
    public ventas listarVendSinCargo(String codPerfil, String codUnidad, String codEquipo) throws Exception;
    
    public String darbajaEstructuraEquipo(String codEstructura, String usuario ) throws Exception;
    public String actualizarEstructuraEquipo(String codEstructura, String codPerfil, String numOrden, String usuario) throws Exception;
    public ventas listarEstructuraEquipoDatos(String codEstructura) throws Exception; /* PARA CASOS DE ACTUALIZAR*/
    public ventas listarEstructuraEquipos(String codEquipo) throws Exception;
    public String registrarEstructuraEquipo(String codEquipo, String codPerfil, String numOrden, String usuario) throws Exception;
    
    public ventas listarPerfilesComer() throws Exception;
   
    /* EQUIPOS DE VENTAS*/
    public String darBajaEquipo(String codUnidad, String codEquipo) throws Exception;
    public String actualizarEquipo(String codUnidad, String codEquipo, String desEquipo) throws Exception;
    public String guardarEquipo(String desEquipo, String codUnidad, String usuario) throws Exception;
    public ventas listarEquipos(String codEquipo, String codUnidad) throws Exception;
    
    /* UNIDADES DE VENTAS*/
    public String darBajaUnidad(String codUnidad) throws Exception;
    public String actualizarUnidad(String codUnidad, String desUnidad, String usuario) throws Exception;
    public String guardarUnidad(String desUnidad, String usuario) throws Exception;
    public ventas listarUnidades(String codUnidad) throws Exception;
}
