var txtName = null;
var txtEmail = null;
var txtTelefone = null;
var radioLigaDaJustica = null;
var radioVingadores = null;
var btnAlterar = null;
var btnListarJogadores = null;
var jogador = null;
var titleJogador = null;


$(function () {
	
	init();
	
	
	$('#btnAlterar').click(function() {
		alterar();
	});
	
	$('#btnListarJogadores').click(function() {
		window.location = '/';
	});
	
	
});

function init() {
	var id = Main.getURLParameter('id');
	titleJogador = $('#titleJogador');
	txtName = $('#txtNome');
	txtEmail = $('#txtEmail');
	txtTelefone = $('#txtTelefone');
	radioLigaDaJustica = $('#radioLigaDaJustica');
	radioVingadores = $('#radioVingadores');
	btnAlterar = $('#btnAlterar');
	btnListarJogadores = $('#btnListarJogadores');
	
	if(!id) {
		error();
	}
	
	Main.ajax('player?id=' + id , 'GET').then(function(response) {
		if(response) {
			jogador = response;
			titleJogador.html(response.name);
			txtName.val(response.name);
			txtEmail.val(response.email);
			txtTelefone.val(response.phone);
		}else {
			error();
		}
	},function(error) {
		error();
	});
}

function error() {
	alert('Erro ao buscar jogador');
	btnAlterar.attr('disabled', true);
}



function alterar() {
	if(txtName.val() && txtEmail.val() && txtTelefone.val()) {
		var data = {};
		data.id = jogador.id;
		data.name = txtName.val();
		data.email = txtEmail.val();
		data.phone = txtTelefone.val();
		data.group = $("input[name='grupo']:checked").val();
		
		Main.ajax('/player', 'PUT', data).then(function(response) {
			alert('Sucesso ao alterar jogador');
			titleJogador.html(txtName.val());
		},function(error) {
			if(typeof error === 'string') {
				alert(error);
			} else {
				alert('Erro ao alterar. Por favor tente mais tarde.');
			}
			
		});
    } else{
		alert('Preencha todos os campos');
		return;
    }
}



