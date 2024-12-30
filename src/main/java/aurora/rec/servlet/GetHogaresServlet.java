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
        
        resp.getWriter().write("[");
        for (int i = 0; i < Main.listaHogares.size(); i++) {
            Hogar h = Main.listaHogares.get(i);
            resp.getWriter().write(h.toJSON());
            if (i < Main.listaHogares.size() - 1) {
            resp.getWriter().write(",");
            }
        }
        resp.getWriter().write("]");
    }

}