document.write("<script type='text/javascript' src='../js/comm.js'></script>");

function logout(url) {
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		success : function(result) {
			if (result.message == "logoutSuccess") {
				post("../comm/login.html");
				return;
			}
		}
	});
}
