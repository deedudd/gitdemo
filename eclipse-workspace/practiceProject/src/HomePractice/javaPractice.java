package HomePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class javaPractice {

	public static void palindrome() {
		int num = 545;
		int num2 = 17;
		System.out.println(Math.sqrt(num2));
		int temp = num;
		int r;
		int sum = 0;
		while (num > 0) {
			r = num % 10;
			sum = (sum * 10) + r;
			num = num / 10;
		}
		if (sum == temp)
			System.out.println("its a palindrome");
	}

	public static boolean IsPrime() {
		int num = 293;
		boolean retCode = true;
		if (num % 2 == 0) {
			retCode = false;
		} else {
			for (int i = 3; i <= Math.sqrt(num); i += 2) {
				if (num % i == 0) {
					retCode = false;
					break;
				}

			}
		}
		return retCode;

	}

	public static void main(String[] args) {
		// palindrome();
		// System.out.println(IsPrime());
		// summation();
		// stringPalindrome();
		// arrayBigNumber();
		// vowelCheck();
		//System.out.println(oddCheck());
		//pyramid();
		
	}
 public void arrayPrac() {
	 Integer[] a = {1,2,3,4};
	 List<Integer> lst = Arrays.asList(a);
	 List<Integer> lst1 = new ArrayList<>();
	 
 }


	private static void pyramid() {
		
		for(int i =1;i<5;i++) {
			
			for(int j=1;j<5-i;j++) {
				
				System.out.print(" ");
				
			}
			for(int k=1;k<=(i*2)-1;k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	public static void vowelCheck() {
		String str1 = "deepika";
		// str1.toCharArray();
		if (str1.matches(".*[a].*")) {
			System.out.println("a is present");
		}
		if (str1.contains("a") || str1.contains("e")) {
			System.out.println("vowel is present");
		}
	}

	public static void arrayBigNumber() {
		Integer[][] a = { { 1, 2 }, { 3, 1 }, { 5, 6 } };
		int big = a[0][0];
		int column = 0;
		;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[1].length; j++) {
				if (a[i][j] > big) {
					big = a[i][j];
					column = j;
				}
			}

		}
		System.out.println(big);
		int small = a[0][column];
		for (int k = 0; k < a.length; k++) {
			if (a[k][column] < small) {
				small = a[k][column];
			}
		}
		System.out.println(small);
	}

	public static void stringPalindrome() {
		StringBuffer str1 = new StringBuffer();
		str1.append("aniket");
		String str2 = "";
		for (int i = 0; i < str1.length(); i++) {
			str2 = str1.charAt(i) + str2;
		}
		StringBuffer str3 = new StringBuffer();
		str3.append("aniket");
		System.out.println(str3.reverse());
		if (str3.equals(str3))
			System.out.println("Working");
		System.out.println(str2);

	}

	public static void summation() {
		int num = 234;
		int r, temp;
		int sum = 0;

		while (num > 0) {
			r = num % 10;
			sum = sum + r;
			num = num / 10;

		}
		System.out.println(sum);

	}
}
