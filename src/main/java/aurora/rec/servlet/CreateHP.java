package aurora.rec.servlet;

import aurora.rec.Main;
import aurora.rec.model.Hogar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to create a new personalized Hogar instance.
 * This servlet handles the /api/chpersonalizado endpoint.
 * It expects parameters: nombre, edad, ciudadHogar, codigoPostal, numeroPersonasHogar, consumoElectricidadDiario.
 * Returns the created Hogar as a JSON response.
 * 
 * @autor Javier
 */
public class CreateHP extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String nombre = req.getParameter("nombre");
        int edad = Integer.parseInt(req.getParameter("edad"));
        String ciudadHogar = req.getParameter("ciudadHogar");
        int codigoPostal = Integer.parseInt(req.getParameter("codigoPostal"));
        int numeroPersonasHogar = Integer.parseInt(req.getParameter("numeroPersonasHogar"));
        double consumoElectricidadDiario = Double.parseDouble(req.getParameter("consumoElectricidadDiario"));

        Hogar hogar = new Hogar(nombre, edad, ciudadHogar, codigoPostal, numeroPersonasHogar, consumoElectricidadDiario);
        //Main.listaHogares.add(hogar);

        resp.getWriter().write(hogar.toJSON());
    }
}