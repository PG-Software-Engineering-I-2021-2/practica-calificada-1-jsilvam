package app;
import java.util.logging.Logger;

public class Oferta {
    private static Logger logger = Logger.getLogger(Oferta.class.getName());

    private final String fechaInicio;
    private final String fechaFin;

    public Oferta(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getfechaInicio() {
        return fechaInicio;
    }

    public String getfechaFin() {
        return fechaFin;
    }

    public Boolean enTemporada(String fechaActual) {
        //TODO: validar fechas 
        logger.info("La oferta si está en temporada..."); 
        return true;   
    }
}
