/** @author 
 * 
 * This class contains the solution for Worksheet2
 */


public class Worksheet2 implements Worksheet2Interface {
    // Exercise 1
	
	public static void main(String args[]){
		Tree t = new Tree (16, new Tree(17,  new Tree(6, new Tree(27, new Tree(), new Tree()), new Tree()), new Tree(6)), new Tree(18, new Tree(17), new Tree(19)));
		
		Tree z = new Tree (6, new Tree(4, new Tree(2, new Tree(1, new Tree(), new Tree()), new Tree()), new Tree(5, new Tree(), new Tree())), new Tree(8, new Tree(7, new Tree(), new Tree()), new Tree(9, new Tree(), new Tree())));
		Tree o = new Tree(10, new Tree(9, new Tree(8, new Tree(7, new Tree(6, new Tree(5, new Tree(3), new Tree()), new Tree()), new Tree()), new Tree()), new Tree()), new Tree(17));
		Tree y = new Tree (16, new Tree(5,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		Tree m = new Tree (16, new Tree(6,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		System.out.println(t);
		System.out.println(isSearchTree2(t));
	//	System.out.println(z.toString());
		//System.out.println(negateAll(t).toString());
	//	System.out.println(mirror(t).toString());
		//System.out.println(postorder(t).toString());
		//System.out.println(allPositive(t));
		/*System.out.println(max(t));
		System.out.println(isSearchTree(t));
		printDescending(z);
		
		
		System.out.println(delete(18, m).toString());
		System.out.println(isHeightBalanced(y));
		System.out.println(insertHB(5, m).toString());
		System.out.println(deleteHB(4, m).toString());*/
		System.out.println(addUp(o));
		/*Tree t = new Tree (10, new Tree(6), new Tree(14, new Tree(13, new Tree(
				12), new Tree(), new Tree(17)));*/
		//System.out.println(max(o));
	}
	
	
	/**
	 * using a tree of integers t,  returns a new tree containing all the elements with their sign negated
	 * @param t
	 * @return
	 */
    public static Tree negateAll(Tree t) {
		if (t.isEmpty())             
			return new Tree();        
		else {               
			return new Tree(- t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
    }

    // Exercise 2
    /**
     * using a tree a, returns a tree that is the mirror image of a along the left-right axis
     * @param t
     * @return
     */
    public static Tree mirror(Tree t) {
    	if(t.isEmpty()){
    		return new Tree();
    	}
    	else {
    		return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft())); 
    	}
	}

    // Exercise 3
    
    
    /**
     * Given a tree a, produce and return a list containing the values in a by traversing the nodes in post order
     * post order is left right centre 
     * @param t
     * @return
     */
    public static List postorder(Tree t) {
    	 if(t.isEmpty())   
    		  return List.empty(); 
    	 else {
    		return ListOps.append(postorder(t.getLeft()), 
    					ListOps.addToEnd(postorder(t.getRight()), t.getValue()));
      	}
    }

    public static boolean isSearchTree2(Tree a) {
        if (a.isEmpty()) 
            return true;
        else 
            return isSearchTree(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper function for isSearchTree.
    // Returns a boolean to say whether `a' is a search tree whose
    // values are within the range between `lowerBound' and `upperBound'.

    private static boolean isSearchTree(Tree a, 
                                        int lowerBound, int upperBound)
    {
        if (a.isEmpty()) 
            return true;
        else {
            int newLower = Math.max(a.getValue(), lowerBound);
            int newUpper = Math.min(a.getValue(), upperBound);

            return 
                isSearchTree(a.getLeft() , lowerBound, newUpper) &&
                isSearchTree(a.getRight(), newLower  , upperBound) ;
        }
    }
    // Exercise 4
    /**
     * Given a tree of integers a, returns a boolean value indicating whether all the values in its nodes are positive
     * @param a
     * @return
     */
    public static boolean allPositive(Tree a) {
    	if(a.isEmpty()){
    		return true;
    	}
    	else if (a.value < 0){
    		return false;
    	}
    	else {
    		return a.value>=0 && allPositive(a.getRight()) && allPositive(a.getLeft()); 
    	}
    }

	// Exercise 5
    /**
     * Given a tree of integers a,  returns a boolean value indicating whether a is a binary search tree. 
     * @param a
     * @return
     */
    public static boolean isSearchTree(Tree a) {
    	if (a.isEmpty())
    		return true;
     	// false if left is > than node 
    	else if (a.getValue()<a.getLeft().getValue()) 
    		return false; 
	     
    	// false if right is < than node 
    	else if (a.getValue()>a.getRight().getValue())
    		return false;
    	
    	else{
    		return  isSearchTree(a.getRight()) && isSearchTree(a.getLeft()); 
    	}
    		
    		
    	}
    	
				
    	
    

    // Exercise 6
    /**
     * binary search tree of integers a, that prints the values stored in it in descending order
     * @param a
     */

    public static void printDescending(Tree a) {
    	if (a.isEmpty()){
    		System.out.println("empty");
    	}
    	/*else if (a.height ==1 ){
    		System.out.print(a.getValue() + " ");
    	}*/
    	else {
	   		printDescending(a.getRight());
	   		System.out.print(a.getValue() + " ");
	   		printDescending(a.getLeft());
	   		//System.out.print(a.getValue() + " ");
        }
    	
    }
    
    public static int addUp(Tree a){
    	if (a.isEmpty())
    		return 0;
    	else{
    		return a.getValue() + addUp(a.getRight()) + addUp(a.getLeft());
    	}
    }
    

		// Exercise 7
    /**
     * find the maximum value stored in the tree
     * @param a
     * @return
     */
   public static int max(Tree a) {
    	if (a.isEmpty()){
    		return 0;
    	}
		if (a.height == 1){
			return a.getValue();
		}
		else{
			int left = max(a.getLeft());
			int right = max(a.getRight());
			return  (left > right ? left : right);
		}			
	}
    
   


    // Exercise 8
    /**
     * delete the value x from a and return the resulting tree. The original tree a must not be altered. 
     * @param x
     * @param a
     * @return
     */
    public static Tree delete(int x, Tree a) {
		if(a.isEmpty()){
			 return new Tree();
		}
		else if (x == a.getValue()){
			if (a.getLeft().isEmpty()){
				return a.getRight();
			}
			else if (a.getRight().isEmpty()){
				return a.getLeft();
			}
			else{
			int y = max(a.getLeft());
			return new Tree(y, delete(y, a.getLeft()) ,  a.getRight());
			}
		}
		else {
			Tree b= new Tree(a.getValue(), delete(x, a.getLeft()), delete(x, a.getRight()));
			return b;
		}
		

    
    }
    /**
     * Given a tree of integers a, check to see if it is height-balanced, returning a boolean value.
     * @param a
     * @return
     */
		// Exercise 9
    public static boolean isHeightBalanced(Tree a) {
		if (a.isEmpty()){
			return true;
		}
		else if((a.getLeft().height - a.getRight().height) >= 2 ){
			return false;
		}
		else if((-a.getLeft().height + a.getRight().height) >= 2){
			return false;
		}
		else{
			
			return isHeightBalanced(a.right) && isHeightBalanced(a.left); 
		}
    }

		// Exercise 10
    /**
     *  insert method that maintain the height-balanced property of trees.
     * @param x
     * @param a
     * @return
     */
    public static Tree insert(int x, Tree a) {
    	/* 1.  Perform the normal BST insertion */
		if(a.isEmpty()){
			return new Tree(x);
		}
		else if (a.getLeft().isEmpty() && a.getValue()>x ){
			Tree c = new Tree(x);
			Tree b = new Tree(a.getValue(), c, a.getRight());
			return b;
		}
		else if (a.getRight().isEmpty() && a.getValue()<x){
			Tree c = new Tree(x);
			Tree b = new Tree(a.getValue(), a.getLeft(),  c);
			return b;
		}
		
		else{
			if (a.getValue()>x){
				Tree b= new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
				return b;
			}
			else{
				Tree b= new Tree(a.getValue(),  a.getLeft(), insertHB(x, a.getRight()));
				return b;
			}
		}
		
    }
    /**
     * insert method that maintain the height-balanced property of trees.
     * @param x
     * @param x
     * @param a
     * @return
     */
    public static Tree insertHB(int x, Tree a) {
    	/* 1.  Perform the normal BST insertion */
		if(a.isEmpty()){
			return new Tree(x);
		}
		else if (a.getLeft().isEmpty() && a.getValue()>x ){
			Tree c = new Tree(x);
			Tree b = new Tree(a.getValue(), c, a.getRight());
			return b;
		}
		else if (a.getRight().isEmpty() && a.getValue()<x){
			Tree c = new Tree(x);
			Tree b = new Tree(a.getValue(), a.getLeft(),  c);
			return b;
		}
		
		else{
			if (a.getValue()>x){
				Tree b= new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
				return rebalance(b);
			}
			else{
				Tree b= new Tree(a.getValue(),  a.getLeft(), insertHB(x, a.getRight()));
				return rebalance(b);
			}
		}
			
    }
    
    public static Tree rebalance(Tree a){
    	/* 2. Update height of this ancestor node */
    	if(isHeightBalanced(a) == true){
    		return a;
    	}
    	// right rotation
    	else if (a.getLeft().isEmpty() && a.getHeight() >= 2 /*.getRight().getHeight() - a.getLeft().getRight().getHeight() >= 2*/){
    		if (a.getRight().getLeft().isEmpty()){
    			return new Tree(a.getRight().getValue(), new Tree(a.getValue()), a.getRight().getRight());
    		}
    		else{
    			Tree d = new Tree(a.getValue(), new Tree(), new Tree(a.getRight().getLeft().getValue(), new Tree(), new Tree(a.getRight().getValue())/*a.getRight()*/));
    			
    			//return new Tree();
    			return new Tree(d.getRight().getValue(), new Tree(d.getValue()), d.getRight().getRight());
    		}
    	}
    	// left rotation
    	else if (a.getRight().isEmpty() && (a.getHeight() >= 2)/*a.getRight().getHeight()/*.getLeft().getHeight() /*- a.getRight().getLeft().getHeight() >= 2*/){
    		if(a.getLeft().getRight().isEmpty()){
    			return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), new Tree(a.getValue()));
    		}
    		else{
    			Tree d = new Tree(a.getValue(),new Tree(a.getLeft().getRight().getValue(), new Tree(a.getLeft().getValue()), new Tree()), new Tree());
    			return new Tree(d.getLeft().getValue(), d.getLeft().getLeft(), new Tree(d.getValue()));
    		//	return new Tree();
    		}
    	}
    	else{
    		//rotateRightThenLeft(a);
    		//if (a.getRight().getRight().height - a.getLeft().getRight().height >= 2){
    		if(a.getRight().isEmpty()){//a.getRight().getRight().getHeight() >= 2){
    			//return new Tree (a.getValue(), rebalance(a.getLeft()), a.getRight());
    			return new Tree (a.getValue(), rebalance(a.getLeft()) , a.getRight());
    		}    		
    		else{
    			
    			return new Tree (a.getValue(), a.getLeft(), rebalance(a.getRight()));
    		}
    		//rotateLeftThenRight(a);
    	}
    	/*if (a.getLeft().getLeft().height >= a.getRight().getLeft().height){
    		rotateLeft(a);
    		return a;
    	}
    	else{
    		rotateRightThenLeft(a);
    		return a;
    	}*/
    }
    /**
     * delete method that maintain the height-balanced property of trees.
     * @param x
     * @param x
     * @param a
     * @return
     */
    public static Tree deleteHB(int x, Tree a) {
    	if(a.isEmpty()){
			 return new Tree();
		}
		else if (x == a.getValue()){
			int y = max(a.getLeft());
			Tree b = new Tree(y, delete(y, a.getLeft()) ,  a.getRight());
			return rebalance(b);
		}
		else {
			Tree b= new Tree(a.getValue(), delete(x, a.getLeft()), delete(x, a.getRight()));
			return rebalance(b);
		}
		

    }
    
}
