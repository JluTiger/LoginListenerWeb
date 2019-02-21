package com.imooc.cache;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * ��¼�û���session�������
 *
 */
public class LoginCache {
	private static LoginCache instance = new LoginCache();
	
	private Map<String,String> loginUserSession = new HashMap<String,String>();// keyֵ����¼�û���¼����valueֵ����¼�û�sessionId
	private Map<String,HttpSession> loginSession = new HashMap<String,HttpSession>();//keyֵ:��¼�û�sessionId,valueֵ����¼�û�session����
	
	private LoginCache(){
		
	}
	
	public static LoginCache getInstance(){
		return instance;
	}
	/**
	 * ͨ����¼����ȡ��Ӧ��¼�û���sessionId
	 * @param username
	 * @return
	 */
	public String getSessionIdByUsername(String username){
		return loginUserSession.get(username);
	}
	
	/**
	 * ͨ��sessionId��ȡ��Ӧ��session����
	 * @param sessionId
	 * @return
	 */
	public HttpSession getSessionBySessionId(String sessionId){
		return loginSession.get(sessionId);
	}
	
	/**
	 * �洢��¼�����Ӧ�ĵ�¼sessionID���������
	 * @param username
	 * @param sessionId
	 */
	public void setSessionIdByUserName(String username,String sessionId){
		loginUserSession.put(username, sessionId);
	}
	
	/**
	 * �洢sessionId���Ӧ��session�������������
	 * @param sessionId
	 * @param session
	 */
	public void setSessionBySessionId(String sessionId,HttpSession session){
		loginSession.put(sessionId, session);
	}

}
