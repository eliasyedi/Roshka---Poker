import java.util.ArrayList;
import java.util.HashMap;


public class Carta {
    static private HashMap<Integer , String> cartas = new HashMap<>(13);
    static private ArrayList<String> palos = new ArrayList<>(4);
    static private ArrayList<String> mazo = new ArrayList<>(52);
    static {
        for(int i = 2 ; i<=9 ; i++)
            cartas.put(i , String.valueOf(i));

        cartas.put(1 , "A");
        cartas.put(10, "T");
        cartas.put(11, "J");
        cartas.put(12, "Q");
        cartas.put(13, "K");
        cartas.put(14 , "A");

        palos.add("S");
        palos.add("D");
        palos.add("C");
        palos.add("H");

        for(String palo:palos)
            for(int i = 1 ; i<=14 ; i++)
                mazo.add(cartas.get(i) + palo);

    }
    private Integer valor;
    private String palo;
    public Carta(){

        do {
            this.palo = palos.get((int) (Math.random() * 4));
            this.valor = (int) (Math.random() * 14 + 1);

        }while(!mazo.contains(cartas.get(this.valor)+ this.palo));
        mazo.remove(cartas.get(this.valor)+this.palo);
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
            if( ((Carta) objeto).getValor() == this.valor && ((Carta) objeto).getPalo().equals(palo))
                return true;
        return false;
    }



    @Override
    public String toString(){
        return cartas.get(valor) + this.palo;
    }


}
