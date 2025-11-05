package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Cazadores.Reporteria;
import ar.edu.unahur.obj2.Decoradores.ArtesMarcialesAvanzadas;
import ar.edu.unahur.obj2.Decoradores.Entrenable;
import ar.edu.unahur.obj2.Decoradores.EntrenamientoElite;
import ar.edu.unahur.obj2.Decoradores.ProteccionLegal;

public class CazadorTest {
    @Test
    void testCazar() {
        CazadorRural cr = new CazadorRural(80);
        CazadorSigiloso cr2 = new CazadorSigiloso(50);
        CazadorUrbano cr3 = new CazadorUrbano(100);
        Profugo p2 = new Profugo(3, 30 , false );
        Profugo p4 = new Profugo(3, 30 , false );
        Profugo p7 = new Profugo(3, 30 , false );
        Profugo p1 = new Profugo(55, 55 , true );
        Profugo p5 = new Profugo(55, 55 , true );
        Profugo p8 = new Profugo(55, 55 , true );
        Profugo p3 = new Profugo(90, 74 , false);
        Profugo p9 = new Profugo(90, 70 , false);
        Profugo p6 = new Profugo(90, 70 , false);
        List<Profugo> l1= new ArrayList<Profugo>();
        List<Profugo> l2= new ArrayList<Profugo>();
        List<Profugo> l3= new ArrayList<Profugo>();

        l1.add(p1);
        l1.add(p2);
        l1.add(p3);

        l2.add(p4);
        l2.add(p5);
        l2.add(p6);

        l3.add(p7);
        l3.add(p8);
        
        Zona z1 = new Zona("villa 31", l1);
        Zona z2 = new Zona("villa 31", l2);
        Zona z3 = new Zona("villa 31", l3);
        z3.agregarProfugo(p9);
        z3.removerProfugo(p9);
        z3.agregarProfugo(p9);
        List<ICazable> cazadores = new ArrayList<ICazable>();

        cazadores.add(cr);
        
        Reporteria r1 = new Reporteria(cazadores);
        r1.agregarCazador(cr2);
        r1.agregarCazador(cr3);
        
        cr.cazarZona(z1);
        cr2.cazarZona(z2);
        cr3.cazarZona(z3);

        assertTrue(r1.getCazadores().contains(cr));
        assertEquals(70,r1.profugoMasHabil().getNivelDeHabilidad());
        assertEquals(cr3,r1.elBountyHunter());
        assertTrue(r1.todosLosProfugosCapturados().contains(p9));
        assertEquals(102, cr2.getExperiencia());
        assertEquals(112,cr.getExperiencia());
        assertTrue(cr.getCapturados().contains(p1));
        assertTrue(cr2.getCapturados().contains(p4));
        assertTrue(cr3.getCapturados().contains(p7));

        assertFalse(cr3.getIntimidados().contains(p3));
        assertFalse(cr2.getIntimidados().contains(p3));
        assertTrue(cr.getIntimidados().contains(p3));
        
        assertEquals(159, cr3.getExperiencia());
        assertFalse(cr2.getCapturados().contains(p2));
        
        
    }
    @Test
    void test4(){
        Profugo p6 = new Profugo(90, 70 , false);
        Entrenable entre1 = new ArtesMarcialesAvanzadas(p6);
        assertEquals(100, entre1.getNivelDeHabilidad());
    }
    @Test
    void test5(){
        Profugo p6 = new Profugo(90, 70 , true);
        Entrenable entre1 = new EntrenamientoElite(p6);
        assertFalse( entre1.getEsNervioso());
        
    }
    @Test
    void test9(){
        Profugo p6 = new Profugo(30, 70 , true);
        Entrenable entre1 = new ProteccionLegal(p6);
        assertEquals(40,entre1.getNivelDeInocencia());
    }
    @Test
    void test19(){
        Profugo p6 = new Profugo(30, 70 , true);
        Entrenable entre1 = new ProteccionLegal(p6);
        assertEquals(40,entre1.getNivelDeInocencia());
        Entrenable entr2 = new ProteccionLegal(entre1);
        Entrenable entr3 = new ProteccionLegal(entre1);
    }
}
