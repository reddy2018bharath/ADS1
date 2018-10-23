import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree<Book, Integer> bst = new BinarySearchTree();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
				case "put":
				Book key = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				int value = Integer.parseInt(tokens[4]);
				bst.put(key, value);
				break;
				case "get":
				key = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				System.out.println(bst.get(key));
				break;
				case "max":
				Book b = bst.max();
				System.out.println(b.getName()+", "+b.getAuthor()+", "+b.getPrice());
				break;
				case "min":
			    b = bst.min();
				System.out.println(b.getName()+", "+b.getAuthor()+", "+b.getPrice());
				break;
				case "select":
				b = bst.select(Integer.parseInt(tokens[1]));
                System.out.println(b.getName()+", "+b.getAuthor()+", "+b.getPrice());
                break;
				case "floor":
			    b = bst.floor(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
			    if (b == null) {
			    	System.out.println("null");
			    	break;
			    }
			    System.out.println(b.getName()+", "+b.getAuthor()+", "+b.getPrice());
				break;
				case "ceiling":
				 b = bst.ceiling(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
			    if (b == null) {
			    	System.out.println("null");
			    	break;
			    }
			    System.out.println(b.getName()+", "+b.getAuthor()+", "+b.getPrice());
				break;
				case "deleteMax":
				bst.deleteMax();
				break;
				case "deleteMin":
				bst.deleteMin();
				break;
				case "delete":
				bst.delete(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
				break;
				default:
				break;
			}
		}
	}
}