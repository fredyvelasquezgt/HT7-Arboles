//cuidado con el package !

//Fredy Velasquez
//201011
//16-04-2021

import java.util.Comparator;
public class NaturalComparator<E extends Comparable<E>> implements Comparator<E> { //Manejo de todas estas


   

    public boolean equals(Object b){ //iguale
        return (b instanceof NaturalComparator);
    }
	
	
	//comparo mis ints aqui
	 public int compare(E a, E b){ 
        return a.compareTo(b);
    }
}