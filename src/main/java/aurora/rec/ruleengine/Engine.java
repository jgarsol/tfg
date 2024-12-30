package aurora.rec.ruleengine;

//import aurora.rec.model.Person;
//import aurora.rec.model.House;
import aurora.rec.model.Hogar;
//import aurora.rec.model.ValoresAl;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * This is a sample file to launch a rule package from a rule source file.
 */
public class Engine {

   KieSession kieSession = null;
    
    //public static final void main(final String[] args) {
        //Engine engine = new Engine();
        //int contador = 0;
        
        /**
         * Generar 10 hogares aleatorios
         * y cargarlos en la sesion
         * para que las reglas puedan acceder a ellos
         */

        /*for (int i = 0; i < 10; i++) {
            Hogar hogar = new Hogar(contador);
            contador++;
            hogar.rellenarHogar(hogar);
            engine.insertar(hogar);
        }*/

        /**
         * Calcular los consumos diarios por codigo postal
         * y las medias de consumo por codigo postal
         */

        /*List<Hogar> listaHogares = Hogar.getHogares();
        Map<String, List<Double>> consumosPorCodigoPostal = new HashMap<>();
        Map<String, Double> mediasConsumo;

        for (Hogar hogar : listaHogares) {
            String codigoPostal = String.valueOf(hogar.getCodigoPostal());
            if (!consumosPorCodigoPostal.containsKey(codigoPostal)) {
                consumosPorCodigoPostal.put(codigoPostal, new ArrayList<>());
            }
            consumosPorCodigoPostal.get(codigoPostal).add(hogar.getConsumoElectricidadDiario());
        }

        mediasConsumo = calcularMedias(consumosPorCodigoPostal);*/

        /**
         * Imprimir los hogares generados (junto con sus atributos)
         * Imprimir los consumos diarios por codigo postal
         * y las medias de consumo por codigo postal
         */

        /*System.out.println("Hogares generados: " + listaHogares.size()+ "\n");
        for (Hogar hogar : listaHogares) {
            System.out.println("Nombre del propietario: " + hogar.getNombre());
            System.out.println("Edad del propietario: " + hogar.getEdad());
            System.out.println("Ciudad del Hogar: " + hogar.getCiudadHogar());
            System.out.println("Codigo Postal: " + hogar.getCodigoPostal());
            System.out.println("Numero de Personas en el Hogar: " + hogar.getNumeroPersonasHogar());
            //System.out.println("Tipo de Calefaccion: " + hogar.getTipoCalefaccion());
            System.out.println("Consumo de Electricidad Diario: " + hogar.getConsumoElectricidadDiario() + " kWh" + "\n");
            //System.out.println("Modalidad de Transporte Diario: " + hogar.getModalidadTransporteDiario());
        }

        for (Map.Entry<String, List<Double>> entry : consumosPorCodigoPostal.entrySet()) {
            String codigoPostal = entry.getKey();
            List<Double> consumosDiarios = entry.getValue();
            System.out.println("Codigo Postal: " + codigoPostal);
            System.out.println("Consumos diarios:");
            for (Double consumo : consumosDiarios) {
                System.out.println(consumo + " kWh");
            }
            System.out.println();
        }*/

        /*System.out.println("Medias de consumo por codigo postal:");
        for (Map.Entry<String, Double> entry : mediasConsumo.entrySet()) {
            System.out.println("Codigo Postal: " + entry.getKey() + ", Media de Consumo: " + entry.getValue() + " kWh");
        }*/

        /**
         * Ejecutar las reglas
         * y mostrar el mensaje generado para cada hogar
         */

        //engine.firerules();

        /*System.out.println();
        for (Hogar hogar : listaHogares) {
            System.out.println("Propietario: " + hogar.getNombre() + ", Mensaje: " + hogar.getMessage());
        }*/

    //}

    /*metodos extra*/

    /*metodo para calcular medias de consumo por codigo postal*/
    public static Map<String, Double> calcularMedias(Map<String, List<Double>> valores) {
        Map<String, Double> medias = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : valores.entrySet()) {
            List<Double> listaValores = entry.getValue();
            if (listaValores.size() > 1) {
                double suma = 0.0;
                for (double valor : listaValores) {
                    suma += valor;
                }
                double media = suma / listaValores.size();
                medias.put(entry.getKey(), media);
            } else if (listaValores.size() == 1) {
                medias.put(entry.getKey(), listaValores.get(0));
            }
        }
        return medias;
    }

    /**
     * Carga las reglas.
     * El archivo rules.drl está en src\main\resources
     */
    public void init()
    {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        Resource drlResource = kieServices.getResources().newClassPathResource("rules/rules.drl");
        kieFileSystem.write(drlResource);
        kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieRepository kieRepository = kieServices.getRepository();
        KieModule kieModule = kieRepository.getKieModule(kieRepository.getDefaultReleaseId());
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        kieSession = kieContainer.newKieSession();
    }
    
    /**
     * Inserta un objeto en la sesion, sin disparar las reglas todavia
     */
    public void insertar(Object obj)
    {
        if (kieSession==null)
            init();
        kieSession.insert(obj);
    }

    /**
     * Dispara todas las reglas y luego cierra sesion
     */
    public void firerules()
    {
        if (kieSession != null) {
            kieSession.fireAllRules();
            kieSession.dispose();
        } else {
            System.err.println("Failed to create KieSession");
        }
    }

}
