<%-- 
    Document   : modalExperienciaUsu
    Created on : 13 set. 2022, 12:49:21
    Author     : Victor Rosales Arones
--%>

<!--========================AGREGAR INFORMACION  ADICIONAL DEL USUARIO=========================-->
<div class='modal fade' id='addExperiencia' tabindex='-1' aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class='modal-dialog modal-xl'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title text-white'><i class="fas fa-tags"></i>AGREGAR EXPERIENCIAS</h4>
                <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <!--CEBECERA-->
                    <input type="hidden" name="codUsuExp" id="codUsuExp">
                    <form class="row" id="formExperiencia">
                        <div class="col-md-4">
                            <label>PUESTO: *</label>
                            <input type="text" id="puesto" name="puesto" class="form-control">
                            <ol id="suggestions" class="autocomplete">
                            </ol>
                        </div>  
                        <div class="col-md-2">
                            <p>
                                <label>F. INICIO *</label>
                                <input type="date" name="fecIni" id="fecIni" class="form-control">
                            </p>
                        </div>
                        <div class="col-md-2">
                            <p>
                                <label>F. Fin *</label>
                                <input type="date" name="fecFin" id="fecFin" class="form-control">
                            </p>
                        </div>
                        <div class="col-md-4">
                            <label>EMPRESA: *</label>
                            <input type="text" name="empresa" id="empresa" class="form-control">
                            <ol id="resEmpresa" class="autocomplete"></ol>
                        </div>
                        <div class="col-12">
                            <label for="exampleFormControlTextarea1" class="form-label">OBSERVACIONES(opcional):</label>
                            <textarea class="form-control" id="observaciones" name="observaciones" rows="2"></textarea>
                        </div>
                    </form>
                        <div class="col-12 text-center d-flex justify-content-end">
                            <p class="my-1">
                                <button type="button" class="btn btn-primary btn-success" onclick="validarCamposExp();"><i class="fas fa-check">AÑADIR</i></button>
                            </p>
                        </div>
                    <div class="row">
                        <div class="col-md-12"><hr></div>
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table id="tablaExpreriencias"  class="table datatable-basic ui celled table responsive nowrap unstackable " width="100%" autocomplete="off">
                                    <thead>
                                        <tr>
                                            <th>N°</th>
                                            <th>PUESTO LABORAL</th>
                                            <th>TIEMPO LABORAL </th>
                                            <th>EMPRESA</th>
                                            <th>OPCIONES</th>                  
                                        </tr>
                                    </thead>
                                    <!--<tbody id="listaUser">-->
                                    <tbody>

                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
            <div class='modal-footer'>
                <!--<button type='button' onclick='darBajaUsuario();' class='btn btn-primary btn-success'>Confirmar</button>-->
                <button type='button' onclick='cerrarModal("addExperiencia");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>CERRAR</button>
            </div>
        </div>
    </div>
</div>
<script >
    
     function agregarExperiencia(codUsuario) {    
        $("#suggestions").empty();
        $('#suggestions').css('display', 'none'); 
        $("#resEmpresa").empty();
        $('#resEmpresa').css('display', 'none'); 
        $("#addExperiencia").modal('show');
        $("#codUsuExp").val(codUsuario);
        codUser = codUsuario;
        $("#formExperiencia input").val(''); 
        $("#formExperiencia textarea").val(''); 
        let valores = $('#formExperiencia').validate();
        valores.destroy();
        listaExperienciasLab(codUsuario);
    }
</script>
