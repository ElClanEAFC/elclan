/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.DAO;

import java.util.ArrayList;
import pe.sis.elclan.Clases.mantenimiento;

/**
 *
 * @author bcondori
 */
public interface mantenimientoDAO {
    
    public mantenimiento listarMenu(String codUser) throws Exception;
    public ArrayList<mantenimiento> listarSubMenu(String codUser, String codModulo) throws Exception;
    /*public mantenimiento confirGuardarGrupo(mantenimiento programa) throws Exception;
    public mantenimiento mostarCertiMax(String programa) throws Exception;
    public mantenimiento mostarCertiMin(String programa) throws Exception;
    public mantenimiento mostarNumGrupo(String programa) throws Exception;
    public mantenimiento verificarSubProgra(String programa) throws Exception;
    public mantenimiento confirBorrarSubPro(mantenimiento programa) throws Exception;
    public mantenimiento guardarModSubPrograma(mantenimiento programa) throws Exception;
    public ArrayList<mantenimiento> listaEditarSubPrograma(String codPrograma) throws Exception; 
    public mantenimiento guardarSubPrograma(mantenimiento programa) throws Exception;
    public mantenimiento deleteConfigPago(mantenimiento programa) throws Exception;
    public ArrayList<mantenimiento> listarConfigPago(String progra, String indica)throws Exception;
    public mantenimiento guardarConfigPago(mantenimiento configPago) throws Exception;
    public ArrayList<mantenimiento> listarAplica() throws Exception;
    public ArrayList<mantenimiento> listarParamCobro() throws Exception;
    public ArrayList<mantenimiento> listarIndicador() throws Exception;
    public ArrayList<mantenimiento> listarTipoRecaudo() throws Exception; 
    public mantenimiento actualizarPrograma(mantenimiento programa) throws Exception;
    public ArrayList<mantenimiento> listaEditarPrograma(String codPrograma) throws Exception; 
    public mantenimiento confirBorrarPro(mantenimiento programa) throws Exception;
    public mantenimiento guardarPrograma(mantenimiento programa) throws Exception;
    public ArrayList<mantenimiento> listarSubPrograma(String codPrgrama) throws Exception; 
    public ArrayList<mantenimiento> listarObjetoProg() throws Exception;  
    public ArrayList<mantenimiento> listarPrograma() throws Exception;   */
}
