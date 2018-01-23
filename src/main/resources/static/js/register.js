function checkPasswordIfSame() {
	if ($("#password").val() == "" || $("#passwordCopy").val() == "") {
		$("#passwordError").text("密码不能为空，请重新输入");
		return;
	}
	if ($("#password").val() != $("#passwordCopy").val()) {
		$("#passwordError").text("两次密码不一致，请重新输入");
	}
	if ($("#password").val() == $("#passwordCopy").val()) {
		$("#passwordError").text("两次密码一致");
	}
}

function checkUserNameIfExists() {
	var userNameVal = $("#userName").val();
	if ("" == userNameVal) {
		return;
	}
	$.ajax({
		type : "post",
		url : "checkUserNameIfExists.do",
		data : {
			"userName" : userNameVal
		},
		dataType : "json",
		success : function(result) {
			console.log($("#firstError"));
			console.log($("#firstError").val());
			if ($("#firstError").length == 0) {
				$("#errorMessage").text(result.message);
			}
			if ($("#firstError").length != 0) {
				$("#firstError").text(result.message);
			}

		}
	});
}