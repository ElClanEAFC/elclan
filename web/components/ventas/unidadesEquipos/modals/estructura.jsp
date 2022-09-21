<%-- 
    Document   : estructura
    Created on : 15 set. 2022, 15:52:15
    Author     : sistemas03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
<link href="../assets/libs/chartOrg/Themes/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
<script  src="../assets/libs/chartOrg/js/jquery-1.10.2.js"/></script>    
<script type="text/javascript">
</script>
<link rel="stylesheet" type="text/css" href="../assets/libs/chartOrg/css/jHTree.css "/>
<script src="../assets/libs/chartOrg/js/jquery-ui-1.10.4.custom.min.js"/></script>   
<script src="../assets/libs/chartOrg/js/jQuery.jHTree.js"/></script>  -->

<div class="tab-pane fade show active" id="nav-estructura" role="tabpanel" aria-labelledby="nav-estructura-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40" id="organigramaGeneral" >
                <!--                <div id="tree">  
                                </div>-->
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
//    $12 = jQuery.noConflict(true);
    
    $(document).ready(async function () {

        // CARGA DE ESTRUCTURA GENERAL
//        $('#organigramaGeneral').load("../../components/ventas/unidadesEquipos/modals/estructuraGeneral.jsp");
        // LISTAR DATOS DE ESTRUCTURA
        //await listarDiagramaVentas();
//        llenarOrganizadorGeneral();
    });
//
//    // ListarEstructuraGeneral
    function listarDiagramaVentas() {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarDiagramaVentas",
            data: "",
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                llenarOrganizadorGeneral(data); // LISTA
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    function llenarOrganizadorGeneral(data) {
//        let datos = [
//            {
//                codUnidad: "1",
//                codEquipo: "1",
//                datos: "Gerente Comercial",
//                desPerfil: "Gerente Comercial",
//                numOrden: "0",
//                datosVen: "Julio Gonzales",
//                numero: "0",
//                usuario: "Sr. Julio"
//            }
//        ];
//        
        let estruc = {};
//        
//        // RECORRER LISTA DE VENDEDORES
        data.forEach((ven) => {   
            if (ven?.v_numero === '0') {
                estruc = {      //GERENCIA
                    'head': ven?.v_desPerfil,
                    'id': ven?.v_numOrden,
                    'contents': ven?.v_datosVen,
                    'children': []
                };
            }
            if ((ven?.v_numero === '1') || (ven?.v_numero === '1' && ven?.v_numOrden === '1')) {
                estruc?.children?.push({     // JEFE DE VENTAS (UNIDAD)
                    'head': ven?.v_desPerfil,
                    'id': ven?.v_codUnidad,
                    'contents': ven?.v_datosVen,
                    "children": []
                });
            }
            estruc?.children?.forEach((sup) => {
                if ((ven?.v_numOrden === '1' && ven?.v_numero === '2') && (sup?.id == ven?.v_codUnidad)) {
                    sup?.children?.push({    // SUPERVISOR O COORDINADOR (EQUIPOS)
                        'head': ven?.v_datos,
                        'id': ven?.codEquipo,
                        'contents': ven?.datosVen,
                        "children": []
                    });
                }
            });

        });
        console.log(estruc);
//        
//        // CREAR ORGANIGRAMA GENERAL
//        $12("#tree").jHTree({
//            callType: 'obj',
//            structureObj: estruc
//        });
    }
</script>