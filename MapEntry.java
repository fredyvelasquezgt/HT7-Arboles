//cuidado con el package !

//Fredyy Velasquez
//201011
//Hoja 7 Arboles


//maneno association
//k v como lo pide la hoja
public interface MapEntry<K,V> { //Manejo 
        
		
		//metodo propio
		public boolean equals (Object o);

		//metodo propio
        public K getKey(); //dame llave


 

		//metodo propio
        public int hashCode(); //manejo
		
		//metodo propio
        public V getValor(); //dame valor


		//metodo propio
        public V setValor(V value); //seteo el valor


}