/**
 * 
 */
package br.com.ribeiraoreefshop.model.enumerador;

/**
 * @author Tiago Ferezin
 *
 */
public enum ETipoAuditoria {
	
	InicializacaoSistema, 
	FinalizacaoSistema, 
	Acesso, 
	AcessoNegado, 
	Autenticacao, 
	AutenticacaoNegada, 
	AutenticacaoLogout, 
	RegistroAlterar, 
	RegistroInserir, 
	RegistroDesativar,
	Processo;	

}
