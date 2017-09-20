import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Benjamin Jack
 * 
 *
 */

public class Worksheet2Test {
	/**
	 * I wasn't sure how to test some of the methods so tested them by eye in the main method
	 * 
	 */
	@Test
	public void negateAllTest() {
		Tree o = new Tree(6, new Tree(), new Tree());
		String actual = Worksheet2.negateAll(o).toString();
		//System.out.println(actual);
		String expected = "-6";
		assertEquals(actual, expected );
	}
	
	@Test
	public void mirrorTest() {
		Tree o = new Tree(6, new Tree(), new Tree());
		String actual = Worksheet2.mirror(o).toString();
		//System.out.println(actual);
		String expected = "6";
		assertEquals(actual, expected );
	}
	
	@Test
	public void postorder() {
		Tree o = new Tree(6, new Tree(), new Tree());
		String actual = Worksheet2.postorder(o).toString();
		String expected = "[6]";
		assertEquals(actual, expected );
	}
	
	@Test
	public void allPositive1() {
		Tree y = new Tree (16, new Tree(5,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		boolean actual = Worksheet2.allPositive(y);
		//System.out.println(actual);
		boolean expected = true;
		assertEquals(actual, expected );
	}
	
	@Test
	public void allPositive() {
		Tree m = new Tree (16, new Tree(6,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		boolean actual = Worksheet2.allPositive(m);
		//System.out.println(actual);
		boolean expected = true;
		assertEquals(actual, expected );
	}
		
	@Test
	public void max() {
		Tree m = new Tree (16, new Tree(6,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		int actual = Worksheet2.max(m);
		//System.out.println(actual);
		int expected = 19;
		assertEquals(actual, expected );
	}
	
	@Test
	public void isHeightBalanced() {
		Tree m = new Tree (16, new Tree(6,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		boolean actual = Worksheet2.isHeightBalanced(m);
		//System.out.println(actual);
		boolean expected = true;
		assertEquals(actual, expected );
	}
	
	@Test
	public void isHeightBalanced1() {
		Tree y = new Tree (16, new Tree(5,  new Tree(4, new Tree(), new Tree()), new Tree()), new Tree(18, new Tree(17), new Tree(19)));
		boolean actual = Worksheet2.isHeightBalanced(y);
		//System.out.println(actual);
		boolean expected = true;
		assertEquals(actual, expected );
	}
	
}
