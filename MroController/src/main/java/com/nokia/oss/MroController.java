package com.nokia.oss;

import java.util.List;

import javax.ejb.Stateful;

import com.google.gson.Gson;
import com.nokia.ison.CommandType;
import com.nokia.ison.FeedbackType;
import com.nokia.ison.MessageType;
import com.nokia.ison.MessageWrapper;
import com.nokia.ison.external.StubScopeService;

@Stateful
public class MroController {


	/**
	 * This will be the entry point for MRO
	 * @param scopename
	 * @return
	 */
	public FeedbackType startMroforScope(String scopename){

		return FeedbackType.SUCCEESS;
	}

	//Split the DN's depending on the number of Nodes
	public void splitDNs(String scopename){

		//Get the DN's for the Scope
		List<String> dnlist =StubScopeService.getDNsforScopeName(scopename);
		//Split the DN's and send it to MDBS's

	}


	private void splitDNsandSendinBatchesOf(int size,List<String> dnlist){

		int iteration=dnlist.size()/size;
		int fromIndex=0;
		int toIndex=size;
		for(int i=0; i < iteration ; ++i){

			List<String> tempList= dnlist.subList(fromIndex, toIndex);
			MessageWrapper messageWrapper= new MessageWrapper();
			messageWrapper.setPayload(new Gson().toJson(tempList));
			messageWrapper.setMessageSenderId("Controller");
			messageWrapper.setMessageType(MessageType.COMMAND);
			messageWrapper.setCommandType(CommandType.START_NR);

			fromIndex=toIndex;
			if(toIndex+size > dnlist.size()){
				toIndex=dnlist.size();
			}else{
				toIndex=toIndex +size;
			}

		}



	} 

	public int getCIOForDN(String dn){

		return 10000;
	} 


}
