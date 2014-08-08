package com.nokia.ison.dispatch;

import javax.jms.JMSException;

import com.nokia.ison.MessageWrapperItf;

/**
 * Interface that handles sending the message to and
 * from MROController to MROExecutionEngine
 * @author acp
 *
 */
public interface SendMessageItf {
	
	public void sendMessage(MessageWrapperItf message) throws JMSException;

}
