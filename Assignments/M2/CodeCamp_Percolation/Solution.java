import java.util.Scanner;
 class Percolation {
 	private int n;
 	private int size;
 	private int first;
 	private int last;
    private WeightedQuickUnionUF wqf;
    private boolean[] connected;
    private int count;
    public Percolation(int N) {
    	this.n = N;
    	this.size = n * n;
    	this.first = size;
    	this.last = size + 1;
    	this.count = 0;
    	connected = new boolean[size];
    	wqf = new WeightedQuickUnionUF(size + 2);
    	for (int i = 0; i < n; i++) {
    		wqf.union(first, i);
    		wqf.union(last, size - i - 1);
    	}
    }
    public int indexOf(int i, int j) {
    	return n*(i-1) + (j-1);
    }
    public void LinkOpenSites(int i, int j) {
    	if (connected[j] && !wqf.connected(i, j)) {
    		wqf.union(i,j);
    	}
    }
    public int numberOfOpenSites() {
    	return count;
    }
    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
    	int index = indexOf(i, j);
    	connected[index] = true;
    	count++;
    	int bottom = index + n;
    	int top = index - n;
    	if (n == 1) {
   		wqf.union(first, index);
   		wqf.union(last, index);

   	}
    	if (bottom < size) {
    		LinkOpenSites(index, bottom);
    	}
    	if (top >= 0) {
    		LinkOpenSites(index, top);
    	}
    	if (j == 1) {
    		if (j !=n) {
    		LinkOpenSites(index, index + 1);
    	} return;
    	}
    	if (j == n) {
    		LinkOpenSites(index, index - 1);
    		return;
    	}
    	LinkOpenSites(index, index + 1);
    	LinkOpenSites(index, index - 1);
    }        
    public boolean isOpen(int i, int j)    // is site (row i, column j) open?
    {
        return connected[indexOf(i, j)];
    }
    /*public boolean isFull(int i, int j)    // is site (row i, column j) full?
    {
        if(isOpen(i,j))
        {
            for(int k = 0; k < gridSize; k++)
            {

               if(wqf.connected(to2D(i,j),k)) return true;
            }
        }
        return false;
    }*/
    public boolean percolates() {
    	return wqf.connected(first, last);
    }
     
}


// You can implement the above API to solve the problem
public class Solution {
	static int row;
	static int col;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Percolation pe = new Percolation(N);
		// int[][] arr = new int[li][li];
		while (sc.hasNext()) {
		String[] tokens = sc.nextLine().split(" ");
		pe.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			//pe.open(row, col);
			//arr[row][col] = 1;
			//System.out.println(arr);
		}
		System.out.println(pe.percolates() && pe.numberOfOpenSites() != 0);
		


	}
}