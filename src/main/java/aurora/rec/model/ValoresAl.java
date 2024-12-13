/*package aurora.rec.model;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ValoresAl {
    
    private int edad;
    private String ciudadHogar;
    private int codigoPostal;
    private int numeroPersonasHogar;
    private String tipoCalefaccion;
    private double consumoElectricidadDiario;
    private String modalidadTransporteTrabajo; //es esto redundante?
    private String modalidadTransporteDiario;
    private static List<ValoresAl> hogares = new ArrayList<>();
    
    public void generarValoresAleatorios() {
        String[] ciudades = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza"};
        String[] tiposCalefaccion = {"Gas", "Eléctrica", "CombustiblesFósiles", "Biomasa"};
        String[] transportes = {"Coche", "Taxi", "Bus", "Metro", "Bicicleta"};
        
        Random random = new Random();
        
        this.edad = 18 + random.nextInt(85);
        this.ciudadHogar = ciudades[random.nextInt(ciudades.length)];
        this.codigoPostal = 10000 + random.nextInt(10500);
        this.numeroPersonasHogar = 1 + random.nextInt(20);
        this.tipoCalefaccion = tiposCalefaccion[random.nextInt(tiposCalefaccion.length)];
        this.consumoElectricidadDiario = 8 + (4 * random.nextDouble());
        this.modalidadTransporteDiario = transportes[random.nextInt(transportes.length)];

        hogares.add(this);
    }
    
    public static List<ValoresAl> getHogares() {
        return hogares;
    }

    public String[] generarValoresAleatoriosS() {
        String[] ciudades = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza"};
        String[] tiposCalefaccion = {"Gas", "Eléctrica", "CombustiblesFósiles", "Biomasa"};
    
        Random random = new Random();
    
        this.ciudadHogar = ciudades[random.nextInt(ciudades.length)];
        this.codigoPostal = 10000 + random.nextInt(90000);
        this.tipoCalefaccion = tiposCalefaccion[random.nextInt(tiposCalefaccion.length)];
    
        return new String[] {this.ciudadHogar, String.valueOf(this.codigoPostal), this.tipoCalefaccion};
    }
    public int[] generarValoresAleatoriosI() {
        int[] edades;
        Random random = new Random();
    
        this.codigoPostal = 10000 + random.nextInt(90000);
        this.tipoCalefaccion = tiposCalefaccion[random.nextInt(tiposCalefaccion.length)];
    
        return new String[] {this.ciudadHogar, String.valueOf(this.codigoPostal), this.tipoCalefaccion};
    }
}*/
