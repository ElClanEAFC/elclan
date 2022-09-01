/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.DAO;

import java.util.ArrayList;
import pe.sis.elclan.Clases.utilitarios;

/**
 *
 * @author bcondori
 */
public interface utilitariosDAO {
    public ArrayList<utilitarios> listarMoneda() throws Exception;
    public ArrayList<utilitarios> listarDist(String codDpto,String codProv) throws Exception;
    public ArrayList<utilitarios> listarProv(String codDpto) throws Exception;
    public ArrayList<utilitarios> listarDpto() throws Exception;
    public ArrayList<utilitarios> listarPais() throws Exception;
    public ArrayList<utilitarios> listaTipoDocumento() throws Exception;
    public ArrayList<utilitarios> listaAreas() throws Exception;

}
