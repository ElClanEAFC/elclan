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
    
    /*PERSONAL DE VENTAS*/
    public ventas listaVendedores(int codVendedor, int codUnidad,int codEquipo ) throws Exception;
    public ventas listaUnidad(int codUnidad) throws Exception;
    public ventas listaEquipos(int codEquipo ,int codUnidad) throws Exception;

    
    
    /* PERSONAL DE VENTAS CATEGORIA*/
    public ventas listarCategoria(int codCategoria) throws Exception;
    public String registroCategoria(String desCategoria,String Usuario) throws Exception;
    public String ActualizarCategoria(int codCategoria,String desCategoria,String Usuario) throws Exception;
    public String darBajaCategoria(int codCategoria,String desCategoria,String Usuario) throws Exception;
    
   /* PERSONAL DE VENTAS CONFIGURACION DE CATEGORIA*/
    public String registroVariCategoria(String desVariableCat,String usuario) throws Exception;
    public ventas listaVariCategoria(int codVariableCat) throws Exception;
    public String actualizarVariCategoria(int codVariableCat,String desVariableCat,String usuario)throws Exception;
    public String darBajaVariCategoria(int codVariableCat,String usuario) throws Exception;
    public ventas listaVariablesCat(int codVariableCat) throws Exception;
    public ventas listaCondicionVar()throws Exception;
    public ventas listaValoresVar()throws Exception;
    public String registrarConfig(int cod_categoria,int cod_Variable,int cod_Condicion,int camValor, int paramValor,String usuario)throws Exception;
    public String prioridadVariable(int codVariableCat,int cod_categoria, String usuario)throws Exception;
    public ventas listaConfVariables(int cod_categoria)throws Exception;
    public String darBajaConfVariables(int cod_categoria,int codVariableCat, String usuario)throws Exception;
     
   
    
    
    
    
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
