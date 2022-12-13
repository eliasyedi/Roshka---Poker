import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carta> cartasElias = new ArrayList<>(5);
        ArrayList<Carta> cartasOscar = new ArrayList<>(5);
        Carta carta = null;
        for(int i = 0 ; i<5 ; i++){

            cartasElias.add(new Carta());
            cartasOscar.add(new Carta());
        }
        Poker juego = new Poker();

        System.out.println("cartasElias:  " + cartasElias);
        System.out.println("cartasOscar:  " + cartasOscar);

        System.out.println(juego.mano(cartasElias));
        System.out.println(juego.mano(cartasOscar));

    }
}