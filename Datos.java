//Cuidado con el package !


//no importo nada que no necesite

//Fredy Velasquez
//201011
//Hoja 7 Arboles


public class Datos { //La uso para darle formato a lo que se imprime
    String D1;
    String D2; //Creo mis variables para darles formato
    String D3;


	public String getD(int i) { //recupero los valores de mi D
        return switch (i) {
            case (1) -> D1; //caso 1
            case (2) -> D2; //caso 2
            default -> D3; //sino me voy a este
        };

    }

    public Datos(String[] data){
        D1 = data[0].toLowerCase(); //minus
        D2 = data[1].toLowerCase(); //minus
        D3 = data[2].toLowerCase(); //minus
    }

    

    @Override //Este ya lo traia de antes
    public String toString() {
        return "{" + // Aqui le doy un formato bonito
                 D1  +
                "," + D2  +
                "," + D3 +
                '}';
    }
}