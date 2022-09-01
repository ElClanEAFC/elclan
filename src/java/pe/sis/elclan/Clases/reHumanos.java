/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sis.elclan.Clases;

import java.util.ArrayList; 

/**
 *
 * @author Bentu Condori
 * @ 20/08/2021
 */
public class reHumanos {
    private String codigoUsuario;
    private String Usuario;
    private String nombreUsuario;
    private String apePaternoUsuario;
    private String apeMaternoUsuario;
    private String correo;
    private String celular;
    private String codigoPais;
    private String descPais;
    private String codigoDepartamento;
    private String descDepartamento;
    private String codigoProvincia;
    private String descProvincia;
    private String codigoDistrito;
    private String descDistrito;
    private String codigoPerfil;
    private String descPerfil;
    private String codigoModulo;
    private String tipoUsuario;
    private String codigoArea;
    private String descArea;
    private String codigoTipoDOI;
    private String descTipoDOI;
    private String numeroDOI;
    private String finicio;
    private String fcese;
    private String motivoCese;
    
    private String contador;
    private String contadorUsuario;
    private String icono;
    private String codMensaje;
    private String mensaje;
    

    private int cantUsu;
    private String usuDireccion;
    private String fechaNacimiento;
    private String desEstado;
    
    private String codMotCese;
    private String desMotCese;
    private String feCreacion;
    private String codUsuPerfil;
    private String codProfesion;
    private String desProfesion;
    
    private String codExperiencia;
    private String codPuesto;
    private String desPuesto;
    private String codEmpresa;
    private String desEmpresa;
    private String tiempoLab;
    
    private String codSucursal;
    private String desSucursal;
    private String telefono;
    private String email;
    private String direccion;
    private String ciudad;
    private String estado;
    private String tipoSucursal;
    private String opciones;
    
    private String fecHoraMarcacion;
    private String fechaMarcacion;
    private String horaMarcacion;
    private String sitAsistencia;
    private String campReporte;
    private String codigoAsisDet;
    private String observacion;
    private String codJustificacion;
    
    private ArrayList<reHumanos> listaUsuarios;
    private ArrayList<reHumanos> listaModulos;
    private ArrayList<reHumanos> listaPerfiles;
    private ArrayList<reHumanos> listaSucursales;
    private ArrayList<reHumanos> listaDepartamentos;
    private ArrayList<reHumanos> listaProvincias;
    private ArrayList<reHumanos> listaDistritos;
    private ArrayList<reHumanos> listaAreasSucursal;
    private ArrayList<reHumanos> listaUsuariosSucursal;
    private ArrayList<reHumanos> listaTipoDocumento;
    private ArrayList<reHumanos> listaPaises;
    
    private ArrayList<reHumanos> listaAsistencia;
    private ArrayList<reHumanos> listReporte;
    
    private ArrayList<reHumanos> listaMotivosBaja;
    private ArrayList<reHumanos> listaCargosUsuario;
    private ArrayList<reHumanos> listaPuestoLab;
    private ArrayList<reHumanos> listaEmpresaLab;
    private ArrayList<reHumanos> listaExperienciaLab;
    private ArrayList<reHumanos> listaJustificacion;

    public String getCodJustificacion() {
        return codJustificacion;
    }

    public void setCodJustificacion(String codJustificacion) {
        this.codJustificacion = codJustificacion;
    }
        
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }   
    
    public ArrayList<reHumanos> getListaJustificacion() {
        return listaJustificacion;
    }

    // REPORTES
    public void setListaJustificacion(ArrayList<reHumanos> listaJustificacion) {
        this.listaJustificacion = listaJustificacion;
    }

    public String getCodigoAsisDet() {
        return codigoAsisDet;
    }

    public void setCodigoAsisDet(String codigoAsisDet) {
        this.codigoAsisDet = codigoAsisDet;
    }    
        
    public String getCampReporte() {
        return campReporte;
    }

    public void setCampReporte(String campReporte) {
        this.campReporte = campReporte;
    }

    public ArrayList<reHumanos> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(ArrayList<reHumanos> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }    
   
    public ArrayList<reHumanos> getListReporte() {
        return listReporte;
    }

    public void setListReporte(ArrayList<reHumanos> listReporte) {
        this.listReporte = listReporte;
    }

    public ArrayList<reHumanos> getListaUsuariosSucursal() {
        return listaUsuariosSucursal;
    }

    public void setListaUsuariosSucursal(ArrayList<reHumanos> listaUsuariosSucursal) {
        this.listaUsuariosSucursal = listaUsuariosSucursal;
    }
    
    public ArrayList<reHumanos> getListaPuestoLab() {
        return listaPuestoLab;
    }

    public String getFecHoraMarcacion() {
        return fecHoraMarcacion;
    }

    public void setFecHoraMarcacion(String fecHoraMarcacion) {
        this.fecHoraMarcacion = fecHoraMarcacion;
    }

    public String getFechaMarcacion() {
        return fechaMarcacion;
    }

    public void setFechaMarcacion(String fechaMarcacion) {
        this.fechaMarcacion = fechaMarcacion;
    }

    public String getHoraMarcacion() {
        return horaMarcacion;
    }

    public void setHoraMarcacion(String horaMarcacion) {
        this.horaMarcacion = horaMarcacion;
    }

    public String getSitAsistencia() {
        return sitAsistencia;
    }

    public void setSitAsistencia(String sitAsistencia) {
        this.sitAsistencia = sitAsistencia;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }
        
    public void setListaPuestoLab(ArrayList<reHumanos> listaPuestoLab) {
        this.listaPuestoLab = listaPuestoLab;
    }
    
    public ArrayList<reHumanos> getListaEmpresaLab() {
        return listaEmpresaLab;
    }

    public void setListaEmpresaLab(ArrayList<reHumanos> listaEmpresaLab) {
        this.listaEmpresaLab = listaEmpresaLab;
    }

    public ArrayList<reHumanos> getListaExperienciaLab() {
        return listaExperienciaLab;
    }

    public void setListaExperienciaLab(ArrayList<reHumanos> listaExperienciaLab) {
        this.listaExperienciaLab = listaExperienciaLab;
    }

    public ArrayList<reHumanos> getListaCargosUsuario() {
        return listaCargosUsuario;
    }

    public void setListaCargosUsuario(ArrayList<reHumanos> listaCargosUsuario) {
        this.listaCargosUsuario = listaCargosUsuario;
    }
    
    
    public ArrayList<reHumanos> getListaMotivosBaja() {
        return listaMotivosBaja;
    }

    public void setListaMotivosBaja(ArrayList<reHumanos> listaMotivosBaja) {
        this.listaMotivosBaja = listaMotivosBaja;
    }
    
    
    public ArrayList<reHumanos> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<reHumanos> listaPaises) {
        this.listaPaises = listaPaises;
    }
    
    
    public ArrayList<reHumanos> getListaTipoDocumento() {
        return listaTipoDocumento;
    }

    public void setListaTipoDocumento(ArrayList<reHumanos> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    public ArrayList<reHumanos> getListaAreasSucursal() {
        return listaAreasSucursal;
    }

    public void setListaAreasSucursal(ArrayList<reHumanos> listaAreasSucursal) {
        this.listaAreasSucursal = listaAreasSucursal;
    }

    public ArrayList<reHumanos> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(ArrayList<reHumanos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public ArrayList<reHumanos> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(ArrayList<reHumanos> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    public ArrayList<reHumanos> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(ArrayList<reHumanos> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    
    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getDesSucursal() {
        return desSucursal;
    }

    public void setDesSucursal(String desSucursal) {
        this.desSucursal = desSucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public ArrayList<reHumanos> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ArrayList<reHumanos> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }
    
    public ArrayList<reHumanos> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(ArrayList<reHumanos> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public ArrayList<reHumanos> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(ArrayList<reHumanos> listaModulos) {
        this.listaModulos = listaModulos;
    }

    public ArrayList<reHumanos> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<reHumanos> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
      
    public String getTiempoLab() {
        return tiempoLab;
    }

    public void setTiempoLab(String tiempoLab) {
        this.tiempoLab = tiempoLab;
    }

    public String getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(String codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getDesEmpresa() {
        return desEmpresa;
    }

    public void setDesEmpresa(String desEmpresa) {
        this.desEmpresa = desEmpresa;
    }
    
    public String getCodExperiencia() {
        return codExperiencia;
    }

    public void setCodExperiencia(String codExperiencia) {
        this.codExperiencia = codExperiencia;
    }

    public String getDesPuesto() {
        return desPuesto;
    }

    public void setDesPuesto(String desPuesto) {
        this.desPuesto = desPuesto;
    }

    public String getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(String codProfesion) {
        this.codProfesion = codProfesion;
    }

    public String getDesProfesion() {
        return desProfesion;
    }

    public void setDesProfesion(String desProfesion) {
        this.desProfesion = desProfesion;
    }
    

    public String getCodUsuPerfil() {
        return codUsuPerfil;
    }

    public void setCodUsuPerfil(String codUsuPerfil) {
        this.codUsuPerfil = codUsuPerfil;
    }

    public String getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(String feCreacion) {
        this.feCreacion = feCreacion;
    }

    public String getCodMotCese() {
        return codMotCese;
    }

    public void setCodMotCese(String codMotCese) {
        this.codMotCese = codMotCese;
    }

    public String getDesMotCese() {
        return desMotCese;
    }

    public void setDesMotCese(String desMotCese) {
        this.desMotCese = desMotCese;
    }
    
    
    
    public String getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(String desEstado) {
        this.desEstado = desEstado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }
    
    public int getCantUsu() {
        return cantUsu;
    }

    public void setCantUsu(int cantUsu) {
        this.cantUsu = cantUsu;
    }

    public String getIcoModulo() {
        return icoModulo;
    }

    public void setIcoModulo(String icoModulo) {
        this.icoModulo = icoModulo;
    }

    public String getIcoSubmodulo() {
        return icoSubmodulo;
    }

    public void setIcoSubmodulo(String icoSubmodulo) {
        this.icoSubmodulo = icoSubmodulo;
    }
    private String icoModulo;
    private String icoSubmodulo;
   

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApePaternoUsuario() {
        return apePaternoUsuario;
    }

    public void setApePaternoUsuario(String apePaternoUsuario) {
        this.apePaternoUsuario = apePaternoUsuario;
    }

    public String getApeMaternoUsuario() {
        return apeMaternoUsuario;
    }

    public void setApeMaternoUsuario(String apeMaternoUsuario) {
        this.apeMaternoUsuario = apeMaternoUsuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDescPais() {
        return descPais;
    }

    public void setDescPais(String descPais) {
        this.descPais = descPais;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getDescDepartamento() {
        return descDepartamento;
    }

    public void setDescDepartamento(String descDepartamento) {
        this.descDepartamento = descDepartamento;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getDescProvincia() {
        return descProvincia;
    }

    public void setDescProvincia(String descProvincia) {
        this.descProvincia = descProvincia;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getDescDistrito() {
        return descDistrito;
    }

    public void setDescDistrito(String descDistrito) {
        this.descDistrito = descDistrito;
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getDescArea() {
        return descArea;
    }

    public void setDescArea(String descArea) {
        this.descArea = descArea;
    }

    public String getCodigoTipoDOI() {
        return codigoTipoDOI;
    }

    public void setCodigoTipoDOI(String codigoTipoDOI) {
        this.codigoTipoDOI = codigoTipoDOI;
    }

    public String getDescTipoDOI() {
        return descTipoDOI;
    }

    public void setDescTipoDOI(String descTipoDOI) {
        this.descTipoDOI = descTipoDOI;
    }

    public String getNumeroDOI() {
        return numeroDOI;
    }

    public void setNumeroDOI(String numeroDOI) {
        this.numeroDOI = numeroDOI;
    }

    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFcese() {
        return fcese;
    }

    public void setFcese(String fcese) {
        this.fcese = fcese;
    }

    public String getMotivoCese() {
        return motivoCese;
    }

    public void setMotivoCese(String motivoCese) {
        this.motivoCese = motivoCese;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public String getContadorUsuario() {
        return contadorUsuario;
    }

    public void setContadorUsuario(String contadorUsuario) {
        this.contadorUsuario = contadorUsuario;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getCodMensaje() {
        return codMensaje;
    }

    public void setCodMensaje(String codMensaje) {
        this.codMensaje = codMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
