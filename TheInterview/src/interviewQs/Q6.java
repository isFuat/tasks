package interviewQs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Q6 25 mins completion time.
 * 
 * @author Fuat Arslan
 * 
 */
public class Q6 {

	/**
	 * This method finds the most repeated value for given array input and
	 * prints it.
	 * 
	 * @param arr
	 *            the array input parameter.
	 */
	private static void most_repeated(String[] arr) {

		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1) {

			System.out.println("Input Array :" + Arrays.toString(arr));

			System.out.println("The Most Repeated Value :" + arr[0]);

			System.out.println();

			return;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				int value = map.get(arr[i]);
				map.put(arr[i], value + 1);
			} else {
				map.put(arr[i], 1);
			}

		}

		int max = map.get(arr[0]);
		String key = "";

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();

			} else if (entry.getValue() == max) {

				key = "";
			}

		}
		System.out.println("Input Array :" + Arrays.toString(arr));
		if (key.equals("")) {
			System.out.println("There is no the most repeated value");
		} else {
			System.out.println("The Most Repeated Value :" + key);
		}
		System.out.println();

	}
}
