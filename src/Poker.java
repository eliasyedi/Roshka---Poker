import java.util.ArrayList;


public class Poker {
    private ArrayList<Integer> tablaRecurrencia ;


    public Poker(){
        this.tablaRecurrencia = new ArrayList<>(14);
        for(int i = 0 ; i<14 ; i++)
            tablaRecurrencia.add(0);
    }

    public String mano(ArrayList<Carta> cartas){

        getTable(cartas);
        System.out.println("tabla: " + tablaRecurrencia);

        if(straight() && flush(cartas))
            return "ESCALERA COLOR";
        if(straight())
            return "ESCALERA";
        if(flush(cartas))
            return "COLOR";
        if(poker())
            return "POKER";
        if(full())
            return "FULL";
        if(doublePair())
            return "PAR DOBLE";
        if(triple())
            return "TRIO";
        if(pair())
            return "PAR";

        return "CARTA ALTA:  " + cartaAlta(cartas);
    }
    private Carta cartaAlta(ArrayList<Carta> cartas){
        int nroCarta = cartas.get(0).getValor().intValue();
        Carta carta = cartas.get(0);
        for(int i = 1 ; i<5 ; i++){
            if(nroCarta<cartas.get(i).getValor().intValue()){
                nroCarta = cartas.get(i).getValor().intValue();
                carta = cartas.get(i);
            }
        }

        return carta;
    }

    private boolean pair(){
        for(Integer a: tablaRecurrencia)
            if(a.intValue() ==2)
                return true;
        return false;
    }

    private boolean triple(){
        for(Integer a: tablaRecurrencia)
            if(a.intValue() == 3)
                return true;

        return false;
    }


    private boolean flush(ArrayList<Carta> cartas){
        String palo = cartas.get(0).getPalo();
        for(Carta c:cartas)
            if(!c.getPalo().equals(palo))
                return false;

        return true;
    }


    private boolean doublePair(){
        for(int i = 0 ; i<12 ; i++)
            if(tablaRecurrencia.get(i).intValue()==2)
                for(int j = i+1 ; j<13 ; j++)
                    if(tablaRecurrencia.get(j).intValue() == 2)
                        return true;

        return false;
    }




    private boolean straight(){
        int nroConsecutivo = 0;
        for(int i = 0 ; i<14 ; i++) {
            if (tablaRecurrencia.get(i).intValue() > 1)
                return false;
            if(tablaRecurrencia.get(i).intValue()== 1)
                nroConsecutivo++;
            else
                nroConsecutivo = 0;

            if(nroConsecutivo == 5)
                return true;
        }
        return false;
    }

    private boolean poker(){
        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia.intValue() == 4)
                return true;

        return false;
    }

    private boolean full(){

        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia.intValue() ==3)
                for(Integer recurrencia2 :tablaRecurrencia)
                    if(recurrencia2 == 2)
                        return true;

        return false;
    }



    private void getTable(ArrayList<Carta> cartas){
        for (int i = 0 ; i<14 ; i++)
            this.tablaRecurrencia.set(i , 0);

        int nro = 0 ;
        for(Carta c: cartas){
            nro = c.getValor().intValue();
            if( nro == 0){
                tablaRecurrencia.set(0 , tablaRecurrencia.get(0) + 1);
                tablaRecurrencia.set(13 , tablaRecurrencia.get(13) + 1);
            }else
                tablaRecurrencia.set(nro , tablaRecurrencia.get(nro) + 1);
        }

    }

}
