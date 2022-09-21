package pe.sis.elclan.Clases;

import java.util.ArrayList;

/**
 *
 * @author Victor Rosales Arones
 */
public class ventas {

    /* GENERAL*/
    private String v_usuario;
    private String v_fechaCreacion;
    private String v_estado;

    /* UNIDADES DE VENTAS */
    private String v_codUnidad;
    private String v_desUnidad;

    /*  EQUIPO DE VENTAS */
    private String v_codEquipo;
    private String v_desEquipo;

    /* CATEGORIAS VENDEDOR*/
    private String v_codCategoria;
    private String v_desCategoria;
    private ArrayList<ventas> listarCategoria;

    /* CONFIGURACION DE VARIABLES DE CATEGORIA DEL VENDEDOR*/
    private String v_codVariableCat = "";
    private String v_desVariableCat = "";
    private String v_codCondicion = "";
    private String v_desCondicion = "";
    private String v_simbolo = "";
    private String v_codMatriz = "";
    private String v_desMatriz = "";
    
    private String v_valorParm="";
    private String v_refValor="";
    private String v_prioridad="";
    private String v_catConf="";
    
    
    private ArrayList<ventas> v_listaVariableCat;
    private ArrayList<ventas> v_listaCtegoriaVariables;
    private ArrayList<ventas> listaCondicionVar;
    private ArrayList<ventas> listaRefValor;
    private ArrayList<ventas> listaConfVariables;

    /* VENDEDORES */
    private String v_nombres;
    private String v_apellidoPaterno;
    private String v_apellidoMaterno;
    private String v_tipoDocumento;
    private String v_des_documento;
    private String v_numDocumento;
    private String v_est_SMV;
    private String v_cargo;
    private String v_cod_Vendedor;

    /*PERSONAL DE VENTAS*/
    private ArrayList<ventas> listaVendedores;
    private ArrayList<ventas> listarUnidad;
    private ArrayList<ventas> listarEquipos;

    /* METODOS GET Y SET*/

    public String getV_valorParm() {
        return v_valorParm;
    }

    public void setV_valorParm(String v_valorParm) {
        this.v_valorParm = v_valorParm;
    }

    public String getV_refValor() {
        return v_refValor;
    }

    public void setV_refValor(String v_refValor) {
        this.v_refValor = v_refValor;
    }

    public String getV_prioridad() {
        return v_prioridad;
    }

    public void setV_prioridad(String v_prioridad) {
        this.v_prioridad = v_prioridad;
    }

   
    public String getV_catConf() {
        return v_catConf;
    }

    public void setV_catConf(String v_catConf) {
        this.v_catConf = v_catConf;
    }
    
    
    
    
    
    public ArrayList<ventas> getListaConfVariables() {
        return listaConfVariables;
    }

    public void setListaConfVariables(ArrayList<ventas> listaConfVariables) {
        this.listaConfVariables = listaConfVariables;
    }

    public ArrayList<ventas> getListaRefValor() {
        return listaRefValor;
    }

    public void setListaRefValor(ArrayList<ventas> listaRefValor) {
        this.listaRefValor = listaRefValor;
    }

    public String getV_codMatriz() {
        return v_codMatriz;
    }

    public void setV_codMatriz(String v_codMatriz) {
        this.v_codMatriz = v_codMatriz;
    }

    public String getV_desMatriz() {
        return v_desMatriz;
    }

    public void setV_desMatriz(String v_desMatriz) {
        this.v_desMatriz = v_desMatriz;
    }

    public ArrayList<ventas> getListaCondicionVar() {
        return listaCondicionVar;
    }

    public void setListaCondicionVar(ArrayList<ventas> listaCondicionVar) {
        this.listaCondicionVar = listaCondicionVar;
    }

    public String getV_codCondicion() {
        return v_codCondicion;
    }

    public void setV_codCondicion(String v_codCondicion) {
        this.v_codCondicion = v_codCondicion;
    }

    public String getV_desCondicion() {
        return v_desCondicion;
    }

    public void setV_desCondicion(String v_desCondicion) {
        this.v_desCondicion = v_desCondicion;
    }

    public String getV_simbolo() {
        return v_simbolo;
    }

    public void setV_simbolo(String v_simbolo) {
        this.v_simbolo = v_simbolo;
    }

    public ArrayList<ventas> getV_listaCtegoriaVariables() {
        return v_listaCtegoriaVariables;
    }

    public void setV_listaCtegoriaVariables(ArrayList<ventas> v_listaCtegoriaVariables) {
        this.v_listaCtegoriaVariables = v_listaCtegoriaVariables;
    }

    public String getV_codVariableCat() {
        return v_codVariableCat;
    }

    public void setV_codVariableCat(String v_codVariableCat) {
        this.v_codVariableCat = v_codVariableCat;
    }

    public String getV_desVariableCat() {
        return v_desVariableCat;
    }

    public void setV_desVariableCat(String v_desVariableCat) {
        this.v_desVariableCat = v_desVariableCat;
    }

    public ArrayList<ventas> getV_listaVariableCat() {
        return v_listaVariableCat;
    }

    public void setV_listaVariableCat(ArrayList<ventas> v_listaVariableCat) {
        this.v_listaVariableCat = v_listaVariableCat;
    }

    public String getV_codCategoria() {
        return v_codCategoria;
    }

    public void setV_codCategoria(String v_codCategoria) {
        this.v_codCategoria = v_codCategoria;
    }

    public String getV_desCategoria() {
        return v_desCategoria;
    }

    public void setV_desCategoria(String v_desCategoria) {
        this.v_desCategoria = v_desCategoria;
    }

    public void setListarCategoria(ArrayList<ventas> listarCategoria) {
        this.listarCategoria = listarCategoria;
    }

    public ArrayList<ventas> getListarCategoria() {
        return listarCategoria;
    }

    public ArrayList<ventas> getListarEquipos() {
        return listarEquipos;
    }

    public void setListarEquipos(ArrayList<ventas> listarEquipos) {
        this.listarEquipos = listarEquipos;
    }

    public ArrayList<ventas> getListarUnidad() {
        return listarUnidad;
    }

    public void setListarUnidad(ArrayList<ventas> listarUnidad) {
        this.listarUnidad = listarUnidad;
    }

    public ArrayList<ventas> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(ArrayList<ventas> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public String getV_nombres() {
        return v_nombres;
    }

    public void setV_nombres(String v_nombres) {
        this.v_nombres = v_nombres;
    }

    public String getV_usuario() {
        return v_usuario;
    }

    public void setV_usuario(String v_usuario) {
        this.v_usuario = v_usuario;
    }

    public String getV_fechaCreacion() {
        return v_fechaCreacion;
    }

    public void setV_fechaCreacion(String v_fechaCreacion) {
        this.v_fechaCreacion = v_fechaCreacion;
    }

    public String getV_estado() {
        return v_estado;
    }

    public void setV_estado(String v_estado) {
        this.v_estado = v_estado;
    }

    public String getV_codUnidad() {
        return v_codUnidad;
    }

    public void setV_codUnidad(String v_codUnidad) {
        this.v_codUnidad = v_codUnidad;
    }

    public String getV_desUnidad() {
        return v_desUnidad;
    }

    public void setV_desUnidad(String v_desUnidad) {
        this.v_desUnidad = v_desUnidad;
    }

    public String getV_codEquipo() {
        return v_codEquipo;
    }

    public void setV_codEquipo(String v_codEquipo) {
        this.v_codEquipo = v_codEquipo;
    }

    public String getV_desEquipo() {
        return v_desEquipo;
    }

    public void setV_desEquipo(String v_desEquipo) {
        this.v_desEquipo = v_desEquipo;
    }

    public String getV_apellidoPaterno() {
        return v_apellidoPaterno;
    }

    public void setV_apellidoPaterno(String v_apellidoPaterno) {
        this.v_apellidoPaterno = v_apellidoPaterno;
    }

    public String getV_apellidoMaterno() {
        return v_apellidoMaterno;
    }

    public void setV_apellidoMaterno(String v_apellidoMaterno) {
        this.v_apellidoMaterno = v_apellidoMaterno;
    }

    public String getV_tipoDocumento() {
        return v_tipoDocumento;
    }

    public void setV_tipoDocumento(String v_tipoDocumento) {
        this.v_tipoDocumento = v_tipoDocumento;
    }

    public String getV_des_documento() {
        return v_des_documento;
    }

    public void setV_des_documento(String v_des_documento) {
        this.v_des_documento = v_des_documento;
    }

    public String getV_numDocumento() {
        return v_numDocumento;
    }

    public void setV_numDocumento(String v_numDocumento) {
        this.v_numDocumento = v_numDocumento;
    }

    public String getV_est_SMV() {
        return v_est_SMV;
    }

    public void setV_est_SMV(String v_est_SMV) {
        this.v_est_SMV = v_est_SMV;
    }

    public String getV_cargo() {
        return v_cargo;
    }

    public void setV_cargo(String v_cargo) {
        this.v_cargo = v_cargo;
    }

    public String getV_cod_Vendedor() {
        return v_cod_Vendedor;
    }

    public void setV_cod_Vendedor(String v_cod_Vendedor) {
        this.v_cod_Vendedor = v_cod_Vendedor;
    }

}
