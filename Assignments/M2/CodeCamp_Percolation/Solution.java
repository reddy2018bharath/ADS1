import java.util.Scanner;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
public class Solution {
	public static void main(String[] args) {
		//Percolation pe = new Percolation(n);
		Scanner sc = new Scanner(System.in);
		int li = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[li][li];
		while (sc.hasNext()) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			arr[row][col] = 1;
			System.out.println(arr);
		}


	}
}