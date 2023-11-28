function controleRotasGet(url){
        if(url === "/logout"){
            gerarSwal(url);
        }else if (url === "/edit/usuario"){
            $.get(url,function(data){
            $("#mainFrame").html(data);
            $("#salvar").click(updatelogin);
            });
        }else if (url === "/Hominha"){
            $.get(url,function(data){
                $("#mainFrame").html(data);
                $(".a").click(function() {
                    controleRotasGet($(this).attr("href"));
                });
            });
        }else if (url === "/Portas"){
             $.get(url,function(data){
                $("#mainFrame").html(data);
                $(".a").click(function(){
                event.preventDefault();
                $.get($(this).attr("href"),function(data){
                if(data.sucesso){
                   mensagemSucesso(data.mensagem)
                        }
                else{
                   mensagemErro(data.mensagem)
                }
                    });
                })
             });
            }
        else if(url.startsWith("/removerR")){
               let id = url.replace("/removerR/","");
               gerarSwal2(url, id);
        }
        else if(url.startsWith("/removerRSema")){
               let id = url.replace("/removerRSema/","");
               gerarSwal3(url, id);
        }
        
 }
