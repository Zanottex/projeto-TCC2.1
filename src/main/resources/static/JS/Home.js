$('a').click(function(event){
    if(!$(this).hasClass('dropdown-toggle')){
        event.preventDefault();
        if(!$(this).hasClass('btn')){
            $('a').removeClass('active disabled');
            $(this).addClass('active disabled');
        }
        controleRotasGet($(this).attr("href"));
    }
});

$('.navbar-brand').off('click');

function gerarSwal(urlSucesso){
    const swalWithBootstrapButtons = swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success me-2',
            cancelButton: 'btn btn-danger ms-2'
        },
        buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
        title: 'Sair?',
        text: "Você realmente deseja sair da aplicação?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
        cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
        reverseButtons: false
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href=urlSucesso;
        }
    });
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

function addReserva(){
    let horarioE = $("#horarioE").val();
    let horarioS = $("#horarioS").val();
    let sala = $("#sala").val();

    $.ajax({
           type: "POST",
           url: "/Reserva",
           data: {
               horarioE: horarioE,
               horarioS: horarioS,
               sala: sala
           },
            success: function (data){
               mensagemSucesso("Horario Salvo com Sucesso.");
            },
            error: function (){
               mensagemErro("Houve um problema ao salvar o Horario.");
            }
        });
}
function mensagemSucesso(mensagem){
Swal.fire({
   position: 'top-end',
   icon: 'success',
   title: mensagem,
   showConfirmButton: false,
   timer: 1500
 })
 }

 function mensagemErro(mensagem){
 Swal.fire({
    position: 'top-end',
    icon: 'error',
    title: mensagem,
    showConfirmButton: false,
    timer: 1500
  })
  }

$("#deletar").click(deletarHorario);

function deletarHorario(){
    let idHorario = $("#idHorario").val();
     $.ajax({
               type: "POST",
               url: "/deletar",
               data: {
                   idHorario: idHorario,
               },
                success: function (data){
                   mensagemSucesso("Deletado com sucesso.");

                },
                error: function (){
                   mensagemErro("Não foi possivel deletar o horario.")
                }
            });
}

