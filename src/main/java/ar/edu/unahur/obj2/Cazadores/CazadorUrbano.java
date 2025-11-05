package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.ICazable;
import ar.edu.unahur.obj2.Profugo;
import ar.edu.unahur.obj2.Zona;

public class CazadorUrbano implements ICazable {

    private Integer experiencia;
    private List<Profugo> capturados= new ArrayList<>();
    private List<Profugo> intimidados =new ArrayList<>();
    
    
    public List<Profugo> getCapturados() {
        return capturados;
    }

    public List<Profugo> getIntimidados() {
        return intimidados;
    }

    

    public Integer getExperiencia() {
        return experiencia;
    }

    
    public void capturarProfugo(Profugo profugo){
        capturados.add(profugo);
    }
    public Boolean tieneMayorExperienciaQue(Profugo profugo){
        return Boolean.valueOf(this.experiencia > profugo.getNivelDeInocencia());
    }

   
    public CazadorUrbano(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public void cazar(Profugo profugo) {
        if(this.tieneMayorExperienciaQue(profugo)&& !profugo.getEsNervioso()){
            this.capturarProfugo(profugo);
        }
        else{
            profugo.setEsNervioso(false);
            intimidados.add(profugo);
        }
    }
    public Integer profugoConMenorHabilidad(){
        return intimidados.stream().mapToInt(e->e.getNivelDeHabilidad()).min().orElse(0);
    }
    public void sumarExperiencia(){
        this.experiencia += this.profugoConMenorHabilidad()+ 2 * this.capturados.size();
    }

    @Override
    public void cazarZona(Zona zona) {
        zona.getProfugos().forEach(e->this.cazar(e));
        this.sumarExperiencia();
    }
}