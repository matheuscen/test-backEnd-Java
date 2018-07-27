var txtName = null;
var txtEmail = null;
var txtTelefone = null;

$(function() {
	
	txtName = $('#txtNome');
	txtEmail = $('#txtEmail');
	txtTelefone = $('#txtTelefone');
	radioLigaDaJustica = $('#radioLigaDaJustica');
	radioVingadores = $('#radioVingadores');
	
	$('#btnCadastrar').click(function() {
		cadastrar();
	});
	
	$('#btnListarJogadores').click(function() {
		window.location = '/';
	});
	
});


function cadastrar() {
	if(txtName.val() && txtEmail.val() && txtTelefone.val()) {
		var data = {};
		data.name = txtName.val();
		data.email = txtEmail.val();
		data.phone = txtTelefone.val();
		data.group = $("input[name='grupo']:checked").val();
		
		Main.ajax('/player','POST', data).then(function(response) {
			if(response) {
				if(response == '001') {
					alert('Desculpe mas não temos mais codename para esse grupo. Por favor escolha outro grupo!')
				}
			} else {
				alert('Cadastrado com sucesso');
				window.location = '/';
			}
		}, function(error) {
			alert(error);
		});
    } else{
		alert('Preencha todos os campos');
		return;
    }
	
}