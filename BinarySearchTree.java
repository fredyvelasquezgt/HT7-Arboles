

//Fredy Velasquez
//201011
//Hoja 7 - Arboles
//16-04-2021

import java.util.Iterator;
import java.util.Comparator;
//Importo todo lo que voy a usar

//Recordar borrar el package !

// Esta clase fue provista y solo debia implementarse
public class BinarySearchTree<E extends Comparable<E>> {

    protected BinaryTree<E> root; //Creola raiz
	
	//Creo el arbol
    protected final BinaryTree<E> empty = new BinaryTree<E>();
	//Cuento con esto
    protected int cont;
	//Para ir ordenando	
    protected Comparator<E> ordering;

	//Constructor ojo
    public BinarySearchTree()
    {
        this(new NaturalComparator<E>());
    }

	//Verifico la raiz y el ordenamiento
    public BinarySearchTree(Comparator<E> alternateOrder)
    {
        root = empty;
        cont = 0;
        ordering = alternateOrder;
    }

 public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }


    public boolean isEmpty() //Metodo del arbol
    {
        return root == empty;
    }

    public void clear() //En la raiz meto mi arbol
    {
        root = new BinaryTree<E>();
        cont = 0;
    }

    public int size() //Metodo el arbol - dimensiones
    {
        return cont;
    }
	
	
	
	 protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.getLeft();
        while (!result.getRight().isEmpty()) {
            result = result.getRight();
        }
        return result;
    }

    protected BinaryTree<E> locate(BinaryTree<E> root, E value)
    {
        E rootValor = root.getValor();
        BinaryTree<E> child;

        // found at root: done
        if (rootValor.equals(value)) return root;
        // look left if less-than, right if greater-than
        if (ordering.compare(rootValor,value) < 0)
        {
            child = root.getRight();
        } else {
            child = root.getLeft();
        }
        // no child there: not in tree, return this node,
        // else keep searching
        if (child.isEmpty()) {
            return root;
        } else {
            return locate(child, value);
        }
    }

   
    public int hashCode(){
        return root.hashCode(); //algunos de los que vienen de la otra clase
    }
   
public E get(E value)
    {
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,value);
        if (value.equals(possibleLocation.getValor()))
            return possibleLocation.getValor();
        else
            return null;
    }



    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.getRight();
        while (!result.getLeft().isEmpty()) {
            result = result.getLeft();
        }
        return result;
    }

    public void add(E valor)
    {
        BinaryTree<E> newNode = new BinaryTree<E>(valor,empty,empty);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = locate(root,valor);
            E nodeValue = insertLocation.getValor();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (ordering.compare(nodeValue,valor) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.getLeft().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }
            }
        }
        cont++;
    }

    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.getValor());
    }

    

    protected BinaryTree<E> removeTop(BinaryTree<E> topNode)
    {
        // remove topmost BinaryTree from a binary search tree
        BinaryTree<E> left  = topNode.getLeft();
        BinaryTree<E> right = topNode.getRight();
        // disconnect top node
        topNode.setLeft(empty);
        topNode.setRight(empty);
        // Case a, no left BinaryTree
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right BinaryTree
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        BinaryTree<E> predecessor = left.getRight();
        if (predecessor.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        BinaryTree<E> parent = left;
        while (!predecessor.getRight().isEmpty())
        {
            parent = predecessor;
            predecessor = predecessor.getRight();
        }
        // Assert: predecessor is predecessor of root
        parent.setRight(predecessor.getLeft());
        predecessor.setLeft(left);
        predecessor.setRight(right);
        return predecessor;
    }

    public E remove(E value)
    {
        if (isEmpty()) return null;

        if (value.equals(root.getValor())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            cont--;
            E result = root.getValor();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = locate(root,value);

            if (value.equals(location.getValor())) {
                cont--;
                BinaryTree<E> parent = location.getParent();
                if (parent.getRight() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                return location.getValor();
            }
        }
        return null;
    }

    public void iterator()
    {
        root.inorderIterator(this.root);
    }

   

    public String treeString(){
        return root.treeString();
    }

   

}