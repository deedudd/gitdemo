package maven.project;

public class JavaPrctice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// strRev();
		// palindromeCheck();
		// toLowercase();
		// swapTwoNumbersS();
		//primecheck();
		//countUppercase();
		//loop();
		//invertedLOop();
		arrays();
	}

	private static void arrays() {
	 
	int[][] matrix= {{1,2},{3,4},{5,6}};
	String[] str = {"qwer","asd","zxcv"};
	String s = "i am deepika";
	//System.out.println(matrix.length);
int max=matrix[0][0];
int maxcolumn=0;
	for (int i=0;i<matrix.length;i++) {
		
		for(int j=0;j<matrix[1].length;j++) {
			//System.out.print(matrix[i][j]);
			if(matrix[i][j]>max) {
				max=matrix[i][j];
				maxcolumn = j;
			}
			
		}
		
	}
	System.out.println(max);
	int small=matrix[0][maxcolumn];
	for(int i=0;i<matrix.length;i++) {
		if(matrix[i][maxcolumn]<small)
			small=matrix[i][maxcolumn];
	}
	System.out.println(small);
	}

	public static void invertedLOop() {
		
		for(int i =0;i<=4;i++) {
			int k=1;
			for(int j=0;j<=i;j++) {
				System.out.print(k+" ");
				k++;
			}
			System.out.println("\n");
		}
	}

	public static void loop() {
		int k=1;
		for(int i =0;i<=4;i++) {
			for(int j=1;j<=4-i;j++) {
				System.out.print(k+" ");
				k++;
			}
			System.out.println("\n");
		}
	}

	public static void primecheck() {
		int i = 1;
		int j = i / 2;
		boolean IsPrime = false;
		if (i == 0 || i == 1) {
			IsPrime = true;
		}

		for (int k = 2; k < j; k++) {
			if (i % k == 0) {

				// System.out.println("not prime");
				IsPrime = true;
				break;
			}

		}
		if (IsPrime) {
			System.out.println("not prime");
		} else
			System.out.println("prime");

	}

	public static void swapTwoNumbersS() {
		int x = 4;
		int y = 5;
		int temp;
		temp = x;
		x = y;
		y = temp;
		System.out.println(x + " " + y);

		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println(x + " " + y);

		String str = "HI AM Deepika";
		System.out.println((str.split(" ").length));
	}

	public static void toLowercase() {
		String str1 = "DEEPIKa";
		str1.toUpperCase();
		System.out.println(str1.toUpperCase());

	}

	public static void palindromeCheck() {

		StringBuffer str2 = new StringBuffer();
		String str1 = "tat";

		if (str1.contentEquals(str2.reverse()))
			System.out.println("it is a palidrome");

		else
			System.out.println("not a palindrome");

	}

	public static void strRev() {
		String str1 = "Deepika";
		String str2 = "";
		for (int i = 0; i < str1.length(); i++) {
			str2 = str1.charAt(i) + str2;
		}
		System.out.println(str2);
	}

	public static void countUppercase() {
		String str1 = "DeePIka";
		int upper = 0;
		int lower = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) >= 65 && str1.charAt(i) <= 92)
				upper++;
			else
				lower++;

		}
		System.out.print(lower);
	}

}