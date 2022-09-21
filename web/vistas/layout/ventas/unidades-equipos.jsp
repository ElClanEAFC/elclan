<%-- 
    Document   : unidades
    Created on : 31 ago. 2022, 14:12:24
    Author     : sistemas03 - yasub huaman ramos
--%>
<style>
    .nav-link{
        background: #000;
        color: #fff;
        border-radius: 10px 10px 0px 0px;

    }
    .nav-tabs > .nav-item{
        margin-left: 5px;
    }
    .nav-tabs .nav-link {
        border-radius: 10px 10px 0px 0px !important;
    }
    .nav-item>.active{
        position: relative;
        margin-bottom: -150px;
        z-index: 10;
        background: #fff;
        height: 40px !important;
    }
    .nav-item button:focus{
        border: 0px !important;
        outline: none !important;
    }
    .card-body {
        margin-top: 30px;
    }

</style>
<div class="container-fluid" >
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link tab-active  border-0"  id="nav-home-tab"  data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="false" onclick="vistaBloqueUnidad();">UNIDADES</button>
        </li>

        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 " id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-profile" aria-selected="false" onclick="vistaBloqueEquipo();">EQUIPOS</button>
        </li>
        
        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 " id="nav-estructura-tab" data-bs-toggle="tab" data-bs-target="#nav-estructura" type="button" role="tab" aria-controls="nav-estructura" aria-selected="false" onclick="vistaEstructuraGeneral();">ESTRUCTURA VENTAS</button>
        </li>

<!--        <li class="nav-item" role="">
            <button class="nav-link  border-0 "  id="nav-organigrama-tab" data-bs-toggle="tab" data-bs-target="#nav-organigrama" type="button" role="tab" aria-controls="nav-organigrama" aria-selected="false">ORGANIGRAMA</button>
        </li>-->
        
        <!-- <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 "  id="nav-config-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">CUADROS DE CONFIGURACION</button>
        </li>-->
    </ul> 
</div>

<div class="tab-content" id="myTabContent">
    <jsp:include page="../../../components/ventas/unidadesEquipos/modals/unidades.jsp" />
    <jsp:include page="../../../components/ventas/unidadesEquipos/modals/equipos.jsp" />
    <jsp:include page="../../../components/ventas/unidadesEquipos/modals/estructura.jsp" />
    
</div>
<script>
    cargar();
    function cargar() {
        $("#nav-home-tab").addClass("active");
        $("#nav-contact").removeClass("active");
        $("#nav-estructura").removeClass("active");
//        $("#nav-organigrama").removeClass("active");
    }
    function vistaBloqueUnidad (){
        vistaOrgEquipo = false;
        $('#organigramaUnidades').addClass('hide');
        $('#principalUnidad').removeClass('hide');
        $('#organigramaGeneral').empty();
        $('#organigrama').empty();
    }
    function vistaBloqueEquipo (){
        vistaOrgUnidad = false;
        $('#organigrama').addClass('hide');
        $('#principal').removeClass('hide');
        $('#organigramaGeneral').empty();
        $('#organigramaUnidades').empty();
    }
    function vistaEstructuraGeneral (){
        $('#organigramaGeneral').empty();
        $('#organigramaUnidades').empty(); 
        $('#organigrama').empty();    
        cargarOrganigramaGeneral()
    }
    function cargarOrganigramaGeneral(){
         $('#organigramaGeneral').load("../../components/ventas/unidadesEquipos/modals/estructuraGeneral.jsp");
    }
//    $(document).ready(funciton () {        
//    });
</script>

