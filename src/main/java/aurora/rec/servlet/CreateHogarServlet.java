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
public class CreateHogarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Hogar hogar = new Hogar((int) (Math.random() * 900) + 100);
        hogar.rellenarHogar(hogar);
        resp.getWriter().write(hogar.toJSON());      
    }
    
}