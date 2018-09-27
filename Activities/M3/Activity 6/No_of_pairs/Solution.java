import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Solution {
	int[] arr;
	int n;
	Solution() {
		arr = new int[n];
	}
	/**
	 * { function_description }
	 *
	 * @param      array  The array
	 */
	public static void noOfPairs(int[] array) {
		int count = 1;
		int sum = 0;
		Arrays.sort(array);
		for(int i = 0 ; i< array.length-1; i++){
			if(i==array.length-2 &&  array[i] == array[i+1]){
				count++;
				sum += count*(count-1)/2;
				break;
			}
			if(array[i] == array[i+1]){
				count++;
				continue;
			}
			if(count>1 && array[i] != array[i+1]){
				sum += count*(count-1)/2;
				count=1;
			}
		}
		System.out.println(sum);
		
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		int[] arr = new int[inp];
		for (int i = 0; i < inp; i++) {
			arr[i] = sc.nextInt();
		}
		noOfPairs(arr);
	}
}