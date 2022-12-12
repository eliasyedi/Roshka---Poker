import java.util.ArrayList;


public class Poker {
    static private ArrayList<Integer> tablaRecurrencia = new ArrayList<>(14);
    static{
        for(int i = 0 ; i<14 ; i++)
            tablaRecurrencia.add(0);
    }


    static public String mano(ArrayList<Carta> cartas){

        getTable(cartas);


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

        return "CARTA ALTA";
    }


    static private boolean pair(){
        for(Integer a: tablaRecurrencia)
            if(a.intValue() ==2)
                return true;
        return false;
    }

    static private boolean triple(){
        for(Integer a: tablaRecurrencia)
            if(a.intValue() == 3)
                return true;

        return false;
    }


    static private boolean flush(ArrayList<Carta> cartas){
        for(Carta c:cartas)
            if(!c.getPalo().equals(cartas.get(0)))
                return false;

        return true;
    }


    static private boolean doublePair(){
        for(int i = 0 ; i<13 ; i++)
            if(tablaRecurrencia.get(i).intValue()==2)
                for(int j = i+1 ; j<14 ; j++)
                    if(tablaRecurrencia.get(j).intValue() == 2)
                        return true;

        return false;
    }




    static private void getTable(ArrayList<Carta> cartas){
        int nro = 0 ;
        for(Carta c: cartas){
            if( (nro = c.getValor().intValue()) == 1 || nro == 14){
                tablaRecurrencia.set(0 , tablaRecurrencia.get(0) + 1);
                tablaRecurrencia.set(13 , tablaRecurrencia.get(13) + 1);
            }
            else
                tablaRecurrencia.set(nro-1 , tablaRecurrencia.get(nro-1) + 1);
        }

    }

    static private boolean straight(){
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

    static private boolean poker(){
        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia.intValue() == 4)
                return true;

        return false;
    }

    static private boolean full(){

        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia.intValue() ==3)
                for(Integer recurrencia2 :tablaRecurrencia)
                    if(recurrencia2 == 2)
                        return true;

        return false;
    }



}
