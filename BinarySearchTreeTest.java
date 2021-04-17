//Fredy Velasquez
//201011
//HOja 7 arboles

//Cuidaod con el package! 



import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {


 @Test
    public void contains() {
        BinarySearchTree bst = new BinarySearchTree();
        ComparableAssociation B1 = new ComparableAssociation("Juan",2);
        ComparableAssociation B2 = new ComparableAssociation("Pedro",1);

        bst.add(B1);
        bst.add(B2);
        assert(bst.contains(B2));
    }
	
	
    @Test
    public void add() {
        BinarySearchTree bst = new BinarySearchTree();
        ComparableAssociation A1 = new ComparableAssociation("Juan",2);
        ComparableAssociation A2 = new ComparableAssociation("Pedro",1);

        bst.add(A1);
        bst.add(A2);
        assert(bst.contains(A1));
    }

   
}