package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.Decoradores.Entrenable;

public class Profugo implements Entrenable{
    private Integer nivelDeInocencia;
    private Integer nivelDeHabilidad;
    private Boolean esNervioso;
    
    public Integer getNivelDeInocencia() {
        return nivelDeInocencia;
    }
    
    public Integer getNivelDeHabilidad() {
        return nivelDeHabilidad;
    }
    public void setNivelDeHabilidad(Integer nivelDeHabilidad) {
        this.nivelDeHabilidad = nivelDeHabilidad;
    }
    public Boolean getEsNervioso() {
        return esNervioso;
    }
    public Profugo(Integer nivelDeInocencia, Integer nivelDeHabilidad, Boolean esNervioso) {
        this.nivelDeInocencia = nivelDeInocencia;
        this.nivelDeHabilidad = nivelDeHabilidad;
        this.esNervioso = esNervioso;
    }
    public void setEsNervioso(Boolean esNervioso) {
        this.esNervioso = esNervioso;
    }
    public void disminuirHabilidad(Integer cantidad){
        if(this.nivelDeHabilidad >= cantidad){
            this.nivelDeHabilidad = this.nivelDeHabilidad - cantidad;
        }
        else{
            this.setNivelDeHabilidad(0);
        }
    }
    
}
