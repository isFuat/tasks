package interviewQs;

/**
 * Q2 20 mins completion time. Write a recursive function which takes one
 * integer parameter. Test your function with "9" integer it should give the
 * following output
 * 
 * @author Fuat Arslan
 * 
 */
public class Q2 {

	/**
	 * A recursive function that prints square of numbers till given the square
	 * of numbers.
	 * 
	 * @param i
	 *            the input integer.
	 */
	public static void test_a_param(int i) {

		if (i <= 1 || i <= 2) {
			System.out.println(2);
			return;
		} else {

			for (int j = i; j > 1; j--) {

				if (Math.sqrt(j) % 1 != 0) {
					i--;
				} else {
					break;
				}

			}

			test_a_param((int) Math.pow(Math.sqrt(i) - 1, 2));
			System.out.println(i);
		}

	}

}
