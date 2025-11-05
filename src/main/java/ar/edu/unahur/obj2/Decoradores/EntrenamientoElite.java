package ar.edu.unahur.obj2.Decoradores;

public class EntrenamientoElite extends Decorator{

    public EntrenamientoElite(Entrenable profugoBase) {
        super(profugoBase);
    }
    @Override
    public Boolean getEsNervioso() {
        return false;
    }
    
}
