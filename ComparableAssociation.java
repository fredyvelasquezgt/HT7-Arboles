
//Fredy Velasquez
//201011
//Hoja 7 Datos
//16-04-2021

//Implemento association
public class ComparableAssociation<K extends Comparable<K>,V>
        extends Association<K,V> //k v que lo pide la hoja
        implements Comparable<ComparableAssociation<K,V>> {

	//Metodo propio 
    public ComparableAssociation(K key)
    {
        this(key,null);
    }
	//Metodo propio - comparo
	public int compareTo(ComparableAssociation<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

	//Metodo propio - le doy formato
    public String toString()
    {
        return "<" + getKey() + "=" + getValor() + ">";
    }
	
	
	
	//Metodo propio - aqui comparo association
    public ComparableAssociation(K key, V value)
    {
        super(key,value);
    }


    
}