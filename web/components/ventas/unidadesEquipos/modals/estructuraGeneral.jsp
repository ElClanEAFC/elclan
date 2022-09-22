<%-- 
    Document   : estructuraGeneral
    Created on : 15 set. 2022, 17:26:16
    Author     : sistemas03
--%>

<link href="../assets/libs/chartOrg/Themes/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
<script  src="../assets/libs/chartOrg/js/jquery-1.10.2.js"/></script>    
<script type="text/javascript">
</script>
<link rel="stylesheet" type="text/css" href="../assets/libs/chartOrg/css/jHTree.css "/>
<script src="../assets/libs/chartOrg/js/jquery-ui-1.10.4.custom.min.js"/></script>   
<script src="../assets/libs/chartOrg/js/jQuery.jHTree.js"/></script>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="tree">  
    
</div>
<script>
    $1 = jQuery.noConflict(true);
    $(document).ready(async function () {

        await listarDiagramaVentas();
    });
    // ListarEstructuraGeneral
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
        let estruc = {};
//        
//        // RECORRER LISTA DE VENDEDORES (GERENTE - JEFE - SUPERVISOR - COORDINADOR - EJECUTIVO)

        var ejecutivos = data.filter(  (eje) => 
            eje?.v_desPerfil.includes("EJECUTIVO")
        );
        console.log(ejecutivos);
        data.forEach((ven) => {
            
            if (ven?.v_numero === '0') {
                estruc = {//GERENCIA
                    'head': ven?.v_desPerfil,
                    'id': 0,
                    'contents': ven?.v_datosVen,
                    'children': []
                };
            }
            if ((ven?.v_numero == '1')) {
                estruc?.children?.push({// JEFE DE VENTAS (UNIDAD)
                    'head': ven?.v_desPerfil + ' - ' + ven?.v_codUnidad ,
                    'id': ven?.v_codUnidad,
                    'contents': ven?.v_datosVen,
                    "children": []
                });
            }
            estruc?.children?.forEach((sup) => {
                if ((ven?.v_numOrden == '1' && ven?.v_numero == '2') && (sup?.id == ven?.v_codUnidad)) {
                    sup?.children?.push({// SUPERVISOR O COORDINADOR (EQUIPOS)
                        'head': ven?.v_datos,
                        'id': ven?.v_codEquipo,
                        'contents': ven?.v_datosVen,
                        "children": []
                    });
                    
                    /********************* EQUIPOS******************/
                    sup?.children?.forEach((supe) => {
                        let lista;
                        ejecutivos.forEach((eje) => {
                            if(supe?.id === eje?.v_codEquipo){
                                lista += '<p>' +  eje.v_datosVen + '</p>';
                            }
                        });
                        supe?.children?.push({
                            'head': "EJECUTIVOS ",
                            'id': ven?.v_codEquipo,
                            'contents': lista,
                            "children": []
                        });
                    });
                }
            }); 
            
            /*************************************************************************/
//            if(ven?.v_datos?.includes("EQUIPO") && ven?.v_desPerfil?.includes("EJECUTIVO")){
//                estruc?.children?.forEach((sup) => {
//                    sup?.children?.forEach((equi) => {
//                        if(ven?.v_codEquipo === equi?.id){
//                            equi?.chidlren?.push({
//                                
//                            });
//                        }
//                    });
//                });
//            }
                
        });
        console.log(estruc);
//        
//        // CREAR ORGANIGRAMA GENERAL
        $1("#tree").jHTree({
            callType: 'obj',
            structureObj: [estruc]
        });
    }
</script>
