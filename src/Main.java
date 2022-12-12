import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>(5);
        for(int i = 0 ; i<5 ; i++)
            cartas.add(new Carta());
        System.out.println(cartas);
        System.out.println(Poker.mano(cartas));
    }
}