//Fredy Velasquez
//201011
//Hoja 7 - Arboles
//16-04-2021


//Borrar el package

//Importo todo lo que voy a usar
import java.util.Map;
// clase de asociacion para guardar los datos y poder asociarlos y comprarlos (basada ern la viste en clase)
public class Association <K,V> implements MapEntry<K,V>{ //Implemento aqui

	//Valor
    protected V theValue; 

	//Llave
    protected K theKey; 
	
	
	//Le doy formato a lo que retorna
    public String toString()
    {
        return "<Asociasion: " + getKey() + "=" + getValor() + ">";
								//el get de abajo		//otro get de abajo
    }
	
	//Creo el constructor y le paso lo que cree arriba
    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }

	//Recibe la llave como parm
    public Association(K key)
    {
        this(key,null);
    }

	public V setValor(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
    


    public int hashCode()
    {
        return getKey().hashCode();
    }

	//get de mi valor
    public V getValor()
    {
        return theValue;
    }

	//get de mi llave
    public K getKey()
    {
        return theKey;
    }
	
	//Verificar
	public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey()); //Retorno la llave
    }

    


	
}