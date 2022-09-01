package pe.sis.elclan.Clases;

import java.util.ArrayList;

/**
 * @descripcion: clase para la administracion del modulo de mantenimiento
 * @fecha: 25-01-2022
 * @author: bcondori
 */
public class mantenimiento {
    private String mProCod;
    private String mProdes;
    private String mProObjeto;
    private String mProCodMoneda;
    private String mProMoneda;
    private String mProNomComer;
    private String mProNumResol;
    private String mProNumPlaza;
    private String mProNumDuracion;
    private String mProFeIni;
    private String mProFeFin;
    private String mProEstado;
    private String mSpCodigo;
    private String mSpDescrip;
    private String mSpNomComer;
    private String mUsuario;
    private String mCodOtros;
    private String mDesOtros;
    private String mCodigoArea;
    private String mDescArea;
    private String mProInSub;
    private String mNumGrupo;
    private String mCertimin;
    private String mCertimax;
    private String mCertiDif;
    
    private String CodMensaje;
    private String Mensaje;
    private String mIgv;
    
    private String mConceptoPa;
    private String mValor;
    private String mAplIndicador;
    private String mParamCobro;
    private String mMetodApli;
    private String mEstado;
    private String mUCreacion;
    private String mFCreacion;

    private String codModulo;
    private String codSubModulo;
    private String codSubModuloOpc;
    private String desModulo;
    private String modNemo;
    private String desSubModulo;
    private String desSubModuloOpc;
    private String linkModulo;
    private String linkSubModulo;
    private String canSubModulo;
    private String icoModulo;
    private String icoSubModulo;
    private String icoSubMenuPag;
    private String situCheck;
    private ArrayList<mantenimiento> listaModulos;
    private ArrayList<mantenimiento> listaSubModulos;
    private ArrayList<mantenimiento> listaSubModulosOpc;
    private ArrayList<mantenimiento> listaMenu;
    private ArrayList<mantenimiento> listaAreas;

    public ArrayList<mantenimiento> getListaSubModulosOpc() {
        return listaSubModulosOpc;
    }

    public void setListaSubModulosOpc(ArrayList<mantenimiento> listaSubModulosOpc) {
        this.listaSubModulosOpc = listaSubModulosOpc;
    }

    public String getCodSubModuloOpc() {
        return codSubModuloOpc;
    }

    public void setCodSubModuloOpc(String codSubModuloOpc) {
        this.codSubModuloOpc = codSubModuloOpc;
    }

    public String getDesSubModuloOpc() {
        return desSubModuloOpc;
    }

    public void setDesSubModuloOpc(String desSubModuloOpc) {
        this.desSubModuloOpc = desSubModuloOpc;
    }

    public String getSituCheck() {
        return situCheck;
    }

    public void setSituCheck(String situCheck) {
        this.situCheck = situCheck;
    }

    public ArrayList<mantenimiento> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(ArrayList<mantenimiento> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public String getmCodigoArea() {
        return mCodigoArea;
    }

    public void setmCodigoArea(String mCodigoArea) {
        this.mCodigoArea = mCodigoArea;
    }

    public String getmDescArea() {
        return mDescArea;
    }

    public void setmDescArea(String mDescArea) {
        this.mDescArea = mDescArea;
    }

    public String getmCertiDif() {
        return mCertiDif;
    }

    public void setmCertiDif(String mCertiDif) {
        this.mCertiDif = mCertiDif;
    }
    
    public String getmCertimin() {
        return mCertimin;
    }

    public void setmCertimin(String mCertimin) {
        this.mCertimin = mCertimin;
    }

    public String getmCertimax() {
        return mCertimax;
    }

    public void setmCertimax(String mCertimax) {
        this.mCertimax = mCertimax;
    }
    
    public String getmNumGrupo() {
        return mNumGrupo;
    }

    public void setmNumGrupo(String mNumGrupo) {
        this.mNumGrupo = mNumGrupo;
    }
    
    public String getmUCreacion() {
        return mUCreacion;
    }

    public void setmUCreacion(String mUCreacion) {
        this.mUCreacion = mUCreacion;
    }

    public String getmFCreacion() {
        return mFCreacion;
    }

    public void setmFCreacion(String mFCreacion) {
        this.mFCreacion = mFCreacion;
    }
    
    public String getmEstado() {
        return mEstado;
    }

    public void setmEstado(String mEstado) {
        this.mEstado = mEstado;
    }
    
    public String getmConceptoPa() {
        return mConceptoPa;
    }

    public void setmConceptoPa(String mConceptoPa) {
        this.mConceptoPa = mConceptoPa;
    }

    public String getmValor() {
        return mValor;
    }

    public void setmValor(String mValor) {
        this.mValor = mValor;
    }

    public String getmAplIndicador() {
        return mAplIndicador;
    }

    public void setmAplIndicador(String mAplIndicador) {
        this.mAplIndicador = mAplIndicador;
    }

    public String getmParamCobro() {
        return mParamCobro;
    }

    public void setmParamCobro(String mParamCobro) {
        this.mParamCobro = mParamCobro;
    }

    public String getmMetodApli() {
        return mMetodApli;
    }

    public void setmMetodApli(String mMetodApli) {
        this.mMetodApli = mMetodApli;
    }
    
    
    public String getmIgv() {
        return mIgv;
    }

    public void setmIgv(String mIgv) {
        this.mIgv = mIgv;
    }

    public String getCodMensaje() {
        return CodMensaje;
    }

    public void setCodMensaje(String CodMensaje) {
        this.CodMensaje = CodMensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getmProInSub() {
        return mProInSub;
    }

    public void setmProInSub(String mProInSub) {
        this.mProInSub = mProInSub;
    }

    public String getmSpNomComer() {
        return mSpNomComer;
    }

    public void setmSpNomComer(String mSpNomComer) {
        this.mSpNomComer = mSpNomComer;
    }
    
    public String getmSpCodigo() {
        return mSpCodigo;
    }

    public void setmSpCodigo(String mSpCodigo) {
        this.mSpCodigo = mSpCodigo;
    }

    public String getmSpDescrip() {
        return mSpDescrip;
    }

    public void setmSpDescrip(String mSpDescrip) {
        this.mSpDescrip = mSpDescrip;
    }

    public String getmProCod() {
        return mProCod;
    }

    public void setmProCod(String mProCod) {
        this.mProCod = mProCod;
    }

    public String getmProdes() {
        return mProdes;
    }

    public void setmProdes(String mProdes) {
        this.mProdes = mProdes;
    }

    public String getmProObjeto() {
        return mProObjeto;
    }

    public void setmProObjeto(String mProObjeto) {
        this.mProObjeto = mProObjeto;
    }

    public String getmProCodMoneda() {
        return mProCodMoneda;
    }

    public void setmProCodMoneda(String mProCodMoneda) {
        this.mProCodMoneda = mProCodMoneda;
    }

    public String getmProMoneda() {
        return mProMoneda;
    }

    public void setmProMoneda(String mProMoneda) {
        this.mProMoneda = mProMoneda;
    }

    public String getmProNomComer() {
        return mProNomComer;
    }

    public void setmProNomComer(String mProNomComer) {
        this.mProNomComer = mProNomComer;
    }

    public String getmProNumResol() {
        return mProNumResol;
    }

    public void setmProNumResol(String mProNumResol) {
        this.mProNumResol = mProNumResol;
    }

    public String getmProNumPlaza() {
        return mProNumPlaza;
    }

    public void setmProNumPlaza(String mProNumPlaza) {
        this.mProNumPlaza = mProNumPlaza;
    }

    public String getmProNumDuracion() {
        return mProNumDuracion;
    }

    public void setmProNumDuracion(String mProNumDuracion) {
        this.mProNumDuracion = mProNumDuracion;
    }

    public String getmProFeIni() {
        return mProFeIni;
    }

    public void setmProFeIni(String mProFeIni) {
        this.mProFeIni = mProFeIni;
    }

    public String getmProFeFin() {
        return mProFeFin;
    }

    public void setmProFeFin(String mProFeFin) {
        this.mProFeFin = mProFeFin;
    }

    public String getmProEstado() {
        return mProEstado;
    }

    public void setmProEstado(String mProEstado) {
        this.mProEstado = mProEstado;
    }

    public String getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(String mUsuario) {
        this.mUsuario = mUsuario;
    }

    public String getmCodOtros() {
        return mCodOtros;
    }

    public void setmCodOtros(String mCodOtros) {
        this.mCodOtros = mCodOtros;
    }

    public String getmDesOtros() {
        return mDesOtros;
    }

    public void setmDesOtros(String mDesOtros) {
        this.mDesOtros = mDesOtros;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getCodSubModulo() {
        return codSubModulo;
    }

    public void setCodSubModulo(String codSubModulo) {
        this.codSubModulo = codSubModulo;
    }

    public String getDesModulo() {
        return desModulo;
    }

    public void setDesModulo(String desModulo) {
        this.desModulo = desModulo;
    }

    public String getModNemo() {
        return modNemo;
    }

    public void setModNemo(String modNemo) {
        this.modNemo = modNemo;
    }
    
    public String getDesSubModulo() {
        return desSubModulo;
    }

    public void setDesSubModulo(String desSubModulo) {
        this.desSubModulo = desSubModulo;
    }

    public String getLinkModulo() {
        return linkModulo;
    }

    public void setLinkModulo(String linkModulo) {
        this.linkModulo = linkModulo;
    }

    public String getLinkSubModulo() {
        return linkSubModulo;
    }

    public void setLinkSubModulo(String linkSubModulo) {
        this.linkSubModulo = linkSubModulo;
    }

    public String getCanSubModulo() {
        return canSubModulo;
    }

    public void setCanSubModulo(String canSubModulo) {
        this.canSubModulo = canSubModulo;
    }

    public ArrayList<mantenimiento> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(ArrayList<mantenimiento> listaModulos) {
        this.listaModulos = listaModulos;
    }

    public ArrayList<mantenimiento> getListaSubModulos() {
        return listaSubModulos;
    }

    public void setListaSubModulos(ArrayList<mantenimiento> listaSubModulos) {
        this.listaSubModulos = listaSubModulos;
    }

    public ArrayList<mantenimiento> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(ArrayList<mantenimiento> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public String getIcoModulo() {
        return icoModulo;
    }

    public void setIcoModulo(String icoModulo) {
        this.icoModulo = icoModulo;
    }

    public String getIcoSubModulo() {
        return icoSubModulo;
    }

    public void setIcoSubModulo(String icoSubModulo) {
        this.icoSubModulo = icoSubModulo;
    }

    public String getIcoSubMenuPag() {
        return icoSubMenuPag;
    }

    public void setIcoSubMenuPag(String icoSubMenuPag) {
        this.icoSubMenuPag = icoSubMenuPag;
    }
    
}
