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
               mensagemSucesso("Deu bom");
               $("#listaReservas").prepend('<tr>'+
                '<td>'+id+'</td>'+
                '<td>'+horarioE+'</td>'+
                '<td>'+horarioS+'</td>'+
                '<td>'+sala+'</td>'+
                '<td><buttontype="button" id="deletar" class="btn btn-sm btn-danger">-</button></td>'+
                '</tr>');

            },
            error: function (){
               alert("Deu n");
            }
        });
}
function mensagemSucesso(mensagem){
Swal.fire({
   position: 'top-end',
   icon: 'success',
   title: 'Horario Salvo com Sucesso',
   showConfirmButton: false,
   timer: 1500
 })
 }

 $("#deletar").click(deletarHorario);

function deletarHorario(){
    let id = $("#id").val();
     $.ajax({
               type: "POST",
               url: "/deletar",
               data: {
                   id: id,
               },
                success: function (data){
                   mensagemSucesso("Deletado com sucesso");

                },
                error: function (){
                   alert("Deu n");
                }
            });
}

