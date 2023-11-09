function controleRotasGet(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/edit/usuario":
            $.get(url,function(data){
            $(".container").html(data);
            $("#salvar").click(salvar);
            });
            break;
        case "/Hominha":
            $.get(url,function(data){
            $(".container").html(data);
            });
        break;
        case "/Portas":
             $.get(url,function(data){
             $(".container").html(data);
             });
        break;
    }
}