class Router {

    //Constructor
    constructor(paths){
        this.paths = paths;
        this.initRouter();
    }

    //Método para iniciar el router
    async initRouter(){
        const {location : {
            pathname = "/elclan/vistas/layout/elclan.jsp"
        }} = window;
        const URI = pathname === "/elclan/vistas/layout/elclan.jsp" ? "inicio" : pathname.replace("/","");
        await this.load(URI);
    }
    //Método para cargar las vistas
    async load(page = "inicio"){
        const {paths} = this ;
        const {path, template} = paths[page] || paths.error;
        //const $CONTAINER = document.querySelector('#content-pages');
//        const html = await fetch(template).then((data) => data );
        await $('#content-pages').load(template);
        window.history.pushState({},'genial', path);
        console.log(this);
    }
}