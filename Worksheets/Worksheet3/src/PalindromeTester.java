import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeTester{
final String trueMsg = " IS a palindrome";
final String falseMsg = " is NOT a palindrome";
private static Scanner in;

public PalindromeTester() {
// enter your code here
	String input;
	in = new Scanner(System.in);
	System.out.println("Please enter a word to determine if it is a palindrome");
	
	input = in.nextLine().toLowerCase();
	isAPalindrome(input);
	
	
}
public boolean isAPalindrome(String myString)
{
Stack s = new Stack();

LinkedList q = new LinkedList();
int stringLength = myString.length();
char [] stringChars = new char[stringLength];
boolean palindrome = false;

//copy characters of the string to the character array
myString.getChars(0,stringLength, stringChars, 0);

return palindrome;	
		
}

public static void main( String args[] )
{
PalindromeTester test = new PalindromeTester();


}
}
