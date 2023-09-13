package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numInside = 0;
		int total = 0;
		double x = Math.random();
		double y = Math.random();
		System.out.println("Enter how many darts do you have: ");
		int darts = in.nextInt();
		for (int i = 0; i < darts; i++) {
			x = Math.random();
			y = Math.random();
			total++;
			if (((x*x) + (y*y))<1)
				numInside++;
		}
		System.out.println(4.0*numInside/total);
			

	}

}
