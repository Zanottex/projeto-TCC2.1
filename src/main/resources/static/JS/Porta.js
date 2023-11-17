//$(".a").click(function mudarTipo(){
//    let estado = $(this).attr(text);
//    let estadoP = $("#estadoPorta").text();
//    if(estado == "Fechar"){
//    $('.btn').removeClass("btn-danger");
//    $('.btn').addClass("btn-success");
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


function abrirPorta(){
    let id= $("#1").val();

    $.ajax({
        type: "POST",
        url: "/PortasA",
        data:{
            id:id,
        },
        success: function(data){
            if(data){
                alertaSucesso("Dados do usuario atualizados com sucesso.")
            }else{
                alert("Senha ou usuario inválidos")
            }
        },
        error: function(data){
            alert("Deu Ruim!")
        }
    })
}