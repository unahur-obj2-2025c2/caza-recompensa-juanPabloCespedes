package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String nombre;
    private List<Profugo> profugos = new ArrayList<>();
    
    
    public void agregarProfugo(Profugo p){
        profugos.add(p);
    }
    public Zona(String nombre, List<Profugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public List<Profugo> getProfugos() {
        return profugos;
    }

    public void removerProfugo(Profugo p) {
        profugos.remove(p);
    }
    
}
