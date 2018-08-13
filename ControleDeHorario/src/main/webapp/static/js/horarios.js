$(document).ready(function() {

	aplicarListaners();

});

var limparModalEditar = function() {
	$('#idHorario').val('');
	$('#horaEntrada').val('');
	$('#saidaAlmoco').val('');
	$('#retornoAlmoco').val('');
	$('#saida').val('');
};

var aplicarListaners = function() {

	$('.data').mask('00/00/0000', {
		reverse : true
	});

	$('.horaEntrada').mask('00:00', {
		reverse : true
	});

	$('.saidaAlmoco').mask('00:00', {
		reverse : true
	});

	$('.retornoAlmoco').mask('00:00', {
		reverse : true
	});

	$('.saida').mask('00:00', {
		reverse : true
	});

	$('#modalAlterar').on('hide.bs.modal', limparModalEditar);

	$('.btn-editar').click(function() {
		var idHorario = $(this).parents('tr').data('id');
		var url = "horario/" + idHorario;

		$.get(url).done(function(horario) {
			$('#idHorario').val(horario.idHorario);
			$('#data').val(horario.data);
			$('#horaEntrada').val(horario.horaEntrada);
			$('#saidaAlmoco').val(horario.saidaAlmoco);
			$('#retornoAlmoco').val(horario.retornoAlmoco);
			$('#saida').val(horario.saida);

			$('#modalAlterar').modal('show');
		});
	});

	$('#btn-salvar').click(function() {

		var url = "horario";
		var dadosHorario = $('#form-horario').serialize();

		$.post(url, dadosHorario).done(function(pagina) {

			$('#secao-horarios').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

};