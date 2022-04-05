package HomePractice;

import java.util.ArrayList;

public class ArrayPractice {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] arr2 = {1,2,3,4,5};
		for(int i=0;i < arr.length;i++) {
//			System.out.println(arr[i]+arr2[i]+"   ");
		}
		String[] arrStr = {"deepika","Aniket","kishore"};
		for(int j =0;j<arrStr.length;j++ ) {
//			System.out.println(arrStr[j]);
		}
		
		for(int k=0;k<arr2.length;k++)
		{
			if(arr2[k]%2==0) {
//				System.out.println(arr2[k]);
				
			}
			
//			arraylist
		}
			ArrayList<String> a= new ArrayList<String>();
			a.add("Aniket is a good boy");
			String name= "deepika is smart";
			String[] splittedString = name.split("i");
			for(int l=0;l<splittedString.length;l++)
			System.out.println(splittedString[l].charAt(1));
			
	}

}
