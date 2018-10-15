package org.wso2.carbon.identity.oidc.session.frontchannelLogoutPOC;

import org.apache.xpath.operations.String;

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

    public void storeFrontchannelLogoutUrl(String clientId, String frontchannelLogoutUrl){
        logoutUriList.put(clientId,frontchannelLogoutUrl);
    }

    public Map<String, String> getLogoutUriList(){
        return logoutUriList;
    }

    public void clearUriList(){
        logoutUriList.clear();
    }

}
