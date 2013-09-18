function jumpPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#mainForm").submit();
}

function skipsubmit() {
	if (isNaN($("#num").val())) {
		alert("请输入数字！");
		return false;
	}
	if ( $("#num").val() > Math.ceil($("#totalCount").val()/$("#pageSize").val())) {
		alert("输入的跳转页码超过最大页码！");
		return false;
	} else if ($("#num").val()!= ""){
		jumpPage($("#num").val());
	}
}

function sort(orderBy, defaultOrder) {
	if ($("#orderBy").val() == orderBy) {
		if ($("#order").val() == "") {
			$("#order").val(defaultOrder);
		}
		else if ($("#order").val() == "desc") {
			$("#order").val("asc");
		}
		else if ($("#order").val() == "asc") {
			$("#order").val("desc");
		}
	}
	else {
		$("#orderBy").val(orderBy);
		$("#order").val(defaultOrder);
	}

	$("#mainForm").submit();
}

function search() {
	$("#order").val("");
	$("#orderBy").val("");
	$("#pageNo").val("1");

	$("#mainForm").submit();
}

/**
 * 删除记录
 * @param url
 * @return
 */
function delRecord(url){
	if(confirm("你确认删除？")){
		window.location.href = url;
	}
}

/**
 * 取消
 * @param url
 * @return
 */
function canRecord(url){
	if(confirm("你确认取消？")){
		window.location.href = url;
	}
}
/**
 * 编辑记录
 * @param url
 * @return
 */
function editRecord(url){
	window.location.href = url;
}	