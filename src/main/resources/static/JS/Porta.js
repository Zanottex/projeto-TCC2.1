//function mudarTipo(){
//    let estado = $(this).attr(text);
//    let estadoP = $("#estadoPorta").text();
//    if(estado == "Fechar"){
//    estado = "Abrir";
//    estadoP = "Fechada"
//    }else{
//    $('.btn').removeClass("btn-success");
//    $('.btn').addClass("btn-danger");
//    estado = "Fechar";
//    estadoP = "Aberta";
//    }
//    $(this).text(estado);
//    $("#estadoPorta").text(estadoP);
//})
//}
//function abrirPorta(){
//    let id= $("#1").val();
//
//    $.ajax({
//        type: "POST",
//        url: "/PortasA",
//        data:{
//            id:id,
//        },
//        success: function(data){
//            if(data){
//                mensagemSucesso("Porta fechada com sucesso!")
//
//            }else{
//                mensagemErro("Houve um problema ao fechar a porta verifique e tente novamente!")
//            }
//        },
//        error: function(data){
//            alert("Deu Ruim!")
//        }
//    })
//}

