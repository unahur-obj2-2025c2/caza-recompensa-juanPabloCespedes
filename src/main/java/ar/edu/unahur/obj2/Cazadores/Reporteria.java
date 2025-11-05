package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.ICazable;
import ar.edu.unahur.obj2.Profugo;

public class Reporteria {
    private List<ICazable> cazadores = new ArrayList<>();
    
    public Reporteria(List<ICazable> cazadores) {
        this.cazadores = cazadores;
    }
    public void agregarCazador(ICazable cazador){
        this.cazadores.add(cazador);
    }
    public List<Profugo> todosLosProfugosCapturados(){
        return cazadores.stream()
            .flatMap(cazador -> cazador.getCapturados().stream())
            .toList();
    }
    public Profugo profugoMasHabil(){
        return this.todosLosProfugosCapturados().stream()
        .max(Comparator.comparingInt(Profugo::getNivelDeHabilidad))
        .orElse(null);
    }
    public ICazable elBountyHunter(){
        return cazadores.stream()
        .max(Comparator.comparingInt(c -> c.getCapturados().size()))
        .orElse(null);
    }
    public List<ICazable> getCazadores() {
        return cazadores;
    }
}
