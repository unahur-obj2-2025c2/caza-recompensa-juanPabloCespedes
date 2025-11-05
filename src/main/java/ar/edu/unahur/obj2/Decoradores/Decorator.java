package ar.edu.unahur.obj2.Decoradores;

public abstract class Decorator implements Entrenable{
    protected Entrenable profugoBase;

    public Decorator(Entrenable profugoBase) {
        this.profugoBase = profugoBase;
    }
    @Override
    public Integer getNivelDeInocencia() {
        return profugoBase.getNivelDeInocencia();
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return profugoBase.getNivelDeHabilidad();
    }

    @Override
    public Boolean getEsNervioso() {
        return profugoBase.getEsNervioso();
    }

}
