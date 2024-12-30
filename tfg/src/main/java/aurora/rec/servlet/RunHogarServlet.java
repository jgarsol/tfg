package aurora.rec.servlet;

import aurora.rec.Main;
import aurora.rec.model.Hogar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Javier
 */
public class RunHogarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        //String pathInfo = req.getPathInfo(); 
        String jresponse = "{ \"status\": \"not ok\" }";
        //if (pathInfo != null && pathInfo.startsWith("/")) {
            //String idStr = pathInfo.substring(1); 
            //int id = Integer.parseInt(idStr); 
                for(Hogar h : Main.listaHogares)
                {
                    /**if (id == h.getId())
                    {
                        Main.engine.insertar(h);
                        
                        jresponse = "{ \"status\": \"ok\" }";
                    }*/
                    Main.engine.insertar(h);
                    //jresponse = "{ \"status\": \"ok\" }";
                    jresponse = "{ \"status\": \"ok\", \"message\": \"The object has been inserted: " + h.getId() + "\" }";
                }
                Main.engine.firerules();
        //}
        resp.getWriter().write(jresponse);        
    }
    
}
