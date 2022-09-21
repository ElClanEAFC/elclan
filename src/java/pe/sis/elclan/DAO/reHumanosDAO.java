/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.Clases.mantenimiento;

/**
 *
 * @author bcondori
 */
public interface reHumanosDAO {
    public reHumanos listaJustificacion(String codAsistDet) throws SQLException;
    public mantenimiento listarAreasSede(String codSede) throws SQLException;
    public String registroSedeUsuario(String codUsuario, String codSede, String usuario) throws Exception;
    public String darBajaExperienciaLab(String codExperiencia) throws Exception;
    public reHumanos listaExperienciasLab(String codUsuario) throws Exception;
    public String registroExperienciaLab(String codUsuario, String codPuesto, String descripcion, String fecIni, String fecFin, String codPersona, String usuario ) throws Exception;
    public reHumanos listaEmpresaLab() throws Exception;
    public reHumanos listaPuestoLab() throws Exception;
    // REPORTES DE ASISTENCIAS
    public reHumanos justificarAsistencia(String codVende, String codAsistDet, String fecha,  String usuario, String obs)throws Exception;
    public reHumanos generarReportAsistencia(String fecha,String codBanco,String modDeposito, String codTplanilla, String usuario)throws Exception;
    public reHumanos listarAsistenciaDiario(String Fecha, String datos, String estado) throws Exception;
    public reHumanos confirmarCargaAsistencia(String fecha, String fecFin, String usuario)throws Exception;
    public String guardarAsistenciaTmp(String dni, String fecha)throws Exception;
    public reHumanos cargaAsistencia(String fecIni, String fecFin)throws Exception;
    // FIN REPORTES DE ASISTENCIAS
    
    public String desactivarUsuario(String codUsuario, String usuario) throws Exception;
    public String darBajaUsuario(String codUsuario,String codMotCese,String fecCese)throws Exception;
    public reHumanos listaMotivoBaja() throws Exception;
    public reHumanos listaUsuarios() throws Exception;
    public String desactivarCargoUsuario(String codUserPerfil, String codUser, String codPerfil, String observacion, String usuario)throws Exception;
    public reHumanos listaCargosUsuario(String codUser) throws Exception;
    public String asignarCargoUsuario(String codUsuario, String codPerfil, String usuario) throws Exception;
    public String actualizarUsuarios(String codUsuario, String usuNombre, String usuPaterno,String usuMaterno, String codTDoc,String numDoc, String codPais,String codDpto, String codProv, String codDist, String usuCelular,String usuCorreo, String usuDirec,String usuSucursal, String usuFNac, String usuario)
            throws Exception;
    public reHumanos listaPaises() throws Exception;
    
    public String guardarUsuarios(String usuNombre, String usuPaterno,String usuMaterno, String codTDoc,String numDoc, String codPais,String codDpto, String codProv, String codDist, String usuCelular,String usuCorreo, String usuDirec,String usuSucursal, String codArea, String codPerfil, String usuFNac, String usuFIni, String usuario)
            throws Exception;
    public reHumanos validarNumDoc(String codTDoc, String numDoc) throws Exception;
    public reHumanos listaTipoDocumento(String codTipoDoc) throws Exception;
    public String bajaUsuarioSucursal(String codSucursal, String codUsuario) throws Exception;
    public reHumanos listaUsuariosSucursal(String codSucursal) throws Exception;
    public String desactivarAreaSucursal(String codSucursal, String codArea, String usuario) throws Exception;
    public String agregarAreasSucursal(String codSucursal, String codArea, String usuario) throws Exception;
    public reHumanos listaAreasSucursal(String codSucursal) throws Exception;
    public String actualizarSucursal(String codSede,String nomSede,String telefono,String email,String dpto,String prov,String dist,String direc,String usuario) throws Exception;
    public String deleteSucursal(String codSucursa, String usuario) throws Exception;
    public reHumanos listaDistritos(String codDpto, String codProv) throws Exception;
    public reHumanos listaProvincias(String codDpto) throws Exception;
    public reHumanos listaDepartamentos() throws Exception;
    public String guardarSucursal(String nombre, String telefono, String email, String dpto, String prov, String dist, String direccion, String usuario) throws Exception;
    public reHumanos listaSucursales()throws Exception;
    public String guardarRoles(String codPerfil, String codArea, String codModulos,String codSubModulos, String codPermisos, String usuario) 
            throws Exception;
    public mantenimiento ListaPermisos(String codPerfil, String codSubModulo) throws Exception;
    public reHumanos listarPerfiles(String codArea) throws Exception;
    public mantenimiento listarAllAreas() throws Exception;
    public ArrayList<mantenimiento> listarSubModulos(String codModulo, String codPerfil) throws Exception;
    public mantenimiento listarModulos(String codPerfil) throws Exception;
    public String actualizarPerfil(String codArea,String nomPerfil, String codPerfil, String usuario) throws Exception;
    public String confirBorrarPerfil(String codPerfil, String usuario) throws Exception;
    public String guardarCargo(String codArea, String nomPrefil, String usuario) throws Exception;
    public String returnNomArea(String codArea) throws Exception;
    public ArrayList<reHumanos> listarPerfilesArea(String codArea) throws Exception;
    public String borrarArea(String codArea, String usuario) throws Exception;
    public String actualizarArea(String codArea, String nomArea, String usuario) throws Exception;
    public String guardarArea(String nomArea, String usuario) throws Exception;
    public ArrayList<reHumanos> listarAreas() throws Exception;
    public reHumanos Login(String usuario,String contrasena) throws Exception;
    
     /* ENCUESTA PERSONAL CESADO*/ 
    public reHumanos listaMotivosSalida()throws Exception;
    public String guardarEncuesta(int codUsuario,String cod_respuesta,String observ,String usuario)throws Exception;
    public reHumanos listaEncuestas(int codUsuario)throws Exception;
    
    
}
