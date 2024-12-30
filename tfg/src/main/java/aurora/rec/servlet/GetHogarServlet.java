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
public class GetHogarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String pathInfo = req.getPathInfo(); 
        if (pathInfo != null && pathInfo.startsWith("/")) {
            String idStr = pathInfo.substring(1); // This gives the ID
            try {
                int id = Integer.parseInt(idStr); 
                
                for(Hogar h : Main.listaHogares)
                {
                    if (id == h.getId())
                    {
                        resp.getWriter().write(h.toJSON());
                    }
                }
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                String errorResponse = "{ \"error\": \"Invalid ID format\" }";
                resp.getWriter().write(errorResponse);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String errorResponse = "{ \"error\": \"ID is missing\" }";
            resp.getWriter().write(errorResponse);
        }
    }

}
