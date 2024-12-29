package aurora.rec.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aurora.rec.ruleengine.Engine;

public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Engine.main(null);
        response.setContentType("text/html");
        response.getWriter().println("Servicio funcionando");
    }    
}