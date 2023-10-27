$("#logar").click(enviarlogin);

function enviarlogin(){
    let Usuario = $("#Usuario").val();
    let senha = $("#senha").val();

    $.ajax({
    type: "POST",
    url: "/",
    data:{
        Usuario:Usuario,
        senha:senha,
    },
    success: function(data){
    if(data){
    window.location.href="/home";
    }else{
    alert("Porcaria")
    }
    },
    error: function(data){
        alert("Falha ao tentar realizar o login!")
    }
    })
}