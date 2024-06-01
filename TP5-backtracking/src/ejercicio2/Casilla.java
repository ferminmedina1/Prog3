package ejercicio2;
public class Casilla {
    private int valor_natural;
    private boolean norte;
    private boolean sur;
    private boolean este;
    private boolean oeste;

    public Casilla(int valor_natural, boolean norte, boolean sur, boolean este, boolean oeste) {
        this.valor_natural = valor_natural;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
    }

    public int getValorNatural() {
        return valor_natural;
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isEste() {
        return este;
    }

    public boolean isOeste() {
        return oeste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casilla casilla = (Casilla) o;
        return valor_natural == casilla.valor_natural && norte == casilla.norte && sur == casilla.sur && este == casilla.este && oeste == casilla.oeste;
    }

    @Override
    public String toString() {
        return "valor_natural= " + valor_natural;
    }
}
