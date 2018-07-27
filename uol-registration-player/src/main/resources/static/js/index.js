$(function() {
		
	
	listarJogadores();
	
	$('#btnNovoJogador').click(function() {
		window.location = '/cadastro';
	});
	
	
});

function listarJogadores() {
	Main.ajax('/players', 'GET').then(function(response) {
		
		if(response) {
			var tBody = '';
			response.forEach(function(e,i) {
				tBody += '<tr>';
				tBody += '<td>' + e.name + '</td>';
				tBody += '<td>' + e.email + '</td>';
				tBody += '<td>' + e.phone + '</td>';
				tBody += '<td>' + e.codename + '</td>';
				tBody += '<td>' + e.group + '</td>';
				tBody += '<td><b style="cursor: pointer" onclick="editar(\'' + e.id + '\')">editar</b></td>';
				tBody += '<td><b style="cursor: pointer" onclick="excluir(\'' + e.id + '\')">excluir</b></td>';
				tBody += '</tr>';
			});
			
			$('#tablePlayers').html(tBody);
		}
		
		
	}, function(error) {
		alert('error');
	});
}

function editar(id) {
	window.location = '/editar?id=' + id;
}

function excluir(id) {
	
	if(confirm('Tem certeza que deseja excluir?')) {
		Main.ajax('/player?id=' + id, 'DELETE').then(function(response) {
			alert('Sucesso ao excluir jogador');
			listarJogadores();
		},function(error) {
			alert(error);
		});
	}
}


