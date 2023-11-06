function controleRotasGet(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/edit/usuario":
            $.get(url,function(data){
            });
            break;
    }
}