package aurora.rec.servlet;

import aurora.rec.model.Hogar;
import java.util.List;

/**
 * Manages the status of the application
 * @author victor
 */
public class Status {
    public static void main(String args[])
    {
        System.out.println(Status.getHTML());
    }
    
    /**
     * Returns a piece of HTML with the application status
     */
    public static String getHTML()
    {
        String javaVersion = System.getProperty("java.version");
        String str = "Service up and running<br>-------------------<br>\n";
        str+="Running Java version: " + javaVersion+"<br>\n";
        return str;
    }

    
}
