function desabilitaA(){
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
}

desabilitaA();

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

function gerarSwal2(urlSucesso,id){
    const swalWithBootstrapButtons = swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success me-2',
            cancelButton: 'btn btn-danger ms-2'
        },
        buttonsStyling: false
    })


    swalWithBootstrapButtons.fire({
        title: 'Deletar?',
        text: "Você realmente deseja deletar o horario ?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
        cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
        reverseButtons: false
    }).then((result) => {
        if (result.isConfirmed) {
            deletarHorario(id);
        }
    });
}

function gerarSwal3(urlSucesso,id){
    const swalWithBootstrapButtons = swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success me-2',
            cancelButton: 'btn btn-danger ms-2'
        },
        buttonsStyling: false
    })


    swalWithBootstrapButtons.fire({
        title: 'Deletar?',
        text: "Você realmente deseja deletar o horario ?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
        cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
        reverseButtons: false
    }).then((result) => {
        if (result.isConfirmed) {
            deletarHorario2(id);
        }
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
            if(data.sucesso){
               mensagemSucesso(data.mensagem);
               $('#novaReserva').modal('hide');
               criarLinha(data.id
               , horarioE, horarioS, sala)
               }
               else{
               mensagemErro(data.mensagem)
               $('#novaReserva').modal('hide');
               }

            },
            error: function (){
               mensagemErro("Houve um problema ao salvar o Horario.");
            }

        });

}

function addReservaSema(){
    let horarioESema = $("#horarioESema").val();
    let horarioSSema = $("#horarioSSema").val();
    let data_ini = $("#data_inicio").val();
    let data_fim = $("#data_fim").val();
    let sala = $("#salaSema").val();
    let segunda = $("#segunda").prop('checked');
    let terça = $("#terça").prop('checked');
    let quarta = $("#quarta").prop('checked');
    let quinta = $("#quinta").prop('checked');
    let sexta = $("#sexta").prop('checked');
    let sabado = $("#sabado").prop('checked');
    let domingo = $("#domingo").prop('checked');


    $.ajax({
           type: "POST",
           url: "/ReservaSema",
           data: {
               horarioESema: horarioESema,
               horarioSSema: horarioSSema,
               data_ini : data_ini,
               data_fim : data_fim,
               salaSema: salaSema,
               segunda : segunda,
               terça : terça,
               quarta : quarta,
               quinta : quinta,
               sexta : sexta,
               sabado : sabado,
               domingo : domingo
           },
            success: function (data){
            if(data.sucesso){
               mensagemSucesso(data.mensagem);
               $('#novaReservaSema').modal('hide');
//               criarLinhaSema(data.id, horarioESema, horarioSSema, salaSema, segunda, terça, quarta, quinta, sexta, sabado, domingo)
               }
               else{
               mensagemErro(data.mensagem)
               $('#novaReservaSema').modal('hide');
               }

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
   timer: 2000
 })
 }

 function mensagemErro(mensagem){
 Swal.fire({
    position: 'top-end',
    icon: 'error',
    title: mensagem,
    showConfirmButton: false,
    timer: 2000
  })
  }

function deletarHorario(idHorario){
     $.ajax({
               type: "POST",
               url: "/deletar",
               data: {
                   idHorario: idHorario,
               },
                success: function (data){
                mensagemSucesso("Deletado com sucesso.");
                $("#excloi"+idHorario).remove();
                },
                error: function (){
                   mensagemErro("Não foi possivel deletar o horario.")
                }
            });
}

function deletarHorario2(idHorario){
     $.ajax({
               type: "POST",
               url: "/deletarSema",
               data: {
                   idHorario: idHorario,
               },
                success: function (data){
                mensagemSucesso("Deletado com sucesso.");
                $("#excloiSema"+idHorario).remove();
                },
                error: function (){
                   mensagemErro("Não foi possivel deletar o horario.")
                }
            });
}



function criarLinha(idHorario, horarioE, horarioS, sala){
    let data_aber = new Date(horarioE);
    let data_fech = new Date(horarioS);
    $("#listaReservas").append('<tr>' +
    '<td>' + idHorario + '</td>' +
    '<td>' + data_aber.toLocaleDateString() + ' '+ data_aber.toLocaleTimeString() + '</td>' +
    '<td>' + data_fech.toLocaleDateString() + ' '+ data_fech.toLocaleTimeString() + '</td>' +
    '<td>' + sala + '</td>' +
    '<td> <a th:href="${/removerR/ + reserva.id}" class="btn btn-sm btn-danger">-</a></td> '+
    '</tr>');
}
//function criarLinhaSema(idHorario, horarioE, horarioS, sala, segunda, terça, quarta, quinta, sexta, sabado, domingo{
//    let data_aber = new Date(horarioE);
//    let data_fech = new Date(horarioS);
//    $("#listaReservas").append('<tr>' +
//    '<td>' + if(segunda){ 'segunda'}+ '<td>' +
//    '<td>' + idHorario + '</td>' +
//    '<td>' + data_aber +
//    '<td>' + data_fech +
//    '<td>' + sala + '</td>' +
//    '<td> <a th:href="${/removerR/ + reserva.id}" class="btn btn-sm btn-danger">-</a></td> '+
//    '</tr>');
//}