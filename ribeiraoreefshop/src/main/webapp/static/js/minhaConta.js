/*
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var aplicarListaners = function(){
	
	$('.btn-Salvar').click(function(){
		
		var url = "minhaConta/";
		var dadosDaPessoa = $('.form-pessoa').serialize();
		
		$.post(url, dadosDaPessoa).done(function(pagina){
			aplicarListaners();
		}).fail(function(){
			alert("Erro de dados inseridos!" + dadosDaPessoa);
		});
		
	});
		
	
	
};
