package com.imooc.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.imooc.cache.LoginCache;
/**
 * �û���¼������
 */
public class LoginSessionListener implements HttpSessionAttributeListener {
	
	private static final String LOGIN_USER="loginUser";

	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		String attrName = hsbe.getName();//������session����ֵ������Ӳ�������ȡ��Ӧ������������
		
		if(LOGIN_USER.equals(attrName)){//��������Ϊ��¼���������ж�Ϊ�û���¼����
			String attrVal = (String)hsbe.getValue();//��ȡ��ӵ�����ֵ�����û���¼��
			HttpSession session = hsbe.getSession();//�ôβ�����session����
			String sessionId = session.getId();//�ôβ�����session����ID
			
			String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrVal);//�ӻ���������棬��ø��û���¼����Ӧ��sessionIDֵ
			if(null == sessionId2){//δ��ý��������Ҫ����ǰ�ε�¼�û��Ự��Ϣ
				
			}else{
				HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);//��ȡǰ�θ��û���¼��Ӧ��session����
				session2.invalidate();//����ǰ�ε�¼�û��Ự�洢��Ϣ��ʹ��ǰ�ε�¼ʧЧ
			}
			
			//��ɸôε�¼�û���¼����sessionID��session����Ļ������洢
			LoginCache.getInstance().setSessionIdByUserName(attrVal, sessionId);
			LoginCache.getInstance().setSessionBySessionId(sessionId, session);
			
		}

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
