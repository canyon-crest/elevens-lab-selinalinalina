package Activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester1 {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card1 one = new Card1("Ace", "Spades", 1);
		Card1 two = new Card1("Two", "Hearts", 2);
		Card1 three = new Card1("Three", "Clovers", 3);
		
		Card1 four = new Card1("King", "Spades", 13);
		Card1 five = new Card1("King", "Spades", 13);
		
		System.out.println(one.suit());
		System.out.println(two.rank());
		System.out.println(three.pointValue());
		
		System.out.println(four.matches(five));
		System.out.println(two.toString());
		
		
	}
}
