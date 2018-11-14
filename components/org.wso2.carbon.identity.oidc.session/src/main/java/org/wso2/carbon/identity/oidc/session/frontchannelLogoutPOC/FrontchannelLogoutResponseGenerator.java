package org.wso2.carbon.identity.oidc.session.frontchannelLogoutPOC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FrontchannelLogoutResponseGenerator {


    public static void iframeGenerator(HttpServletRequest request, HttpServletResponse response, List<String> frontchannelLogoutURLs, String redirectURL, PrintWriter out)
                    throws IOException {

        if (redirectURL == null) {
            redirectURL = "https://www.google.com";
        }
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<p> "+frontchannelLogoutURL + "</p>");
//        out.println("</body>");
//        out.println("</html>");
        out.println("<html>");
        out.println("<head>\n" +
                "<meta charset=\"UTF-8\"> \n" +
                "<script>\n" +
                "var count = 0;\n" +
                "function onIFrameLoad() {\n" +
                "count++;\n" +
                "if(count === "+ frontchannelLogoutURLs.size() +"){\n" +
                "window.alert(\"Redirecting in 5s.\");\n" +
                "setTimeout(redirect,5000);\n" +
                "}\n" +
                "};\n" +
                "function redirect(){\n" +
                "window.location = \"" + redirectURL + "\";\n" +
                "};\n" +
                "</script>\n" +
                "</head>");
        out.println("<body>");
        if (!frontchannelLogoutURLs.isEmpty()) {
            for (String frontchannelLogoutURL : frontchannelLogoutURLs) {
                out.println("<iframe \n" +
                        "\twidth=\"400\"\n" +
                        "\theight=\"100\"\n" +
                        "\tstyle=\"border: 5px solid black;\"\t\n" +
                        "\tsrc=\"" + frontchannelLogoutURL + "\"" +
//                        "\tsrcdoc=\"" + frontchannelLogoutURL + "\"" +
                        "onload=\"onIFrameLoad()\">\n" +
                        "</iframe>");
            }
        } else {
            out.println("<script>\n" +
                    "\tredirect();\n" +
                    "\t</script>");
        }
        out.println("</body>");
        out.println("</html>");


    }

}
