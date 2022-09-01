/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.DAO;

import pe.sis.elclan.Clases.asociados;

/**
 *
 * @author bcondori
 */
public interface asociadosDAO {
    public asociados buscarDOI(String usuTDoc, String usuNumDoc) throws Exception;
}
