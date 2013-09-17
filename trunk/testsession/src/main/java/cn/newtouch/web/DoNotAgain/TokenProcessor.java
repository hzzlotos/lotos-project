package cn.newtouch.web.DoNotAgain;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenProcessor {

	private long previous;
	
	private static TokenProcessor instance = new TokenProcessor();
	
	public static String KEY = "FORM_TOKEN_KEY";
	
	private TokenProcessor () {}
	
	public static TokenProcessor getInstance () {
		
		return instance;
	}
	
	public boolean isTokenValid (HttpServletRequest request, HttpServletResponse response,PrintWriter out) {
		
		HttpSession session = request.getSession();
		
		if ( null == session) {
			
			return false;
		}
		
		String saved = (String) session.getAttribute(KEY);
		
		if ( null == saved) {
			
			return false;
		}
		
		out.println("session=  "+saved);
		
		out.println("==================================");
		
		String token = request.getParameter(KEY);
		
		if ( null == token){
			
			return false;
		}
		
		out.println("request=  "+token);
		
		return saved.equals(token);
	}
	
	public void resetToken (HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if ( null == session) {
			
			return;
		}
		
		session.removeAttribute(KEY);
	}
	
	public void saveToken (HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		
		byte[] id = session.getId().getBytes();
		
		long current = System.currentTimeMillis();
		
		if ( current == previous) {
			
			current++;
		}
		
		previous = current;
		
		byte[] now = String.valueOf(current).getBytes();
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			md.update(id);
			
			md.update(now);
			
			String token = toHex(md.digest());
			
			session.setAttribute(KEY, token);
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	}
	
	private String toHex(byte[] buffer) {
		
		StringBuffer sb = new StringBuffer(buffer.length*2);
		
		for ( int i = 0; i < buffer.length; i++) {
			
			sb.append(Character.forDigit((buffer[i] & 0xf0) >>4, 16));
		}
		
		return sb.toString();
	}
}