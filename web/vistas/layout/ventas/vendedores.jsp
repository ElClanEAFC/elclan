<%-- 
    Document   : unidades
    Created on : 31 ago. 2022, 14:12:24
    Author     : sistemas02 - Victor Rosales Arones
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
    .navbarSupportedContent{
        visibility:hidden !important;
        
    }

</style>
<div class="container-fluid" >
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link tab-active  border-0"  id="nav-home-tab"  data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="false">VENDEDORES</button>
        </li>

        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 " id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">CATEGORIAS</button>
        </li>

        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 "  id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">CONFIG. CATEGORIAS</button>
        </li>
    </ul> 
</div>

<div class="tab-content" id="myTabContent" >
    <jsp:include page="../../../components/ventas/vendedores/modals/vendedores.jsp" /> 

    <jsp:include page="../../../components/ventas/vendedores/modals/categorias.jsp" /> 

    <jsp:include page="../../../components/ventas/vendedores/modals/config.categoria.jsp" /> 
    <jsp:include page="../reHumanos/modalActualizarUsu.jsp" />  
    <jsp:include page="../reHumanos/modalExperienciaUsu.jsp" />  
    
     
</div>

<script>

    cargar();
    function cargar() {
        $("#nav-home-tab").addClass("active");
        $("#nav-contact").removeClass("active");
        $("#nav-profile").removeClass("active");
    }
    
    function conviertMayucula(e) {
    e.value = e.value.toUpperCase();
}   

</script>
