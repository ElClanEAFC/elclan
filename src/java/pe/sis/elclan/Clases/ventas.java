
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
    private String v_usuarioCreacion;  
    private String v_estado;
    
    /*ORGANIGRAMA DE VENTAS*/
    private String v_datos;
    private String v_datosVen;
    private String v_numero;
    
    /* UNIDADES DE VENTAS */
    private String v_codUnidad;
    private String v_desUnidad;
        
   /*  EQUIPO DE VENTAS */
    private String v_codEquipo;
    private String v_desEquipo;
    
    /* VENDEDORES */
    private String v_apellidoPaterno;
    private String v_apellidoMaterno;
    private String v_tipoDocumento;
    private String v_des_documento;
    private String v_numDocumento;
    private String v_est_SMV;
    private String v_cargo;
    private String v_cod_Vendedor;  
    
    /* ORGANIGRAMA */
    private String v_codPerfil;
    private String v_desPerfil;
    private String v_codArea;
    private String v_desArea;
    private String v_codEstructura;
    private String v_numOrden;
    
    /* LISTAS */
    private ArrayList<ventas> listUnidades;
    private ArrayList<ventas> listEquipos;
    private ArrayList<ventas> listPerfilesComer;
    private ArrayList<ventas> listEstrucutraEquipos;
    private ArrayList<ventas> listEstrucutraEquipoDatos;
    private ArrayList<ventas> listVendedoresSinCargo;
    private ArrayList<ventas> listDiagramaVentas;
    private ArrayList<ventas> listEstrucutraUnidades;
    private ArrayList<ventas> listEstrucutraUnidadDatos;
    
    /* METODOS GET Y SET*/

    public ArrayList<ventas> getListEstrucutraUnidades() {
        return listEstrucutraUnidades;
    }

    public void setListEstrucutraUnidades(ArrayList<ventas> listEstrucutraUnidades) {
        this.listEstrucutraUnidades = listEstrucutraUnidades;
    }

    public ArrayList<ventas> getListEstrucutraUnidadDatos() {
        return listEstrucutraUnidadDatos;
    }

    public void setListEstrucutraUnidadDatos(ArrayList<ventas> listEstrucutraUnidadDatos) {
        this.listEstrucutraUnidadDatos = listEstrucutraUnidadDatos;
    }
        
    public ArrayList<ventas> getListDiagramaVentas() {
        return listDiagramaVentas;
    }

    public void setListDiagramaVentas(ArrayList<ventas> listDiagramaVentas) {
        this.listDiagramaVentas = listDiagramaVentas;
    }    
    
    public String getV_numero() {
        return v_numero;
    }

    public void setV_numero(String v_numero) {
        this.v_numero = v_numero;
    }
        
    public String getV_datos() {
        return v_datos;
    }

    public void setV_datos(String v_datos) {
        this.v_datos = v_datos;
    }

    public String getV_datosVen() {
        return v_datosVen;
    }

    public void setV_datosVen(String v_datosVen) {
        this.v_datosVen = v_datosVen;
    }
    
    public String getV_desArea() {
        return v_desArea;
    }

    public void setV_desArea(String v_desArea) {
        this.v_desArea = v_desArea;
    }
    
    public ArrayList<ventas> getListVendedoresSinCargo() {
        return listVendedoresSinCargo;
    }

    public void setListVendedoresSinCargo(ArrayList<ventas> listVendedoresSinCargo) {
        this.listVendedoresSinCargo = listVendedoresSinCargo;
    }
    
    public String getV_codEstructura() {
        return v_codEstructura;
    }

    public void setV_codEstructura(String v_codEstructura) {
        this.v_codEstructura = v_codEstructura;
    }

    public String getV_numOrden() {
        return v_numOrden;
    }

    public void setV_numOrden(String v_numOrden) {
        this.v_numOrden = v_numOrden;
    }
    
    public String getV_codPerfil() {
        return v_codPerfil;
    }

    public void setV_codPerfil(String v_codPerfil) {
        this.v_codPerfil = v_codPerfil;
    }

    public String getV_desPerfil() {
        return v_desPerfil;
    }

    public void setV_desPerfil(String v_desPerfil) {
        this.v_desPerfil = v_desPerfil;
    }

    public String getV_codArea() {
        return v_codArea;
    }

    public void setV_codArea(String v_codArea) {
        this.v_codArea = v_codArea;
    }
        
    public ArrayList<ventas> getListPerfilesComer() {
        return listPerfilesComer;
    }

    public void setListPerfilesComer(ArrayList<ventas> listPerfilesComer) {
        this.listPerfilesComer = listPerfilesComer;
    }

    public ArrayList<ventas> getListEstrucutraEquipos() {
        return listEstrucutraEquipos;
    }

    public void setListEstrucutraEquipos(ArrayList<ventas> listEstrucutraEquipos) {
        this.listEstrucutraEquipos = listEstrucutraEquipos;
    }

    public ArrayList<ventas> getListEstrucutraEquipoDatos() {
        return listEstrucutraEquipoDatos;
    }

    public void setListEstrucutraEquipoDatos(ArrayList<ventas> listEstrucutraEquipoDatos) {
        this.listEstrucutraEquipoDatos = listEstrucutraEquipoDatos;
    }    
        
    public ArrayList<ventas> getListUnidades() {
        return listUnidades;
    }

    public void setListUnidades(ArrayList<ventas> listUnidades) {
        this.listUnidades = listUnidades;
    }

    public ArrayList<ventas> getListEquipos() {
        return listEquipos;
    }

    public void setListEquipos(ArrayList<ventas> listEquipos) {
        this.listEquipos = listEquipos;
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

    public String getV_usuarioCreacion() {
        return v_usuarioCreacion;
    }

    public void setV_usuarioCreacion(String v_usuarioCreacion) {
        this.v_usuarioCreacion = v_usuarioCreacion;
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
