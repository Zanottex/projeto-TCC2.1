

function updatelogin(){
    let nome = $("#nome").val();
    let cpf = $("#cpf").val();
    let senha = $("#senha").val();
    let novaSenha = $("#novaSenha").val();
    let confSenha = $("#confSenha").val();

    $.ajax({
        type: "POST",
        url: "/edit/usuario",
        data:{
            nome:nome,
            senha:senha,
            confSenha:confSenha,
            novaSenha:novaSenha,
            cpf:cpf,
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