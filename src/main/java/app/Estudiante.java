package app;
import java.util.logging.Logger;

public class Estudiante {
    private static Logger logger = Logger.getLogger(Estudiante.class.getName());

    private final String correo;
    private final Integer celular;

    public Estudiante(String correo, Integer celular) {
        this.correo = correo;
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public Integer getCelular() {
        return celular;
    }

    public void notificar(){
        logger.info("Se le notificó al usuario Estudiante por correo...");
    }
}
