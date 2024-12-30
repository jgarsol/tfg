package aurora.rec.servlet;

import aurora.rec.Main;
import aurora.rec.model.Hogar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet serves the API method /api/user/id.
 * @returns the information relative to that user. 
 * @author Javier
 */
public class GetHogaresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");                
        
        for(Hogar h : Main.listaHogares)
        {
            resp.getWriter().write(h.toJSON());
        }
    }

}