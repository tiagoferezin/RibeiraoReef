/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var limparModalEditar = function() {
	$('#idProduto').val('');
	$('#nome').val('');
	$('#estoque').val('');
	$('#valor').val('');
};

var aplicarListaners = function() {
	
	$('#tabela-produtos').DataTable({
		dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
	});

	$('.valor').mask('0.00', {
		reverse : true
	});

	$('.estoque').mask('##0', {
		reverse : true
	});

	$('#modalAlterar').on('hide.bs.modal', limparModalEditar);

	$('.btn-editar').click(function() {
		var idProduto = $(this).parents('tr').data('id');
		var url = "produto/" + idProduto;

		$.get(url).done(function(produto) {
			$('#idProduto').val(produto.idProduto);
			$('#nomeProduto').val(produto.nomeProduto);
			$('#estoque').val(produto.estoque);
			$('#valor').val(produto.valor);

			$('#modalAlterar').modal('show');
		});
	});
	
	$('.btn-file').click(function(){
		
		var file = $('#file-form').serialize();
		var url = "produto/"+file;
		
		$.get(url).done(function(pagina) {

			$('#secao-produtos').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});
		
	});

	$('.btn-deletar').click(function() {
		
		var idProduto = $('.btn-deletar-tabela').parents('tr').data('id');

		$.ajax({
			url : "produto/" + idProduto,
			type : 'DELETE',
			success : function(result) {
			
				$('tr[data-id="' + idProduto + '"]').remove();
			}
		});

		$('#modalConfirmarExclusao').modal('hide');
	});

	$('#btn-salvar').click(function() {

		var url = "produto";
		var dadosProduto = $('#form-produto').serialize();

		$.post(url, dadosProduto).done(function(pagina) {

			$('#secao-produtos').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

};