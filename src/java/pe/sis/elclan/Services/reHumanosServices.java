
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.Services;

import java.util.ArrayList;
import pe.sis.elclan.Clases.reHumanos;
import pe.sis.elclan.DAO.DAOFactory;
import pe.sis.elclan.DAO.reHumanosDAO;
import pe.sis.elclan.Clases.mantenimiento;

/**
 *
 * @author Bentu condori
 */
public class reHumanosServices {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
    reHumanosDAO objReHumanosDAO;

    public reHumanosServices() {
        this.objReHumanosDAO = fabrica.getReHumanosDAO();
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 29-08-2022
    descripcion: service: listar justificaciones
     * @param codAsistDet
     * @return 
    ******************************************************************************/
    public reHumanos listaJustificacion(String codAsistDet){
        reHumanos lista = null;
        System.out.println("SERVICE reHumanosService(listaJustificacion)");
        try {  
           lista = objReHumanosDAO.listaJustificacion(codAsistDet);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaJustificacion) : " + e.getMessage());
         }
        return lista;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-08-2022
    descripcion: service: listar areas para sedes
     * @return 
    ******************************************************************************/
    public mantenimiento listarAreasSede(String codSede){
        mantenimiento mante = null;
        System.out.println("SERVICE reHumanosService(listarAreasSede)");
        try {  
           mante = objReHumanosDAO.listarAreasSede(codSede);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarAreasSede) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service:  REGISTRAR USUARIO A SEDE.
     * @param codUsuario
     * @param codSede
     * @param usuario
     * @return 
    ******************************************************************************/
    public String registroSedeUsuario(String codUsuario, String codSede, String usuario){
        String reSedeUser = null;
        System.out.println("SERVICE reHumanosService(registroSedeUsuario)");
        try {  
           reSedeUser = objReHumanosDAO.registroSedeUsuario(codUsuario, codSede, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(registroSedeUsuario) : " + e.getMessage());
         }
        return reSedeUser;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service: DAR BAJA EXPERIENCIA DE USUARIO.
     * @param codExperiencia
     * @return 
    ******************************************************************************/
    public String darBajaExperienciaLab(String codExperiencia){
        String regExperiencia = null;
        System.out.println("SERVICE reHumanosService(darBajaExperienciaLab)");
        try {  
           regExperiencia = objReHumanosDAO.darBajaExperienciaLab(codExperiencia);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(darBajaExperienciaLab) : " + e.getMessage());
         }
        return regExperiencia;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service: lISTA DE EXPERIENCIAS LABORADAS.
     * @param codUsuario
     * @return 
    ******************************************************************************/
    public reHumanos listaExperienciasLab(String codUsuario){
        reHumanos listaExperiencias = null;
        System.out.println("SERVICE reHumanosService(listaExperienciasLab)");
        try {  
           listaExperiencias = objReHumanosDAO.listaExperienciasLab(codUsuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaExperienciasLab) : " + e.getMessage());
        }
        return listaExperiencias;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service: REGISTRAR EXPERIENCIAS LABORADAS.
     * @param codUsuario
     * @param codPuesto
     * @param descripcion
     * @param fecIni
     * @param fecFin
     * @return 
    ******************************************************************************/
    public String registroExperienciaLab(String codUsuario, String codPuesto, String descripcion, String fecIni, String fecFin, String codPersona, String usuario ){
        String regExperiencia = null;
        System.out.println("SERVICE reHumanosService(registroExperienciaLab)");
        try {  
           regExperiencia = objReHumanosDAO.registroExperienciaLab(codUsuario,codPuesto,descripcion,fecIni,fecFin,codPersona,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(registroExperienciaLab) : " + e.getMessage());
         }
        return regExperiencia;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service: lISTA DE EMPRESAS LABORADAS.
     * @return 
    ******************************************************************************/
    public reHumanos listaEmpresaLab(){
        reHumanos listaEmpresa = null;
        System.out.println("SERVICE reHumanosService(listaEmpresaLab)");
        try {  
           listaEmpresa = objReHumanosDAO.listaEmpresaLab();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaEmpresaLab) : " + e.getMessage());
        }
        return listaEmpresa;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 25-07-2022
    descripcion: service: lISTA DE PUESTOS LABORADOS.
     * @return 
    ******************************************************************************/
    public reHumanos listaPuestoLab(){
        reHumanos listaPuesto = null;
        System.out.println("SERVICE reHumanosService(listaPuestoLab)");
        try {  
           listaPuesto = objReHumanosDAO.listaPuestoLab();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaPuestoLab) : " + e.getMessage());
        }
        return listaPuesto;
    }

    
//  ====================== REPORTES DE ASISTENCIAS ======================
    
        /****************************************************************************
    autor:  bentu condori m.fecha: 05-08-2022
    descripcion: service: Genera el reporte de asistencia en formato TXT.
     * @param codVende
     * @param codAsistDet
     * @param fecha
     * @param usuario
     * @param obs
     * @return 
    ******************************************************************************/   
    public reHumanos justificarAsistencia(String codVende, String codAsistDet, String fecha,  String usuario, String obs){
         reHumanos cargaAsist = null;
        System.out.println("SERVICE reHumanosService(justificarAsistencia)");
        try {  
           cargaAsist = objReHumanosDAO.justificarAsistencia(codVende, codAsistDet, fecha, usuario,obs);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(justificarAsistencia) : " + e.getMessage());
         }
        return cargaAsist;
    }
    
        /****************************************************************************
    autor:  bentu condori m.
    fecha: 01-08-2022
    descripcion: service: Genera el reporte de asistencia en formato TXT.

     * @return 
    ******************************************************************************/   
    public reHumanos generarReportAsistencia(String fecha,String codBanco,String modDeposito, String codTplanilla, String usuario){
         reHumanos cargaAsist = null;
        System.out.println("SERVICE reHumanosService(generarReportAsistencia)");
        try {  
           cargaAsist = objReHumanosDAO.generarReportAsistencia(fecha,codBanco,modDeposito,codTplanilla, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(generarReportAsistencia) : " + e.getMessage());
         }
        return cargaAsist;
    }
    
    /****************************************************************************
    autor:  benturino condori
    fecha: 26-07-2022
    descripcion: service: Lista de asistencias del dia.
     * @param Fecha
     * @param datos
     * @param estado
     * @return 
    ******************************************************************************/
    public reHumanos listarAsistenciaDiario(String Fecha, String datos, String estado){
        reHumanos usuarios = null;
        System.out.println("SERVICE reHumanosService(listarAsistenciaDiario)");
        try {  
           usuarios = objReHumanosDAO.listarAsistenciaDiario(Fecha, datos, estado);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarAsistenciaDiario) : " + e.getMessage());
        }
        return usuarios;
    }
    
    /****************************************************************************
    autor:  bentu condori m.
    fecha: 26-07-2022
    descripcion: service: confirma la carga de asistencia .
     * @param fecIni
     * @param fecFin
     * @return 
    ******************************************************************************/   
    public reHumanos confirmarCargaAsistencia(String fecha, String fecFin, String usuario){
         reHumanos cargaAsist = null;
        System.out.println("SERVICE reHumanosService(confirmarCargaAsistencia)");
        try {  
           cargaAsist = objReHumanosDAO.confirmarCargaAsistencia(fecha, fecFin, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(confirmarCargaAsistencia) : " + e.getMessage());
         }
        return cargaAsist;
    }
    
    /****************************************************************************
    autor:  bentu condori m.
    fecha: 21-07-2022
    descripcion: service: lista registro de asistencias del marcador bd access.
     * @param fecIni
     * @param fecFin
     * @return 
    ******************************************************************************/   
    public String guardarAsistenciaTmp(String dni, String fecha){
         String guardar = null;
        System.out.println("SERVICE reHumanosService(cargaAsistencia)");
        try {  
           guardar = objReHumanosDAO.guardarAsistenciaTmp(dni, fecha);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(guardarAsistencia) : " + e.getMessage());
         }
        return guardar;
    }
    
    /****************************************************************************
    autor:  bentu condori m.
    fecha: 21-07-2022
    descripcion: service: lista registro de asistencias del marcador bd access.
     * @param fecIni
     * @param fecFin
     * @return 
    ******************************************************************************/   
    public reHumanos cargaAsistencia(String fecIni, String fecFin){
         reHumanos cargaAsist = null;
        System.out.println("SERVICE reHumanosService(cargaAsistencia)");
        try {  
           cargaAsist = objReHumanosDAO.cargaAsistencia(fecIni, fecFin);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(cargaAsistencia) : " + e.getMessage());
         }
        return cargaAsist;
    }
//  ============================= FINAL DE REPORTES DE ASISTENCIAS ==============================
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 21-07-2022
    descripcion: service: Desactivar Usuario.
    * @param codUsuario
     * @param usuario
    * @return 
    ******************************************************************************/
    public String desactivarUsuario(String codUsuario, String usuario){
         String desactivarUsuario = null;
        System.out.println("SERVICE reHumanosService(desactivarUsuario)");
        try {  
           desactivarUsuario = objReHumanosDAO.desactivarUsuario(codUsuario, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(desactivarUsuario) : " + e.getMessage());
         }
        return desactivarUsuario;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 19-07-2022
    descripcion: service: Lista Motivos de Baja.
     * @return 
    ******************************************************************************/
    public reHumanos listaMotivoBaja(){
        reHumanos motivosBaja = null;
        System.out.println("SERVICE reHumanosService(listaMotivoBaja)");
        try {  
           motivosBaja = objReHumanosDAO.listaMotivoBaja();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaMotivoBaja) : " + e.getMessage());
        }
        return motivosBaja;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 18-07-2022
    descripcion: service: Dar Baja a Usuario.
    * @param codUsuario
    * @param codMotCese
    * @param fecCese
    * @return 
    ******************************************************************************/
    public String darBajaUsuario(String codUsuario,String codMotCese,String fecCese){
         String darBajaUsuario = null;
        System.out.println("SERVICE reHumanosService(darBajaUsuario)");
        try {  
           darBajaUsuario = objReHumanosDAO.darBajaUsuario(codUsuario,codMotCese,fecCese);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(darBajaUsuario) : " + e.getMessage());
         }
        return darBajaUsuario;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 18-07-2022
    descripcion: service: Listar Usuarios.
     * @return 
    ******************************************************************************/
    public reHumanos listaUsuarios(){
        reHumanos usuarios = null;
        System.out.println("SERVICE reHumanosService(listaUsuarios)");
        try {  
           usuarios = objReHumanosDAO.listaUsuarios();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaUsuarios) : " + e.getMessage());
        }
        return usuarios;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 18-07-2022
    descripcion: service: Dar Baja a Usuario.
    * @return 
    ******************************************************************************/
    public String desactivarCargoUsuario(String codUserPerfil, String codUser, String codPerfil, String observacion, String usuario){
         String darBajaUsuario = null;
        System.out.println("SERVICE reHumanosService(desactivarCargoUsuario)");
        try {  
           darBajaUsuario = objReHumanosDAO.desactivarCargoUsuario(codUserPerfil,codUser,codPerfil,observacion,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(desactivarCargoUsuario) : " + e.getMessage());
         }
        return darBajaUsuario;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 19-07-2022
    descripcion: service: Listar Cargos de Usuario.
     * @param codUser
     * @return 
    ******************************************************************************/
    public reHumanos listaCargosUsuario(String codUser){
        reHumanos motivosBaja = null;
        System.out.println("SERVICE reHumanosService(listaCargosUsuario)");
        try {  
           motivosBaja = objReHumanosDAO.listaCargosUsuario(codUser);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaCargosUsuario) : " + e.getMessage());
        }
        return motivosBaja;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 15-07-2022
    descripcion: service: Asignar Cargo a Usuario.
     * @param codUsuario
     * @param codPerfil
     * @param usuario
     * @return 
    ******************************************************************************/
    public String asignarCargoUsuario(String codUsuario, String codPerfil, String usuario){
         String actualizarUsuario = null;
        System.out.println("SERVICE reHumanosService(asignarCargoUsuario)");
        try {  
           actualizarUsuario = objReHumanosDAO.asignarCargoUsuario(codUsuario,codPerfil,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(asignarCargoUsuario) : " + e.getMessage());
         }
        return actualizarUsuario;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 15-07-2022
    descripcion: service: Actualizar Usuarios.
     * @param codUsuario
     * @param usuNombre
     * @param usuPaterno
     * @param usuMaterno
     * @param codTDoc
     * @param numDoc
     * @param codPais
     * @param codDpto
     * @param codProv
     * @param codDist
     * @param usuCelular
     * @param usuCorreo
     * @param usuDirec
     * @param usuSucursal
     * @param usuFNac
     * @param usuario
     * @return 
    ******************************************************************************/
    public String actualizarUsuarios(String codUsuario, String usuNombre, String usuPaterno,String usuMaterno, String codTDoc,String numDoc, String codPais,String codDpto, String codProv, String codDist, String usuCelular,String usuCorreo, String usuDirec,String usuSucursal, String usuFNac, String usuario){
        String actualizarUsuario = null;
        System.out.println("SERVICE reHumanosService(actualizarUsuarios)");
        try {  
           actualizarUsuario = objReHumanosDAO.actualizarUsuarios(codUsuario, usuNombre, usuPaterno, usuMaterno, codTDoc, numDoc, codPais, 
            codDpto, codProv, codDist, usuCelular, usuCorreo, usuDirec,
            usuSucursal,usuFNac,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(actualizarUsuarios) : " + e.getMessage());
         }
        return actualizarUsuario;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 15-07-2022
    descripcion: service: Listar Paises.
     * @return 
    ******************************************************************************/
    public reHumanos listaPaises(){
        reHumanos paises = null;
        System.out.println("SERVICE reHumanosService(listaPaises)");
        try {  
           paises = objReHumanosDAO.listaPaises();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaPaises) : " + e.getMessage());
        }
        return paises;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 13-07-2022
    descripcion: service: Guardar Usuarios.
     * @param usuNombre
     * @param usuPaterno
     * @param usuMaterno
     * @param codTDoc
     * @param numDoc
     * @param codPais
     * @param codDpto
     * @param codProv
     * @param codDist
     * @param usuCelular
     * @param usuCorreo
     * @param usuDirec
     * @param usuSucursal
     * @param codArea
     * @param codPerfil
     * @param usuFNac
     * @param usuFIni
     * @param usuario
     * @return 
    ******************************************************************************/
    public String guardarUsuarios(String usuNombre, String usuPaterno, String usuMaterno, String codTDoc, String numDoc, String codPais, 
            String codDpto, String codProv, String codDist, String usuCelular, String usuCorreo, String usuDirec,String usuSucursal, String codArea, String codPerfil, 
            String usuFNac, String usuFIni, String usuario){
        String resultado = null;
        System.out.println("SERVICE reHumanosService(guardarUsuarios)");
        try {  
           resultado = objReHumanosDAO.guardarUsuarios(usuNombre, usuPaterno, usuMaterno, codTDoc, numDoc, codPais, 
            codDpto, codProv, codDist, usuCelular, usuCorreo, usuDirec, usuSucursal, codArea, codPerfil, 
            usuFNac, usuFIni, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(guardarUsuarios) : " + e.getMessage());
         }
        return resultado;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 12-07-2022
    descripcion: service: Validar Numero de Documento.
     * @param codTDoc
     * @param numDoc
     * @return 
    ******************************************************************************/
    public reHumanos validarNumDoc(String codTDoc, String numDoc){
        reHumanos datosUsuario = null;
        System.out.println("SERVICE reHumanosService(validarNumDoc)");
        try {  
           datosUsuario = objReHumanosDAO.validarNumDoc(codTDoc, numDoc );
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(validarNumDoc) : " + e.getMessage());
        }
        return datosUsuario;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 11-07-2022
    descripcion: service: Listar Tipos de documentos.
     * @param codTipoDoc
     * @return 
    ******************************************************************************/
    public reHumanos listaTipoDocumento(String codTipoDoc){
        reHumanos tDoc = null;
        System.out.println("SERVICE reHumanosService(listaTipoDocumento)");
        try {  
           tDoc = objReHumanosDAO.listaTipoDocumento(codTipoDoc);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaTipoDocumento) : " + e.getMessage());
        }
        return tDoc;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 09-08-2022
    descripcion: service: DAR BAJA USUARIO DE Sucursal.
     * @param codSucursal
     * @param codUsuario
     * @return 
    ******************************************************************************/
    public String bajaUsuarioSucursal(String codSucursal, String codUsuario){
        String bajaUser = null;
        System.out.println("SERVICE reHumanosService(bajaUsuarioSucursal)");
        try {  
           bajaUser = objReHumanosDAO.bajaUsuarioSucursal(codSucursal, codUsuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(bajaUsuarioSucursal) : " + e.getMessage());
         }
        return bajaUser;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 09-08-2022
    descripcion: service: Listar Usuarios de Sucursal.
     * @param codSucursal
     * @return 
    ******************************************************************************/
    public reHumanos listaUsuariosSucursal(String codSucursal){
        reHumanos listUserSucu = null;
        System.out.println("SERVICE reHumanosService(listaUsuariosSucursal)");
        try {  
           listUserSucu = objReHumanosDAO.listaUsuariosSucursal(codSucursal);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaUsuariosSucursal) : " + e.getMessage());
        }
        return listUserSucu;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 07-07-2022
    descripcion: service: Desactivar Area en Sucursal.
     * @param codSucursal
     * @param codArea
     * @param usuario
     * @return 
    ******************************************************************************/
    public String desactivarAreaSucursal(String codSucursal, String codArea, String usuario){
        String mante = null;
        System.out.println("SERVICE reHumanosService(desactivarAreaSucursal)");
        try {  
           mante = objReHumanosDAO.desactivarAreaSucursal(codSucursal, codArea, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(desactivarAreaSucursal) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 08-07-2022
    descripcion: service: Agregar Area a Sucursal.
     * @param codSucursal
     * @param codArea
     * @param usuario
     * @return 
    ******************************************************************************/
    public String agregarAreasSucursal(String codSucursal, String codArea, String usuario){
        String respuesta = null;
        System.out.println("SERVICE reHumanosService(agregarAreasSucursal)");
        try {  
           respuesta = objReHumanosDAO.agregarAreasSucursal( codSucursal,  codArea,  usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(agregarAreasSucursal) : " + e.getMessage());
         }
        return respuesta;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 08-07-2022
    descripcion: service: Listar Areas Sucursal.
     * @param codSucursal
     * @return 
     * 
    ******************************************************************************/
    public reHumanos listaAreasSucursal(String codSucursal){
        reHumanos areas = null;
        System.out.println("SERVICE reHumanosService(listaAreasSucursal)");
        try {  
           areas = objReHumanosDAO.listaAreasSucursal(codSucursal);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaAreasSucursal) : " + e.getMessage());
        }
        return areas;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 07-07-2022
    descripcion: service: Actulizar Sucursal.
     * @param codSede
     * @param nomSede
     * @param telefono
     * @param email
     * @param dpto
     * @param prov
     * @param dist
     * @param direc
     * @param usuario
     * @return 
    ******************************************************************************/
    public String actualizarSucursal(String codSede, String nomSede, String telefono, String email, String dpto, String prov, String dist, String direc, String usuario){
        String mante = null;
        System.out.println("SERVICE reHumanosService(actualizarSucursal)");
        try {  
           mante = objReHumanosDAO.actualizarSucursal( codSede,  nomSede,  telefono,  email,  dpto,  prov,  dist,  direc,  usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(actualizarSucursal) : " + e.getMessage());
         }
        return mante;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 07-07-2022
    descripcion: service: Eliminar Sucursal.
     * @param codSucursal
     * @param usuario
     * @return 
    ******************************************************************************/
    public String deleteSucursal(String codSucursal, String usuario){
        String mante = null;
        System.out.println("SERVICE reHumanosService(deleteSucursal)");
        try {  
           mante = objReHumanosDAO.deleteSucursal(codSucursal, codSucursal);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(deleteSucursal) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 05-07-2022
    descripcion: service: Traer lista de provincias
     * @param codDpto
     * @param codProv
     * @return 
    ******************************************************************************/
    public reHumanos listaDistritos(String codDpto, String codProv){
        reHumanos mante = null;
        System.out.println("SERVICE reHumanosService(listaDistritos)");
        try {  
           mante = objReHumanosDAO.listaDistritos(codDpto, codProv);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaDistritos) : " + e.getMessage());
         }
        return mante;
    
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 05-07-2022
    descripcion: service: Traer lista de provincias
     * @param codDpto
     * @return 
    ******************************************************************************/
    public reHumanos listaProvincias(String codDpto){
        reHumanos mante = null;
        System.out.println("SERVICE reHumanosService(listaProvincias)");
        try {  
           mante = objReHumanosDAO.listaProvincias(codDpto);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaProvincias) : " + e.getMessage());
         }
        return mante;
    
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 05-07-2022
    descripcion: service: Traer lista de departamentos
     * @return 
    ******************************************************************************/
    public reHumanos listaDepartamentos(){
        reHumanos mante = null;
        System.out.println("SERVICE reHumanosService(listaDepartamentos)");
        try {  
           mante = objReHumanosDAO.listaDepartamentos();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaDepartamentos) : " + e.getMessage());
         }
        return mante;
    
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 05-07-2022
    descripcion: service: Guardar nueva sucursal
     * @param nombre
     * @param telefono
     * @param email
     * @param dpto
     * @return 
    ******************************************************************************/
    public String guardarSucursal(String nombre, String telefono, String email, String dpto, String prov, String dist, String direccion, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(guardarSucursal)");
        try {  
           seguridad = objReHumanosDAO.guardarSucursal(nombre, telefono, email, dpto, prov, dist, direccion, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(guardarSucursal) : " + e.getMessage());
        }
        return seguridad;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 05-07-2022
    descripcion: service: Traer lista de sucursales
     * @return 
    ******************************************************************************/
    public reHumanos listaSucursales(){
        reHumanos mante = null;
        System.out.println("SERVICE reHumanosService(listaSucursales)");
        try {  
           mante = objReHumanosDAO.listaSucursales();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listaSucursales) : " + e.getMessage());
         }
        return mante;
    }
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 01-07-2022
    descripcion: service: crear nuevos perfiles o cargos segun el area
     * @param codPerfil
     * @param codArea
     * @param codModulos
     * @param codSubModulos
     * @param codPermisos
     * @param usuario
     * @return 
    ******************************************************************************/
    public String guardarRoles(String codPerfil, String codArea, String codModulos,String codSubModulos, String codPermisos, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(guardarRoles)");
        try {  
           seguridad = objReHumanosDAO.guardarRoles(codPerfil, codArea, codModulos, codSubModulos, codPermisos,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(guardarRoles) : " + e.getMessage());
        }
        return seguridad;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 27-06-2022
    descripcion: service: obtener lista de submodulos
     * @param codPerfil
     * @param codSubModulo
     * @return 
    ******************************************************************************/
    public mantenimiento ListarPermisos(String codPerfil, String codSubModulo){
        mantenimiento mante = null;
        System.out.println("SERVICE reHumanosService(ListaPermisos)");
        try {  
           mante = objReHumanosDAO.ListaPermisos(codPerfil, codSubModulo);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(ListaPermisos) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 27-06-2022
    descripcion: service: obtener lista de submodulos
     * @param codArea
     * @return 
    ******************************************************************************/
    public reHumanos listarPerfiles(String codArea){
        reHumanos mante = null;
        System.out.println("SERVICE reHumanosService(listarPerfiles)");
        try {  
           mante = objReHumanosDAO.listarPerfiles(codArea);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarPerfiles) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 27-06-2022
    descripcion: service: obtener lista de submodulos
     * @return 
    ******************************************************************************/
    public mantenimiento listarAllAreas(){
        mantenimiento mante = null;
        System.out.println("SERVICE reHumanosService(listarAllAreas)");
        try {  
           mante = objReHumanosDAO.listarAllAreas();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarAllAreas) : " + e.getMessage());
         }
        return mante;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 23-06-2022
    descripcion: service: obtener lista de submodulos
     * @param codModulo
     * @param codPerfil
     * @return 
    ******************************************************************************/
    public ArrayList<mantenimiento> listarSubModulos(String codModulo, String codPerfil) {
        ArrayList<mantenimiento> lista = null;
        System.out.println("SERVICE reHumanosService(listarSubModulos)");
        try {  
           lista = objReHumanosDAO.listarSubModulos(codModulo,codPerfil);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarSubModulos) : " + e.getMessage());
            }
        return lista;
    }
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 23-06-2022
    descripcion: service: obtener lista de modulos
     * @param codPerfil
     * @return 
    ******************************************************************************/
    public mantenimiento listarModulos(String codPerfil) {
        mantenimiento seguridad = null;
        System.out.println("SERVICE reHumanosService(listarModulos)");
        try {  
           seguridad = objReHumanosDAO.listarModulos(codPerfil);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarModulos) : " + e.getMessage());
         }
        return seguridad;
    }
    
    
    /****************************************************************************
    autor:  yasub huaman ramos
    fecha: 23-06-2022
    descripcion: service: crear nuevos perfiles o cargos segun el area
     * @param codArea
     * @param nomPerfil
     * @param codPerf
     * @param usuario
     * @return 
    ******************************************************************************/
    public String actualizarPerfil(String codArea,String nomPerfil, String codPerf, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(actualizarPerfil)");
        try {  
           seguridad = objReHumanosDAO.actualizarPerfil( codArea, nomPerfil, codPerf, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(actualizarPerfil) : " + e.getMessage());
        }
        return seguridad;
    }
    
    /****************************************************************************
    autor:  bentu condori
    fecha: 22-06-2022
    descripcion: service: crear nuevos perfiles o cargos segun el area
     * @param codPerfil
     * @param usuario
     * @return 
    ******************************************************************************/
    public String confirBorrarPerfil(String codPerfil, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(confirBorrarPerfil)");
        try {  
           seguridad = objReHumanosDAO.confirBorrarPerfil(codPerfil, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(confirBorrarPerfil) : " + e.getMessage());
        }
        return seguridad;
    }
    
    public String guardarCargo(String codArea, String nomPerfil, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(guardarCargo)");
        try {  
           seguridad = objReHumanosDAO.guardarCargo(codArea,nomPerfil,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(guardarCargo) : " + e.getMessage());
        }
        return seguridad;
    }
    
    /****************************************************************************
    autor:  bentu condori
    fecha: 16-06-2022
    descripcion: service: Retorna el nombre del area segun el codigo
     * @param codArea
     * @return 
    ******************************************************************************/
    public String returnNomArea(String codArea) {
        String lista = null;
        System.out.println("SERVICE reHumanosService(listarPerfiles)");
        try {  
           lista = objReHumanosDAO.returnNomArea(codArea);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(returnNomArea) : " + e.getMessage());
        }
        return lista;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 16-06-2022
    descripcion: service: lista los perfiles segun el area 
    ******************************************************************************/
    public ArrayList<reHumanos> listarPerfilesArea(String codArea) {
        ArrayList<reHumanos> lista = null;
        System.out.println("SERVICE reHumanosService(listarPerfiles)");
        try {  
           lista = objReHumanosDAO.listarPerfilesArea(codArea);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarPerfiles) : " + e.getMessage());
        }
        return lista;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 13-06-2022
    descripcion: service: desactiva el area
    ******************************************************************************/
    public String borrarArea(String codArea, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(borrarArea)");
        try {  
           seguridad = objReHumanosDAO.borrarArea(codArea,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(borrarArea) : " + e.getMessage());
        }
        return seguridad;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 13-06-2022
    descripcion: service: actualiza datos del area
    ******************************************************************************/
    public String actualizarArea(String codArea, String nomArea, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(actualizarArea)");
        try {  
           seguridad = objReHumanosDAO.actualizarArea(codArea, nomArea, usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(actualizarArea) : " + e.getMessage());
        }
        return seguridad;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 08-06-2022
    descripcion: service: guarda los datos del area
    ******************************************************************************/
    public String guardarArea(String nomArea, String usuario) {
        String seguridad = null;
        System.out.println("SERVICE reHumanosService(crearUsuario)");
        try {  
           seguridad = objReHumanosDAO.guardarArea(nomArea,usuario);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(crearUsuario) : " + e.getMessage());
        }
        return seguridad;
    }
    /****************************************************************************
    autor:  bentu condori
    fecha: 08-06-2022
    descripcion: service: guarda los datos del area
    ******************************************************************************/
    public ArrayList<reHumanos> listarAreas() {
        ArrayList<reHumanos> lista = null;
        System.out.println("SERVICE reHumanosService(listarMenu)");
        try {  
           lista = objReHumanosDAO.listarAreas();
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(listarPerfil) : " + e.getMessage());
        }
        return lista;
    }
    
    /****************************************************************************
    autor:  bentu condori
    fecha: 04-06-2022
    descripcion: service: Validacon de usuarios(Login)
    ******************************************************************************/
    public reHumanos Login(String usuario, String pass) {
        reHumanos seguridad = null;
        System.out.println("SERVICE reHumanosService(Login)");
        try {  
           seguridad = objReHumanosDAO.Login(usuario, pass);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(validarUsuario) : " + e.getMessage());
        }
        return seguridad;
    }
       
    

}
