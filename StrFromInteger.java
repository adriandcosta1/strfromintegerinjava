
import java.util.Scanner;


/**
 * @author      Adrian D'Costa 
 * @version     1.1                (current version number of program)
 * @since       1.0          (the version of the package this class was first added to)
 */

public class StrFromInteger {

	/* *
	 * a single digit is passed as an argument And a matching digit of String
	 * type is returned. 
	 * 
	 * @param digit a digit of the whole integer
	 * 
	 * @return      return a String representation of the digit
	 */
	public static String returnDigitString(int digit) {
		String res = "";

		String[] digits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i <= 9; i++) {
			if (digit == i) {
				res += digits[i];
				break;
			}
		}
		return res;

	}
	/* *
	 * Take the input number, if it is less than zero multipy it by -1.
	 * loop through the whole integer digit by digit
	 * use modulo operator get the remainder
	 * save it in remainder. then concatenate valStr
	 * returned from returnDigitString()
	 * method with previous String of Digits. Divide the result by 10. Again
	 * repeat the same process. this time the modulo and the
	 * number to be divided will be one digit less at each decremental
	 * iteration of the loop. Then print the String and if it is less than zero
	 * concatenate "-" at the beginning of total String representation of int
	 * otherwise just print the String representation of int.
	 * 
	 * @param length number of digits in the integer
	 * @param number the integer number itself
	 * @param isPosite is positive or not
	 */
	public static void printInt(int length, int number, boolean isPositive ) {
		int input = number;

		int remainder = 0;
		int result = (number < 0 ? -1 * number : number);
		--length;
		number = length;
		String strSeq = "";
		String valStr = "";

		for (int i = number; i >= 0; --i) {

			remainder = result % 10;

			valStr = returnDigitString(remainder);
			strSeq = valStr + strSeq;

			result = result / 10;
		}
		if (!isPositive) {
			strSeq = "-" + strSeq;
		}
		// Print the string version of the integer
		System.out.println("The String conversion of " + input + " is: " + strSeq);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scan the integer as int
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();

		// find the number of digits using logarithm
		// if input number is not equal to zero because
		// divide the input by 10 each number it will be
		// reduced by 1 digit and increment the length
		int input = number;
		int length = 0;
		if (number != 0) {
			int num = number;

			while (num != 0) {
				// num = num/10
				num /= 10;
				++length;

			}
		} else if (number == 0) {
			length = 1;
		}
		printInt(length, input, (input < 0 ? false : true));
	}

}
