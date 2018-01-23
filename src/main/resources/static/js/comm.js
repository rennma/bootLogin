/*用js发送post请求.*/
function post(url) {
	var temp = document.createElement("form");
	temp.action = url;
	temp.method = "post";
	temp.style.display = "none";
	document.body.appendChild(temp);
	temp.submit();
	return temp;
}