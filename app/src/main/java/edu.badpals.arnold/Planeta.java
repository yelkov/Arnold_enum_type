package edu.badpals.arnold;

import java.util.EnumSet;

public enum Planeta {

    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private Double masa = 0d;
    private Double radio = 0d;
    public static Double G = 6.67300E-11;

    private Planeta(Double masa, Double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    public Double getMasa() {
        return masa;
    }

    public Double getRadio() {
        return radio;
    }


    private Double gravedadSuperficie(){
        return G * this.masa / (this.radio*this.radio);
    }
    public double pesoSuperficie(double pesoHumano) {
        return masaHumano(pesoHumano) * this.gravedadSuperficie();
    }
    private Double masaHumano(double peso) {
        return peso / Planeta.EARTH.gravedadSuperficie();
    }

    public static EnumSet<Planeta> getPlanetasTerrestres() {
         EnumSet<Planeta> planetasTerrestres = EnumSet.range(Planeta.MERCURY,Planeta.MARS);
         return planetasTerrestres;
    }
    public static EnumSet<Planeta> getGigantesGaseosos() {
        EnumSet<Planeta> planetasGaseosos = EnumSet.range(Planeta.JUPITER,Planeta.URANUS);
        return planetasGaseosos;
    }
}

