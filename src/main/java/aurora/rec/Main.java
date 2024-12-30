package aurora.rec;

//import aurora.rec.model.House;
//import aurora.rec.model.Person;
import aurora.rec.model.Hogar;

import aurora.rec.ruleengine.Engine;
import aurora.rec.servlet.StatusServlet;
import aurora.rec.servlet.GetHogarServlet;
import aurora.rec.servlet.GetHogaresServlet;
import aurora.rec.servlet.RunHogarServlet;
import aurora.rec.servlet.CreateHogarServlet;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * This is a demo for the rule-based system
 * @author Javier
 */
public class Main {
    
    public static String HOME = ".";
    public static Engine engine = null;
    public static List<Hogar> listaHogares = new ArrayList<>();
    public static void main(String args[])
    {
        System.out.println("This is the demo recommender system for the AURORA system");
        engine = new Engine();
        int contador = 0;

        for (int i = 0; i < 30; i++) {
            Hogar hogar = new Hogar(contador);
            contador++;
            hogar.rellenarHogar(hogar);
            //engine.insertar(hogar);
        }
        listaHogares = Hogar.getHogares();

        //List<Hogar> listaHogares = Hogar.getHogares();

        runServer(); //http://localhost:8080/api/hogar/1
        
    } 

    public static void runServer()
    {
        Server server = new Server(8080); // Set the port to 8080
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new StatusServlet()), "/api/status");
        context.addServlet(new ServletHolder(new GetHogarServlet()), "/api/hogar/*");
        context.addServlet(new ServletHolder(new RunHogarServlet()), "/api/run");
        context.addServlet(new ServletHolder(new GetHogaresServlet()), "/api/hogares");
        context.addServlet(new ServletHolder(new CreateHogarServlet()), "/api/createhogar");
//        server.setHandler(context);
        
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("src/main/resources/static"); // Path to your static files
        resourceHandler.setWelcomeFiles(new String[]{"index.html"}); // Serve index.html as default
        
        HandlerList handlers = new HandlerList();
        handlers.addHandler(resourceHandler);
        handlers.addHandler(context);
        
        server.setHandler(handlers);        
        
        try{
            server.start();
            server.join(); 
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
}
