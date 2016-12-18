/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.dbms_soap_maven;


//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
//import javax.xml.ws.WebServiceException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Neophron
 */
public class ServicePublisher {
    
    private static final boolean IS_WINDOWS = System.getProperty("os.name").contains("indow");
    
    public static String getPath() {
        URL url = ServicePublisher.class.getClassLoader().getResource("");
        String path = url.getPath();
        String str = "";
        try {
            str = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            //
        }

        return IS_WINDOWS ? str.substring(1) : str;
    }
    
    public static void main(String... args) {
        int port = 6112;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        String address = "http://0.0.0.0:" + port + "/";
        Endpoint.publish(address + "wss/DBM", new DBM());
        System.out.println("Looks like server is ready...");
    }
}
