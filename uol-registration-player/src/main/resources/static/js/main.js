

var Main = {
		contentType : "application/json",
		getURLParameter : getURLParameter
		
};

Main.ajax = function(url, type,data , contentType) {
	
	return $.ajax({
		url : url,
		type : type,
		data : JSON.stringify(data),
		contentType: (contentType ? contentType : Main.contentType)
	});
}


function getURLParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for (var i = 0; i < sURLVariables.length; i++) {
	    var sParameterName = sURLVariables[i].split('=');
	    if (sParameterName[0] == sParam) {
	        return sParameterName[1];
	    }
	}
}


