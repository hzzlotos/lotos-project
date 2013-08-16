package cn.newtouch.ws.result;

import javax.xml.bind.annotation.XmlType;

import cn.newtouch.ws.WsConstants;

/**
 * AuthUser方法的返回结果.
 * 
 * @author calvin
 */
@XmlType(name = "AuthUserResult")
public class AuthUserResult extends WSResult {

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}