function controleRotasGet(url){
        if(url === "/logout"){
            gerarSwal(url);
        }else if (url === "/edit/usuario"){
            $.get(url,function(data){
            $(".container").html(data);
            $("#salvar").click(updatelogin);
            });
        }else if (url === "/Hominha"){
            $.get(url,function(data){
            $(".container").html(data);
            });
        }else if (url === "/Portas"){
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
        }else if (url.startsWith("/reservaA")){
            $.get(url,function(data){
                            $(".a").click(function(){
                                event.preventDefault();
                                $.get($(this).attr("href"),function(data){
                                    alert(data.mensagem);
                                    if(data.sucesso){
                                        alert("excloiu!")
                                    }
                                });
                            })
                         });
        }
        else if(url.startsWith("/removerR")){
               let id = url.replace("/removerR/","");
               gerarSwal2(url, id);
        }
 }
