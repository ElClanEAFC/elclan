<div class="modal fade" id="modalEditarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h4 class="modal-title text-white" id="exampleModalLabel">EDITAR USUARIO</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!--ENCABEZADO SEARCH-->
                <!------formulario--->
                <div>
                    <h4 id="tituloUsuario">DATOS DEL USUARIO</h4>
                    <p><br></p>
                    <form id="formRegistroUsuario" class="">
                        <div class="row">
                            <div class="col-3">
                                <label for="usuTDoc">Tipo de Documento *</label>
                                <select id="usuTDoc" name="usuTDoc" class=" form-control" >
                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuNumDoc">N° Documento *</label>
                                <input id="usuNumDoc" name="usuNumDoc" type="text" maxlength="8"
                                       class="form-control" onkeypress="soloNumeros(event);" onkeyup="buscarDOI(this.value);" onchange="" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <label for="usuNombre">NOMBRES *</label>
                                <input id="usuNombre" name="usuNombre" type="text" class=" form-control datos"   > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuApaterno">APELLIDO PATERNO *</label>
                                <input id="usuApaterno" name="usuApaterno" type="text" class=" form-control datos"   >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuAmaterno">APELLIDO MATERNO *</label>
                                <input id="usuAmaterno" name="usuAmaterno" type="text" class=" form-control datos"   >   
                                <!--                                    <div class="valid-feedback">
                                                                        Looks good!
                                                                    </div>-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <label for="usuCelular">CELULAR *</label>
                                <input id="usuCelular" name="usuCelular" type="text" class=" form-control datos datoEdita" maxlength="9" >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuCorreo">CORREO *</label>
                                <input id="usuCorreo" name="usuCorreo" type="email" class=" form-control datos datoEdita" required="" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuDireccion">DIRECCIÓN *</label>
                                <input id="usuDireccion" name="usuDireccion" type="text" class=" form-control datos datoEdita" >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3">
                                <label for="usuPais">PAIS *</label>
                                <select name="usuPais" id="usuPais" class="form-control datos datoEdita"  >
                                    <!--<option value="51">Perï¿½</option>-->
                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuDpto">DEPARTAMENTO *</label>
                                <select name="usuDpto" id="usuDpto" class=" form-control datos datoEdita" onchange="listarProv();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuProv">PROVINCIA *</label>
                                <select name="usuProv" id="usuProv" class=" form-control datos datoEdita" onchange="listarDist();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuDist">DISTRITO *</label>
                                <select name="usuDist" id="usuDist" class=" form-control datos datoEdita"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3">
                                <label for="usuArea">AREA *</label>
                                <select name="usuArea" id="usuArea" class=" form-control datos"  onchange="listarPerfil();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuCargo">CARGO / PUESTO *</label>
                                <select name="usuCargo" id="usuCargo" class="form-control datos"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuFNacimiento">FECHA NACIMIENTO *</label>
                                <input id="usuFNacimiento" name="usuFNacimiento" type="date" class="form-control datos datoEdita" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuFinicio">FECHA INGRESO *</label>
                                <input id="usuFinicio" max="9999-12-31" name="usuFinicio" type="date" class=" form-control datos" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CERRAR</button>
                <button class="btn btn-success text-white" onclick="validarCamposUsu();" id="btnActualizarUsuario">ACTUALIZAR</button>
                <button class="btn btn-success text-white hide" onclick="validarCamposUsu();" id="btnGuardarUsuario">GUARDAR</button>
            </div>
            <!-- ===== LOADER ======= -->
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    async function editarUsuario(codTDoc, numDoc, titulo = 0) {
        if (titulo == 1) {
            $('#exampleModalLabel').text("EDITAR VENDEDOR");
            $('#tituloUsuario').text("DATOS DEL VENDEDOR");
        }else{
            $('#exampleModalLabel').text("EDITAR USUARIO");
            $('#tituloUsuario').text("DATOS DEL USUARIO");
            
        }
        $('#modalEditarUsuario').modal('show');
        /* if (!userDetalle) {
         $('#modalEditarUsuario').modal('show');
         }*/
        loaderON();
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=validarNumDoc',
            data: 'codTDoc=' + codTDoc + '&numDoc=' + numDoc,
            dataType: 'json',
            beforeSend: function () {
            }, success: async function (res) {
                console.log(res);
                
                if (res.codMensaje == '1') {
                    if (userDetalle) {
                        llenarDatosDetalles(res);
                        loaderOFF();
                        userDetalle = false;
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                    } else {
                        if (codUser1 != null) {
                            codUser2 = res.codigoUsuario;
                            validarDB = true;
                            valiDarReniec = false;
                        } else {
                            codUser1 = res.codigoUsuario;
                        }
                        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                        
                        await listaDepartamentos();
                        await listaProvincias(res.codigoDepartamento);
                        await listaDistritos(res.codigoDepartamento, res.codigoProvincia);
                        await listaPaises();
                        // FUNCION CARGAR TIPOS DE DOCUMENTOS
                        cargarTipoDoc();
                        // FUNCION LLENAR CAMPOS EN FORMULARIO!
                        llenarCamposUsuario(res);
                        $('.datos').attr("disabled", true);
                        $('input.datoEdita').attr('disabled', false);
                        $('select.datoEdita').attr('disabled', false);
                        $('#modalEditarUsuario').modal('show');
                        $('#btnActualizarUsuario').removeClass('hide');
                        $('#btnGuardarUsuario').addClass('hide');
                        loaderOFF();
                    }
                    
                } else {
                    let userreniec = {"dni": numDoc};
                    //FUNCION BUSCAR EN API-RENIEC
                    buscarReniec(userreniec);
                }
            }, complete: function () {
                
            }
        });
    }
    
</script>