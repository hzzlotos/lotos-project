package cn.newtouch.Util;

import javax.servlet.http.HttpServletRequest;

public class URLUtils {

	public static String getDomainName(HttpServletRequest request) {
		// http
		String head = request.getScheme();
		// 域名
		String domain = request.getServerName();
		// 端口号
		int port = request.getServerPort();
		// 应用名
		String path = request.getContextPath();			
		String basePath = head+"://"+domain+":"+port+path+"/";
		return basePath;
	}
	
	public static String getRealURL(HttpServletRequest request) {
		// http
		String head = request.getScheme();
		// 域名
		String domain = request.getServerName();
		// 端口号
		int port = request.getServerPort();
		// 应用名
		String path = request.getContextPath();	
		String servletPath =request.getServletPath();	
		String realURL = head+"://"+domain+":"+port+path+ servletPath;
		return realURL;
	}
}
