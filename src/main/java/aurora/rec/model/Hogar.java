package aurora.rec.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import aurora.rec.utils.JSONUtils; // Add this import statement


public class Hogar {
    
    private int id;
    private String nombre;
    private int edad;
    private String ciudadHogar;
    private int codigoPostal;
    private int numeroPersonasHogar;
    //private String tipoCalefaccion;
    private double consumoElectricidadDiario;
    //private String modalidadTransporteTrabajo; //es esto redundante?
    //private String modalidadTransporteDiario;
    private String message;
    private static List<Hogar> hogares = new ArrayList<>();
    
    public Hogar(int contador) {        
        this.id = contador;
        this.nombre = "Vacio";
        this.edad = 99999;
        this.ciudadHogar = "Vacio";
        this.numeroPersonasHogar = 99999;
        this.consumoElectricidadDiario = 99999;
        hogares.add(this);
    }

    public Hogar(String nombre, int edad, String ciudadHogar, int codigoPostal, int numeroPersonasHogar, double consumoElectricidadDiario) {
        this.id = new Random().nextInt(9000) + 1000;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudadHogar = ciudadHogar;
        this.codigoPostal = codigoPostal;
        this.numeroPersonasHogar = numeroPersonasHogar;
        this.consumoElectricidadDiario = consumoElectricidadDiario;
        hogares.add(this);
    }

    public String toJSON()
    {
        return JSONUtils.toJSON(this);
    }

    public void rellenarHogar(Hogar hogar){
        if (hogar.getNombre().equals("Vacio")) {
            String[] nombres = {"Luis", "Juan", "Gonzalo", "Maria", "Ana"};
            String[] ciudades = {"Madrid", "Santander", "Valencia", "Sevilla", "Zaragoza"};
            Random random = new Random();
            
            hogar.setNombre(nombres[random.nextInt(nombres.length)]);
            hogar.setEdad(18 + random.nextInt(67));
            hogar.setCiudadHogar(ciudades[random.nextInt(ciudades.length)]);
            hogar.generarCodigoPostal();
            hogar.setNumeroPersonasHogar(1 + random.nextInt(5));
            hogar.calcularConsumo(); //IDAE para encontrar datos reales.
            hogar.generarCodigoPostal();
        }
        else{
            System.out.println("El hogar ya esta relleno");
        }
    }

    private void generarCodigoPostal() {
        switch (this.ciudadHogar) {
            case "Madrid":
                this.codigoPostal = 28000 + new Random().nextInt(4);
                break;
            case "Santander":
                this.codigoPostal = 39000 + new Random().nextInt(4);
                break;
            case "Valencia":
                this.codigoPostal = 46000 + new Random().nextInt(4);
                break;
            case "Sevilla":
                this.codigoPostal = 41000 + new Random().nextInt(4);
                break;
            case "Zaragoza":
                this.codigoPostal = 50000 + new Random().nextInt(4);
                break;
            default:
                this.codigoPostal = 1;
                break;
        }
    }

    public void calcularConsumo() {
        double baseConsumo = 7.0;
        double variacion = new Random().nextDouble() * 3.0; // Variación aleatoria entre 0 y 3
        this.consumoElectricidadDiario = baseConsumo + this.numeroPersonasHogar * (1 + new Random().nextDouble()) + variacion;
        this.consumoElectricidadDiario = Math.round(this.consumoElectricidadDiario * 100.0) / 100.0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudadHogar() {
        return ciudadHogar;
    }

    public void setCiudadHogar(String ciudadHogar) {
        this.ciudadHogar = ciudadHogar;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public int getNumeroPersonasHogar() {
        return numeroPersonasHogar;
    }

    public void setNumeroPersonasHogar(int numeroPersonasHogar) {
        this.numeroPersonasHogar = numeroPersonasHogar;
    }

    public double getConsumoElectricidadDiario() {
        return consumoElectricidadDiario;
    }

    public void setConsumoElectricidadDiario(double consumoElectricidadDiario) {
        this.consumoElectricidadDiario = consumoElectricidadDiario;
    }

    public static List<Hogar> getHogares() {
        return hogares;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
