import java.util.Iterator;
//Recordar borrar el package !

//Fredy Velasquez
//201011
//Hoja 7 - Arboles
//16-04-2021



//Referencia tomada 
public class BinaryTree<E> { //Mi va
    
	
	protected BinaryTree<E> parent; //Parent

    protected BinaryTree<E> left, right; //Hijo de mis nodos
	
    protected  E valor; //Nodo
    
   
   
    //devuelve el sub arbol 
    public String toString() {
        if(isEmpty())return  "BinaryTree: empty";//Formato
        StringBuilder s = new StringBuilder();
        s.append("<BinaryTree ").append(getValor());//Formato
        if (!getLeft().isEmpty()) s.append(" ").append(getLeft());
        else s.append(" -");
        if (!getRight().isEmpty()) s.append(" ").append(getRight());
        else s.append(" -");
        s.append('>'); //Formato
        return s.toString();
    }

   
   	//Aca voy manejando el parent nodo
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent; //Verifico vacio
        }
    }
	
	//Lado derecho
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }
	
   
   
   //Constructor - este si lleva param
    public BinaryTree(E valor){
        this.valor = valor;
        right = left = new BinaryTree<E>(); //Voy bajando
        setLeft(left); //Iz
        setRight(right); //Der
    }
   
   
   //Contstrucutr
    public BinaryTree(){
        valor=null;
        parent = null;  //le doy valor a lo que cree arriba
        left = right = this;
    }


	//Voy iterando aqui
    public void inorderIterator(BinaryTree nood) {

        if (nood.isEmpty())
            return;

        /* first recur on left child */
        inorderIterator(nood.getLeft());

        /* then print the data of node */
        System.out.print(nood.getValor() + " ");

        /* now recur on right child */
        inorderIterator(nood.getRight());


    }

	//Constructor tocho - aqui si lleva de todo - le meto los gijos
    public BinaryTree(E valor, BinaryTree<E> left, BinaryTree<E> right){

        this.valor=valor;
        if(left== null){
			//Cuando el izq este vacio
			//El izq
			left=new BinaryTree<E>(); 
			
        }
        setLeft(left); //izq
        if(right== null){
			
			//Cuando el der este vacio
            right=new BinaryTree<E>(); //Creo el arbol
        }
        setRight(right); //set
    }


	//Aqui manejo el derecho - si, otro constructor
    public BinaryTree<E> getRight() {
        return right;
    }

    //Aqui manejo el nodo izq - si, otro constructor
    public BinaryTree<E> getLeft() {
        return left;
    }

   
	//Manejo del padre
    public BinaryTree<E> getParent() {
        return parent;
    }
	
	

    //Metodo del arbol
	//Verificar si hay algo
    public boolean isEmpty()
    {
        return valor == null; //Si esta vacio
    }

	//Lado izq
    public void setLeft(BinaryTree<E> newLeft)
    {
        if (isEmpty()) return; //con el empty
        if (left != null && left.getParent() == this) left.setParent(null);
        left = newLeft; //Update 
        left.setParent(this);
    }

  
	//Association
	//Devuelvo lo que tengo ahi
    public void setValor(E valor) {
        this.valor = valor;
    }
	
	//Voy retornando en donde estoy
    public int size()
    {
        if (isEmpty()) return 0;
        return getLeft().size() + getRight().size() + 1;
    }

    //Aqui puedo ver la raiz
    public BinaryTree<E> root()
    {
        if (getParent() == null) return this;
        else return getParent().root();
    }



    //Verifico si es nodo izq
    public boolean isLeftChild()
    {
        if (getParent() == null) return false;
        return this == getParent().getLeft();
    }


    //Verifico si es nodo derecho
    public boolean isRightChild()
    {
        if (getParent() == null) return false;
        return this == getParent().getRight();
    }

    
	//Imprime el valor del nodo
    public E getValor() {
        return valor;
    }

    

    //Manejo de hashcodes
	
    public int hashCode()
    {
        if(isEmpty()) return 0;
        int resultado = getLeft().hashCode() + getRight().hashCode();
        if(getValor() != null) resultado += getValor().hashCode();
        return resultado;
    }

    //Profundidad
	//Aqui determino la profundidad del nodo
    public int profundidad() {
        if (getParent() == null) return 0;
        return 1+ parent.profundidad(); //recursivo ojo
    }

    //Me duelve el lado del nodo
    private String getMano(){
        if (isRightChild()) return "R"; //Right
        if (isLeftChild()) return "L"; //Left
        return "Root"; //En donde estoy
    }

    //Raiz
	//Uso esto para manejar la raiz
    public String treeString(){
        StringBuilder s = new StringBuilder();
        s.append("\t|".repeat(Math.max(0, this.profundidad())));

        s.append("<").append(valor).append(" : ").append(getMano()).append(">\n");

        if (!left.isEmpty()) s.append(left.treeString());
        if (!right.isEmpty()) s.append(right.treeString());

        return s.toString();
    }

   


	
}