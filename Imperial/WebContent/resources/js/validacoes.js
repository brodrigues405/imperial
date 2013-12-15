/**
 * Valida os checkbox, verificando se pelo menos um foi selecionado.
 * 
 * Uso: onsubmit="return checkboxConhecimentos()" dentro da tag form
 * 
 * FIXME Corrigir e testar funcionamento.
 * 
 * @returns {Boolean}
 */
function checkboxConhecimentos() {
	
	conhecimento=document.forms[0].conhecimento;
	counter=0;
	
	for (i=0; i<conhecimento.length; ++i) {
		if (conhecimento[i].checked) {
			counter++;
		}
	}
	
	if (counter==0) {
		alert("Selecione pelo menos um campo de conhecimento.");
		return false;
	}
	
	return true;
}

/**
 * Valida a entrada do input permitindo somente numeros ou letras.
 * 
 * Uso: onkeyup="validar(this,'tipo');" sendo tipo = num para numeros e text para textos.
 * 
 * @param dom
 * @param tipo
 * 
 */
function validar(dom,tipo){
	
	switch(tipo) {
		case'num':var regex=/[A-Za-z]/g;break;
		case'text':var regex=/\d/g;break;
	}
	
	dom.value=dom.value.replace(regex,'');
}

/**
 * Funcao que deixa os valor em caixa alta.
 * Uso: onblur="mudarTamanho(this)"
 * @param variavel
 */

function mudarTamanho(variavel){
/* Essa função pode ser reutilizada em qualquer campo.
    o valor do campo recebe = o valor dele mesmo  mas em  maiúsculo
	 */
   variavel.value = variavel.value.toUpperCase();
};

/**
 * Impede o envio de um formulario pressionando enter.
 * Uso: onkeypress="return bloqEnter(event)" dentro do input.
 */
function bloqEnter(objEvent) 
{
 var iKeyCode;   
 iKeyCode = objEvent.keyCode;
 if(iKeyCode == 13) return false;
 return true;
}
