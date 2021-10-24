package app;

import java.util.Map;
import java.util.HashMap;

public class AgenteVirtual {
    private static AgenteVirtual instance;

    private Map<Integer, Libro> libros = new HashMap<>();
    private Map<Integer, Estudiante> estudiantes = new HashMap<>();
    private Map<Integer, Oferta> ofertas = new HashMap<>();

    private Map<Integer, HashMap<Integer, Boolean>> ofertasEstudiante = new HashMap<>();

    private AgenteVirtual(){

    }

    public static AgenteVirtual getInstance() {
        if(instance == null){
            instance = new AgenteVirtual();
        }
        return instance;
    }

    public void registrarLibro(Integer id, String nombre, Integer anho, Autor autor, Integer cantidad){
        libros.put(id, new Libro(nombre, anho,autor,cantidad));
    }
    
    public void registrarEstudiante(Integer id, String correo, Integer celular){
        estudiantes.put(id, new Estudiante(correo, celular));
    }

    public void registrarOferta(Integer id, String fechaInicio, String fechaFin){
        ofertas.put(id, new Oferta(fechaInicio, fechaFin));
    }

    public boolean ofertaEnTemporada(Integer idOferta){
        String fechaActual = "23-10-2021";
        return ofertas.get(idOferta).enTemporada(fechaActual);        
    }

    public boolean vincularEstudianteOferta(Integer idEstudiante, Integer idOferta){
        if(!ofertaEnTemporada(idOferta)) return false;
        ofertasEstudiante.computeIfAbsent(idOferta, k -> new HashMap<Integer, Boolean>());
        ofertasEstudiante.get(idOferta).put(idEstudiante, true);
        return true;
    }

    public boolean verificarDisponibilidadLibro(Integer idLibro, Integer cantidad){
        return libros.get(idLibro).verificarDisponibilidad(cantidad);
    }

    public void removerLibro(Integer idLibro, Integer cantidad){
        libros.get(idLibro).removerCantidad(cantidad);
    }

    public boolean agregarLibro(Integer idLibro, Integer idOferta, Integer cantidad){
        libros.get(idLibro).addCantidad(cantidad);
        var estudiantesOferta = ofertasEstudiante.get(idOferta);
        for (Map.Entry<Integer, Boolean> entry : estudiantesOferta.entrySet()) {
            if(Boolean.TRUE.equals(entry.getValue())) estudiantes.get(entry.getKey()).notificar();
        }
        return true;
    }


}
