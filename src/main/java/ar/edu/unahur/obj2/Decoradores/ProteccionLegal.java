package ar.edu.unahur.obj2.Decoradores;

public class ProteccionLegal extends Decorator {

    public ProteccionLegal(Entrenable profugoBase) {
        super(profugoBase);
    }

    @Override
    public Integer getNivelDeInocencia() {
        return Math.max(40, profugoBase.getNivelDeInocencia());
    }
}
