<%-- 
    Document   : unidades
    Created on : 31 ago. 2022, 14:12:24
    Author     : sistemas02 - Victor Rosales Arones
--%>
<style>
    .nav-link{
        background: #000;
        color: #fff;
        border-radius: 5px 5px;

    }

</style>
<div class="container-fluid" >
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link tab-active  border-0"  id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">VENDEDORES</button>
        </li>

        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 " id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">CATEGORIAS</button>
        </li>

        <li class="nav-item" role="presentation">
            <button class="nav-link  border-0 "  id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact-tab-pane" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">CONFIG. CATEGORIAS</button>
        </li>
    </ul> 
</div>

<div class="tab-content" id="myTabContent" >
    <jsp:include page="../../../components/ventas/vendedores/modals/vendedores.jsp" /> 

    <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0" >
        Lorem ipsum dolor sit amet consectetur adipisicing elit. 22222222222
    </div>
    
    <div class="tab-pane fade" id="contact-tab-pane" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">...</div>
    <div class="tab-pane fade" id="disabled-tab-pane" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">...</div>
</div>