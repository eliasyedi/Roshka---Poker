import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;


public class Carta {
    static int cantidadCartas = 52 , cantidadJugadores;

    static private ArrayList<String> cartas = new ArrayList<>(13);
    static private ArrayList<String> palos = new ArrayList<>(4);
    static private HashMap<String, Boolean> mazo = new HashMap<>(52);
    static {
        cartas.add("A");
        cartas.add("2");
        cartas.add("3");
        cartas.add("4");
        cartas.add("5");
        cartas.add("6");
        cartas.add("7");
        cartas.add("8");
        cartas.add("9");
        cartas.add("T");
        cartas.add("J");
        cartas.add("Q");
        cartas.add("K");

        palos.add("S");
        palos.add("D");
        palos.add("C");
        palos.add("H");

        for(String palo:palos)
            for(int i = 0 ; i<13 ; i++)
                mazo.put(cartas.get(i) + palo, Boolean.TRUE);

    }
    private Integer valor;
    private String palo;
    public Carta(){
        if(cantidadCartas<5)
            shuffle();
        do {
            this.palo = palos.get((int) (Math.random() * 4));
            this.valor = (int) (Math.random() * 13 );
        }while(!(mazo.get(cartas.get(this.valor) + this.palo)).booleanValue());
        mazo.put(cartas.get(this.valor) + this.palo, Boolean.FALSE);
        cantidadCartas--;
    }



    private void shuffle(){
        for(String palo:palos)
            for(int i = 0 ; i<13 ; i++)
                mazo.put(cartas.get(i) + palo, Boolean.TRUE);
    }
    public Integer getValor(){
        return this.valor;
    }

    public String getPalo(){
        return this.palo;
    }


    @Override
    public boolean equals(Object objeto){
        if(objeto == this)
            return true;
        if(objeto instanceof Carta)
            return ((Carta) objeto).getValor() == this.valor && ((Carta) objeto).getPalo().equals(palo);
        return false;
    }



    @Override
    public String toString(){
        return cartas.get(this.valor) + this.palo;
    }


}
