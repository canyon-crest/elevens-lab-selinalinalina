package Activity3;
/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler3 {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		
		int[] one = {1,2,3,4};
		int[] two = {1,2,3,4};
		
		System.out.println(arePermutations(one, two));
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int mid = values.length/2;
		int length = values.length;
		int[] temp = new int[length];
		for(int i = 0; i<mid; i ++) {
			temp[2*i] = values[i];
			temp[2*i + 1] = values[i+mid];
		}
		
		for(int i =0; i<length; i++) {
			values[i] = temp[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int length = values.length;
		//int[] select = new int[length];
		//int index = length;
		for(int i = length -1 ; i>0; i--) {
			int random = (int)(Math.random()*(i+1));
			int temp = values[i];
			values[i] = values[random];
			values[random] = temp;
			
		}
	}
	
	public static String flip() {
		int random = (int)Math.random()*3;
		if(random == 0 || random == 1) {
			return "Heads";
		}
		else {
			return "Tails";
		}
	}
	
	public static boolean arePermutations(int[] one, int[] two) {
		if(one.length != two.length) {
			return false;
		}
		int temp = 0;
		
		for (int i = 0; i < one.length; i++){
            for (int j = i + 1; j < one.length; j++){
                if (one[i] >one[j]){
                    temp = one[i];
                    one[i] = one[j];
                    one[j] = temp;
                }
            }
        }
		
		for (int i = 0; i < two.length; i++){
            for (int j = i + 1; j < two.length; j++){
                if (two[i] >two[j]){
                    temp = two[i];
                    two[i] = two[j];
                    two[j] = temp;
                }
            }
        }
		int count = 0;
		for(int i =0; i<one.length; i++) {	
			if(one[i] == two[i]) {
				count++;
			}
		}
		
		if(count == one.length) {
			return true;
		}
		else {
			return false;
		}
	}
}
