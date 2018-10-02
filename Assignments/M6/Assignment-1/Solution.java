import java.util.Scanner;
import java.util.*;
class AddLargeNumbers {
	 //static LinkedList<Integer> num1 = new LinkedList<Integer>();
    
    public static LinkedList numberToDigits(String number) {
     LinkedList<Integer> num1 = new LinkedList<Integer>();
    	int l1= number.length();
    	for(int i = 0; i < l1; i++) {
    		num1.add(number.charAt(i) - '0');
    		
    	}
    	 //System.out.println(num1);
    	return num1;

    }

    public static String digitsToNumber(LinkedList list) {
    	int digits = 0;
    	String str = "";
    	int l1= list.size();
    	for (int i =0; i < l1; i++) {
    		//num1.add(list.get(i));
    	digits = (Integer)((list.get(i)));
    	str += Integer.toString(digits);
    	 }
    	 
    	 return str;
    

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	/*LinkedList<Integer> ans = new LinkedList<Integer>();
    	Stack s = new Stack(100);
    	int l1= list1.size();
    	for (int i =0; i < l1; i++) {
    		//num1.add(list.get(i));
    	int digits = (Integer)((list1.get(i)));
    	s.push(digits);
    }
    Stack s2 = new Stack(100);
    	int l2= list2.size();
    	for (int i =0; i < l2; i++) {
    		//num1.add(list.get(i));
    	int digits = (Integer)((list2.get(i)));
    	s.push(digits);
    }*/
    

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
/*class Stack {
  private int[] input;
  private int size;
  Stack(final int length) {
    input = new int[length / 2];
    size = -1;
  }
  public void push(final int c) {
    input[++size] = c;
  }
  public boolean isEmpty() {
    return size == -1;
  }

  public void pop() {
    int c = input[size];
    size--;
  }
}*/

