package aurora.rec.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Hogar {
    
    private String nombre;
    private int edad;
    private String ciudadHogar;
    private int codigoPostal;
    private int numeroPersonasHogar;
    private String tipoCalefaccion;
    private double consumoElectricidadDiario;
    //private String modalidadTransporteTrabajo; //es esto redundante?
    private String modalidadTransporteDiario;
    private String message;
    private static List<Hogar> hogares = new ArrayList<>();
    
    public Hogar() {
        String[] nombres = {"Luis", "Juan", "Gonzalo", "Maria", "Ana"};
        String[] ciudades = {"Madrid", "Santander", "Valencia", "Sevilla", "Zaragoza"};
        String[] tiposCalefaccion = {"Gas", "Electrica", "CombustiblesFosiles", "Biomasa"};
        String[] transportes = {"Coche", "Taxi", "Bus", "Metro", "Bicicleta"};

        Random random = new Random();
        
        this.nombre = nombres[random.nextInt(nombres.length)];
        this.edad = 18 + random.nextInt(67);
        this.ciudadHogar = ciudades[random.nextInt(ciudades.length)];
        //this.codigoPostal = 10000 + random.nextInt(500);
        this.numeroPersonasHogar = 1 + random.nextInt(5);
        this.tipoCalefaccion = tiposCalefaccion[random.nextInt(tiposCalefaccion.length)];
        this.consumoElectricidadDiario = Math.round((8 + random.nextDouble() * 4.00) * 100.0) / 100.0; //IDAE para encontrar datos reales.
        this.modalidadTransporteDiario = transportes[random.nextInt(transportes.length)];

        hogares.add(this);
    }

    public Hogar(String nombre, int edad, String ciudadHogar, int codigoPostal, int numeroPersonasHogar, String tipoCalefaccion, double consumoElectricidadDiario, String modalidadTransporteDiario) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudadHogar = ciudadHogar;
        this.codigoPostal = codigoPostal;
        this.numeroPersonasHogar = numeroPersonasHogar;
        this.tipoCalefaccion = tipoCalefaccion;
        this.consumoElectricidadDiario = consumoElectricidadDiario;
        this.modalidadTransporteDiario = modalidadTransporteDiario;
    }

    public void generarCodigoPostal() {
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

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudadHogar() {
        return ciudadHogar;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public int getNumeroPersonasHogar() {
        return numeroPersonasHogar;
    }

    public String getTipoCalefaccion() {
        return tipoCalefaccion;
    }

    public double getConsumoElectricidadDiario() {
        return consumoElectricidadDiario;
    }

    public String getModalidadTransporteDiario() {
        return modalidadTransporteDiario;
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
