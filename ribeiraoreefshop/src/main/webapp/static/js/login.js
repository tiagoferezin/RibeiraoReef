/**
 * 
 */

$(document).ready(function() {

	$('.btn-entrar').click(function(){
		var url = "login";
		var dadosUsuario = $('#form-login').serialize();
		
		$.post(url, dadosUsuario).done(function(pagina){
			
			alert("Post");
			aplicarListaners();
		});
	});
	
	$('.btn-registrar').click(function(){
		var url = "login/registrarUsuario";
		var dadosUsuario = $('#form-cadastro').serialize();
		var senhaCad = $('#senhaCadastro').val();
		var senhaConf = $('#senhaConfirma').val();
		
		if(senhaCad == senhaConf){
			
			$.post(url, dadosUsuario).done(function(pagina){
				aplicarListaners();
			}).fail(function(){
				alert("Algo deu errado")
			});
			
		}else{
			alert("Senhas não correspondem!!!");
		}
		
		alert("SenhaCad: " +senhaCad + " Senha Conf: " + senhaConf);
		
	});
	

});