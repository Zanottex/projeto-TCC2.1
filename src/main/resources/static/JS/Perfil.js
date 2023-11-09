

function updatelogin(){
    let nome = $("#Usuario").val();
    let cpf = $("cpf").val();
    let senha = $("#senha").val();
    let novaSenha = $("#novaSenha").val();
    let confSenha = $("#confSenha").val();

    $.ajax({
        type: "POST",
        url: "/",
        data:{
            nome:nome,
            senha:senha,
            confSenha:confSenha,
            novaSenha:novaSenha,
            cpf:cpf,
        },
        success: function(data){
            if(data){
                alertaSucesso("Deu Bom")
            }else{
                alert("Senha ou usuario inválidos")
            }
        },
        error: function(data){
            alert("Falha ao tentar realizar o login!")
        }
    })
}

function alertaSucesso(mensagem){
    Swal.fire({
        position: 'top-end',
        toast: true,
        icon: 'success',
        title: mensagem,
        showConfirmButton: false,
        timer: 2000
    });
}