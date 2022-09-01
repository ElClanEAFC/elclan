function limitarFechaAyer(dias){
        let fecha = new Date();
        fecha.setDate(fecha.getDate() - dias);
        let ayer = fecha.toISOString().slice(0,10);
        return ayer;
};

function limitarFechaAyerManana(atras,adelante){
        let fec1 = new Date();
        let fec2 = new Date();
        fec1.setDate(fec1.getDate() - atras);
        let ayer = fec1.toISOString().slice(0,10);
        
        fec2.setDate(fec2.getDate() + adelante);
        let manana = fec2.toISOString().slice(0,10);        
        
        let limiteFecha = {
            "min": ayer,
            "max": manana
        };
        return limiteFecha;
};

function limitarAnioEdad(anios){
    let fec1 = new Date();
    fec1.setFullYear(fec1.getFullYear() - anios);
    let maxAnios = fec1.toISOString().slice(0,10);
    
    let limiteEdad = {
        "max": maxAnios 
    };
    return limiteEdad;
}



