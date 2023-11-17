function controleRotasGet(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
        break;
        case "/edit/usuario":
            $.get(url,function(data){
            $(".container").html(data);
            $("#salvar").click(updatelogin);
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
                $(".a").click(function(){
                    event.preventDefault();
                    $.get($(this).attr("href"),function(data){
                        alert(data.mensagem);
                        if(data.sucesso){
                            //atualiza os butao
                        }
                    });
                })
             });
        break;


    }
}