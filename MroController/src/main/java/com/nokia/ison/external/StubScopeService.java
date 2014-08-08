package com.nokia.ison.external;

import java.util.ArrayList;
import java.util.List;

/**
 * Acting  as a stub class for Scope Service
 * @author acp
 *
 */
public class StubScopeService {
	
	
	static public List<String> getDNsforScopeName(String scopeName){
		
		List<String> mylist = new ArrayList<>();
		
		for(int i=0; i<300000;++i){
			
			mylist.add("PLMN_PLMN\\LNBTS-" + i + "\\LNCEL-"+ i);
		}
		return mylist;
	}

}
