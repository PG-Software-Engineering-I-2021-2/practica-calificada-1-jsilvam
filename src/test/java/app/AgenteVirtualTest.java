package app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteVirtualTest {
    private static final Logger LOGGER = Logger.getLogger(AgenteVirtualTest.class.getName());

    @Test
    public void test(){
        var agenteVirtual = AgenteVirtual.getInstance();
        
        Autor autor = new Autor("Somerville","1-1-1956");
        agenteVirtual.registrarLibro(1, "Software Engineering", 2015, autor, 1);
        agenteVirtual.registrarLibro(2, "Software Engineering", 2018, autor, 1);
        agenteVirtual.registrarLibro(3, "Software Engineering", 2020, autor, 1);

        agenteVirtual.registrarOferta(3, "1-10-2021", "30-10-2021");

        agenteVirtual.registrarEstudiante(1, "jonathan.silva@utec.edu.pe", 985429495);

        Assert.assertTrue(agenteVirtual.verificarDisponibilidadLibro(1, 1));
        agenteVirtual.removerLibro(1, 1);

        agenteVirtual.registrarEstudiante(2, "jsilva@utec.edu.pe", 990464187);
        Assert.assertFalse(agenteVirtual.verificarDisponibilidadLibro(1, 1));
        //Assert.assertTrue(agenteVirtual.vincularEstudianteOferta(1, 1));


    }
    
}
