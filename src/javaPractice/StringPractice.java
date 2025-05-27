package javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class StringPractice {
	Scanner scn = new Scanner(System.in);

	String[] setStringArray() {
		System.out.println("Provide the size of the array needed");
		int sixeOfArray = scn.nextInt();
		String[] input = new String[sixeOfArray];
		for (int index = 0; index < input.length; index++) {
			System.out.println("Provide the " + (index + 1) + " value od String");
			input[index] = scn.next();
		}
		return input;
	}

//	@Test
	void freqOfChar() {
		String[] input = setStringArray();
		System.out.println("Provide the char of which freq you want");
		char ch = scn.next().charAt(0);

		for (int index = 0; index < input.length; index++) {
			String str = input[index]; // pilli
			int count = 0;
			for (int innerInd = 0; innerInd < str.length(); innerInd++) {
				if (str.charAt(innerInd) == ch) {
					count++;
				}
			}
			System.out.println("Freq of " + ch + " in String " + str + " is " + count);
		}
	}

//	@Test
	void freqOfEveryChar() {
		String[] input = setStringArray();

		for (int index = 0; index < input.length; index++) {
			String str = input[index]; // pilli

			for (int innerInd = 0; innerInd < str.length(); innerInd++) {
				char ch = str.charAt(innerInd);
				int count = 0;
				
				for (int innerInd2 = 0; innerInd2 < str.length(); innerInd2++) {
					if (ch == str.charAt(innerInd2))
						count++;
				}
				if (innerInd == str.indexOf(ch))
					System.out.println("Freq of " + ch + " in String " + str + " is " + count);

			}
		}
	}

	// @Test
	void freqOfEveryCharUsingSPlit() {
		System.out.println("Provide the String then:-");
		String line = scn.nextLine();// Hi Hello Hi Hello Hi;
		String[] arrOfStr = line.split(" ");

		for (int index = 0; index < arrOfStr.length; index++) {
			String str = arrOfStr[index];// Hi
			if (str.length() > 0) {
				
				for (int innerInd = 0; innerInd < str.length(); innerInd++) {
					char ch = str.charAt(innerInd);// H
					int count = 0;

					for (int innerInd2 = 0; innerInd2 < str.length(); innerInd2++) {
						if (ch == str.charAt(innerInd2))
							count++;
					}
					if (innerInd == str.indexOf(ch))
						System.out.println("Freq of {" + ch + "} in String {" + str + "} is " + count);
				}

			}
		}

	}

	@Test
	void reverseString() {
		String[] input = setStringArray();

		for (int index = 0; index < input.length; index++) {
			String fString = input[index]; // Kartikey
			String temp = new String();
			for (int innerInd = fString.length() - 1; innerInd >= 0; innerInd--) {
				temp += fString.charAt(innerInd);
			}
			System.out.println("Reverse Value of String Provided:- " + fString + " is -->" + temp);

		}

	}

}
