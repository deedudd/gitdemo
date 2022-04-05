package maven.project;

import org.testng.annotations.Test;

public class tryCatch {
	@Test
	public void test1() {
		int i = 3;
		int j = 4;
		try {
			int k = 4 / 0;
			System.out.println(k);
		} catch (ArrayIndexOutOfBoundsException  e) {
			System.out.println("exception");
		}
		finally {
		System.out.println("still executed");
	}}
}
