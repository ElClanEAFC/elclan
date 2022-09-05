<%-- 
    Document   : vendedores.jsp
    Created on : 31 ago. 2022, 17:44:09
    Author     : sistemas02
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40 " >
                <div class="row">
                    <div class="col-8" >
                        <div class="row">
                            <div class="col-4">
                                <input class="form-control mr-sm-2 rounded" id="userbuscar" name="userbuscar" type="search" placeholder="INGRESE DNI O NOMBRES">
                            </div>
                            <div class="col-3">
                                <select class="form-control" id="selectArea">
                                <option  value="0">--SELECCIONE UNIDAD 1--</option>
                                </select>              
                            </div>
                            <div class="col-3">
                                <select class="form-control" id="selectArea" >
                                <option  value="0">--SELECCIONE EQUIPO--</option>
                                </select>             
                            </div>
                            <div class="col-2">
                                <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoUser();">BUSCAR</button>            
                            </div>
                        </div>
                    </div>
                    <div class="col-2">                        
                    </div>
                    <div class="col-2">
                        <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoUser();">AÑADIR VENDEDOR</button>
                    </div>
                </div>
                <hr>
                <h4 class="card-title">LISTA DE VENDEDORES</h4>
                <!--table-bordered-->
                <table id="tablaVendedores" class="table table-striped " width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>NOMBRES</th>
                            <th>APELLIDO PATERNO</th>
                            <th>APELLIDO MATERNO</th>
                            <th>USUARIO</th>
                            <th>TIPO DOC.</th>
                            <th>N° DOCUMENTO</th>
                            <th>UNIDAD/EQUIPO</th>
                            <th>CARGO</th>
                            <th>ESTADO</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>                    
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>





</script>
