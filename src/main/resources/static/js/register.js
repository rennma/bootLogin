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
			console.log($("span[errorMessage='errorMessage']"));
			console.log($("span[errorMessage='errorMessage']").val());
			if ($("span[errorMessage='errorMessage']").length == 0) {
				$("#errorMessage").text(result.message);
			}
			if ($("span[errorMessage='errorMessage']").length != 0) {
				$("span[errorMessage='errorMessage']").text(result.message);
			}

		}
	});
}