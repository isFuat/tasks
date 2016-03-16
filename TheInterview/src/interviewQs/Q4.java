
package interviewQs;

/**
 * Q4
 * 10 mins completion time.
 * 
 * @author Fuat Arslan
 *
 */
public class Q4 {

	/**
	 * Swaps two variables with bitwise operations(without using any additional variable or buffer).
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = 15;
		int b = 35;
		
		System.out.println("Before Swap");
		System.out.println("a = "+a+"\nb = "+b);
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("\nAfter Swap");
		System.out.println("a = "+a+"\nb = "+b);
		
		
	}

}
