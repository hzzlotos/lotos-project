function obj2str(o){
	var r = [];
	if(typeof o == "string" || o == null) {
		return o;
	}
	if(typeof o == "object"){
		if(!o.sort){
			r[0]="{"
			for(var i in o){
				r[r.length]=i;
				r[r.length]=":";
				r[r.length]=obj2str(o[i]);
				r[r.length]=",";
			}
			r[r.length-1]="}"
		}else{
			r[0]="["
			for(var i =0;i<o.length;i++){
				r[r.length]=obj2str(o[i]);
				r[r.length]=",";
			}
			r[r.length-1]="]"
		}
		return r.join("");
	}
	return o.toString();
}

function getCookie(cookieName) {
		var cookieString = document.cookie;
		var start = cookieString.indexOf(cookieName + '=');
		if (start == -1) // 找不到
		return null;
		start += cookieName.length + 1;
		var end = cookieString.indexOf(';', start);
		if (end == -1) return unescape(cookieString.substring(start));
		return unescape(cookieString.substring(start, end));
}