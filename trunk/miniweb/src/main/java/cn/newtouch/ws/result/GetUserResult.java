package cn.newtouch.ws.result;

import javax.xml.bind.annotation.XmlType;

import cn.newtouch.ws.WsConstants;
import cn.newtouch.ws.dto.UserDTO;

/**
 * GetUser方法的返回结果.
 * 
 * @author calvin
 */
@XmlType(name = "GetUserResult")
public class GetUserResult extends WSResult {

	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
