document.write("<script type='text/javascript' src='../js/comm.js'></script>");
/*登录的函数.*/
function login() {
	$.ajax({
		type : "post",
		url : "login.do",
		data : {
			"userName" : $("#userName").val(),
			"password" : $("#password").val()
		},
		dataType : "json",
		success : function(result) {
			console.log(result);
			if(result.message=="redirect"){
				post("../logined/welcome.html");
				return;
			}
			$("#errorMessage").text(result.message);
		}
	});
}