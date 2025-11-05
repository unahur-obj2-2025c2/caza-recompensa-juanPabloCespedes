package ar.edu.unahur.obj2.Decoradores;

public class ArtesMarcialesAvanzadas extends Decorator {

    public ArtesMarcialesAvanzadas(Entrenable profugoBase) {
        super(profugoBase);
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return Math.min(100, profugoBase.getNivelDeHabilidad() * 2);
    }
}
