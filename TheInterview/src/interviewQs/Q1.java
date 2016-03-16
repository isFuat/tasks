package interviewQs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q1.
 * 120 mins completion time.
 * @author Fuat Arslan
 * @version 4/4/2016
 * 
 */
public class Q1 {

	/**
	 * @param args
	 *            the args.
	 */
	public static void main(String[] args) {

		String[] in1_string = { "aaaasd", "a", "aab", "aaabcd", "ef",
				"cssssssd", "fdz", "kf", "zc", "lklklklklklklklkl", "l" };
		String[] in2_string = { "aaaasd", "a", "ab", "aab", "abc", "aaa",
				"aaabcd", "ef", "cssssssd", "fdz", "kf", "zc",
				"lklklklklklklklkl", "l" };
		String[] in3_string = { "aaaasd", "a", "aab", "aaabcd" };
		String[] in4_string = { "ef", "cssssssd", "fdz", "kf", "zc",
				"lklklklklklklklkl", "l" };
		List<String[]> ls = new ArrayList<String[]>();
		ls.add(in1_string);
		ls.add(in2_string);
		ls.add(in3_string);
		ls.add(in4_string);

		int in_num = 1;
		for (String[] arr : ls) {
			System.out
					.println("Input " + in_num + " : " + Arrays.toString(arr));
			System.out.println("Output " + in_num + " : "
					+ Arrays.toString(sortStringArrays(arr)) + "\n");
			in_num++;
		}

	}

	/**
	 * Sorts a bunch of words by the number of character “a”s within the word
	 * (decreasing order) if some words contain the same amount of character
	 * “a”s then you need to sort those words by their lengths.
	 * 
	 * @param in_string
	 *            the input string array.
	 * @return returns the output array.
	 */
	public static String[] sortStringArrays(String[] in_string) {
		if (in_string == null)
			throw new NullPointerException();
		if (in_string.length == 0)
			throw new IllegalArgumentException();

		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		String[] out_string = new String[in_string.length];
		for (int j = 0; j < in_string.length; j++) {
			int count = 0;
			for (int i = 0; i < in_string[j].length(); i++) {
				char ch = in_string[j].charAt(i);
				if (ch == 'a') {
					count++;
				}
			}

			if (count != 0) {
				map1.put(j, count);// Existence of any "a"s, put number of
									// occurrence to map1
			} else {
				count = in_string[j].length(); // otherwise, put the length to
												// map2
				map2.put(j, count);

			}

		}

		// Comparator is used to control decreasing order elements based on
		// number of a's in map1.
		Vcomparator comparator1 = new Vcomparator(map1);
		Map<Integer, Integer> tMap1 = new TreeMap<Integer, Integer>(comparator1);
		tMap1.putAll(map1);

		// Comparator is used to control decreasing order of elements based on
		// elements' length.
		Vcomparator comparator2 = new Vcomparator(map2);
		Map<Integer, Integer> tMap2 = new TreeMap<Integer, Integer>(comparator2);
		tMap2.putAll(map2);

		List<String> list = new ArrayList<String>();

		/**
		 * Add sorted elements that include a's to the list.
		 */
		for (Integer ii : tMap1.keySet()) {

			list.add(in_string[ii]);

		}

		/**
		 * Sort elements which have a's based on their length in case of some
		 * elements have same number of a's.
		 */
		for (int k = 0; k < list.size() - 1; k++) {
			int count = 0;
			for (int i = 0; i < list.get(k).length(); i++) {
				char ch = list.get(k).charAt(i);
				if (ch == 'a') {
					count++;
				}
			}

			for (int m = k + 1; m < list.size(); m++) {

				int count2 = 0;

				for (int i = 0; i < list.get(m).length(); i++) {
					char ch = list.get(m).charAt(i);
					if (ch == 'a') {
						count2++;
					}
				}
				// if number of a's are equal.
				if (count == count2) {

					int len1 = list.get(k).length();
					int len2 = list.get(m).length();
					String temp;
					// find the largest length of the string of same number of
					// a's and swap them if so.
					if (len2 > len1) {
						temp = list.get(k);
						list.set(k, list.get(m));
						list.set(m, temp);

					}
				}

			}

		}

		int index2 = 0;
		for (@SuppressWarnings("unused") String ls : list) {

			out_string[index2] = list.get(index2);

			index2++;

		}

		for (Integer ii : tMap2.keySet()) {
			// add string without a's to the out array.
			out_string[index2] = in_string[ii];
			index2++;

		}

		return out_string;
	}

}

class Vcomparator implements Comparator<Object> {

	Map<Integer, Integer> map;

	public Vcomparator(Map<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		if (map.get(obj1) == map.get(obj2)) {
			return 1;
		} else {
			return ((Integer) map.get(obj2)).compareTo((Integer) map.get(obj1));
		}
	}

}
