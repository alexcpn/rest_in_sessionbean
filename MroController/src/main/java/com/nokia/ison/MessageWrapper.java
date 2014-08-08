package com.nokia.ison;


public class MessageWrapper implements MessageWrapperItf {

	private String payload;
	private String senderid;
	private MessageType messageType;
	private CommandType commandType;

	@Override
	public String getPayload() {
		return payload;
	}

	@Override
	public void setPayload(String payload) {
		this.payload = payload;

	}

	@Override
	public void setMessageSenderId(String id) {
		this.senderid = id;

	}

	@Override
	public String getMessageSenderId() {

		return senderid;
	}

	@Override
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;

	}

	@Override
	public MessageType getMessageType() {

		return messageType;
	}
	
	@Override
	public String toJSON() {
	
		return null;
	}

	@Override
	public CommandType getCommandType() {
		
		return commandType;
	}
	
	@Override
	public void setCommandType(CommandType type) {
		this.commandType=type;
		
	}
}
