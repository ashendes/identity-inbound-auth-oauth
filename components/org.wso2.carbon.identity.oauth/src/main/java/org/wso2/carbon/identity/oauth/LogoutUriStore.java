package org.wso2.carbon.identity.oauth;

import java.util.HashMap;
import java.util.Map;

public class LogoutUriStore {

    private Map<String, String> logoutUriList;
    private static LogoutUriStore instance = new LogoutUriStore();

    private LogoutUriStore(){
        logoutUriList = new HashMap<>();
    }

    public static LogoutUriStore getInstance(){
        return instance;
    }

    public void setFrontchannelLogoutUrl(String clientId, String frontchannelLogoutUrl){
        logoutUriList.put(clientId,frontchannelLogoutUrl);
    }

    public String getFrontchannelLogoutURL(String clientId){
        return logoutUriList.get(clientId);
    }

    public void removeFrontChannelLogoutURL(String clientId){
        logoutUriList.remove(clientId);
    }

}
