package com.nokia.ison.dispatch;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import com.nokia.ison.MessageWrapperItf;

/**
 * Handled sending the message via JMS
 * @author acp
 *
 */
public class JMSSender implements SendMessageItf{

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/queue/test")
	private Queue queue;

	@Resource(mappedName = "java:/topic/test")
	private Topic topic;
	@Override
	public void sendMessage(MessageWrapperItf message) throws JMSException {
		Connection connection = null;
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(topic);
		connection.start();
		ObjectMessage objmsg = session.createObjectMessage();
		objmsg.setObject((Serializable) message);
		messageProducer.send(objmsg);



	}

}
