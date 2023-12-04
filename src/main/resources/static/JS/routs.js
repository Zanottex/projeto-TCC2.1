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
        else if(url.startsWith("/SemaremoverR")){
               let id = url.replace("/SemaremoverR/","");
               gerarSwal3(url, id);
        }
        
 }
