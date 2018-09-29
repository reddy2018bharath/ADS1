import java.util.Scanner;
import java.util.LinkedList;
class AddLargeNumbers {
	LinkedList<Integer> num1 = new LinkedList<Integer>();
    
    public static LinkedList numberToDigits(String number) {
    	LinkedList<Integer> num1 = new LinkedList<Integer>();
    	int l1= number.length();
    	for(int i = 0; i < l1; i++) {
    		num1.add(number.charAt(i) - '0');
    		
    	}
    	System.out.println(num1);
    	return null;

    }

    public static String digitsToNumber(LinkedList list) {
    	return null;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	return null;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
