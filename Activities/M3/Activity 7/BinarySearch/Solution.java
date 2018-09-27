import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
class Solution {
	int[] arr;
	int size;
	Solution() {
		arr = new int[size];
    }
    public static boolean binarySearch(int[] array, int x) {
    	int m;
    	int high = (array.length);
    	int low = 0;
    	Arrays.sort(array);
    	m = (low + high) / 2;
        while (low <= high) {
        	if (array[m] < x) {
        		low = m + 1;
        	} else {
        		if (array[m] == x) {
        			return true;
        		}
        	}
        	if (array[m] > x) {
        		high = m - 1;
        	}
        	m = (low + high) / 2;
        }return false;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		int[] arr = new int[inp];
		int s = sc.nextInt();
		for (int i = 0; i < inp; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(binarySearch(arr, s));
    }
}