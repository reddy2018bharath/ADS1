import java.util.Scanner;
/**
 * Class for ranking.
 */
class Ranking {
    /**
     * { this is a variable for name }.
     */
    private String name;
    private String birthdate;
    /**
     * { this is a variable for no of sub1 }.
     */
    private int sub1;
    /**
     * { this is a variable for no of sub2 }.
     */
    private int sub2;
    /**
     * { this is a variable for no of sub3 }.
     */
    private int sub3;
    private int total;
    private String caste;
    /**
     * Constructs the object.
     * time complexity is 1.
     * @param      c     { name name }.
     * @param      w     { no of sub1 }.
     * @param      l     { no of sub2 }.
     * @param      d     { no of sub3 }.
     */
    Ranking(final String c, final String f, final int w, final int l, final int d, final int m, final String n) {
        this.name = c;
        this.birthdate = f;
        this.sub1 = w;
        this.sub2 = l;
        this.sub3 = d;
        this.total = m;
        this.caste = n;
    }
    /**
     * Gets the name.
     * time complexity is 1.
     * @return     The name.
     */
    public String getname() {
        return this.name;
    }
    /**
     * Gets the sub1.
     * time complexity is 1.
     * @return     The sub1.
     */
    public int getsub1() {
        return this.sub1;
    }
    /**
     * Gets the sub2.
     * time complexity is 1.
     * @return     The sub2.
     */
    public int getsub2() {
        return this.sub2;

    }
    /**
     * Gets the sub3.
     * time complexity is 1.
     * @return     The sub3.
     */
    public int getsub3() {
        return this.sub3;
    }
    public int gettotal() {
        return this.total;
    }
    public String getcaste() {
        return this.caste;
    }
    /**
     * this is a function for comparing.
     * time complexity is 1.
     * @param      that  The that
     *
     * @return     { returns int value }.
     */
    public int compareTo(final Ranking that) {
        if (this.gettotal() < that.gettotal()) {
            return 1;
        } else if (this.gettotal() > that.gettotal()) {
            return -1;
        } else {
        if (this.getsub3() < that.getsub3()) {
            return 1;
        } else if (this.getsub3() > that.getsub3()) {
            return -1;
        } else {
            if (this.getsub2() < that.getsub2()) {
                return 1;
            } else if (this.getsub2() > that.getsub2()) {
                return -1;
            }
        }
        }
        return 0;
    }
}

/**
 * Class for sorting.
 */
class Sorting {
    /**
     * variable 100.
     */
    private final int onehundred = 100;
    /**
     * { ranking array }.
     */
    private Ranking[] ranking;
    /**
     * { this is a size variable }.
     */
    private int size;
    /**
     * Constructs the object.
     * time complexity is 1.
     */
    Sorting() {
        ranking = new Ranking[onehundred];
        size = 0;
    }
    /**
     * { adds the ranking objects }.
     * time complexity is 1.
     * @param      r     { ranking object }.
     */
    public void add(final Ranking r) {
        ranking[size++] = r;
    }
    /**
     * { this is a function for sorting }.
     * time complexity is N^2.
     */
    public void sort() {
        for (int i = 1; i < size; i++) {
            Ranking rank = ranking[i];
            int j = i - 1;
            int count = rank.compareTo(ranking[j]);
            while (j >= 0 && count == -1) {
                ranking[j + 1] = ranking[j];
                j--;
                if (j >= 0) {
                    count = rank.compareTo(ranking[j]);
                }
            } ranking[j + 1] = rank;
        }
    }
    //public void print()
    /**
     * Returns a string representation of the object.
     * time complexity is 1.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += ranking[i].getname() + "," + ranking[i].gettotal() + "," + ranking[i].getcaste() + "\n";
            //return s;
        }
        //return s.substring(0, s.length() - 1);
        return s;
    }
    /*public String toString1() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += ranking[i].getname() + "," + ranking[i].gettotal() + "," + ranking[i].getcaste() + "\n";
            //return s;
        }
        return s.substring(0, s.length() - 1);
        //return s;
    }*/

}
/**
 * this is a solution class.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * { Client program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting r = new Sorting();
        //Ranking s = new Ranking();
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int d = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        int f = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            r.add(new Ranking((tokens[0]), tokens[1],
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                 Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                 tokens[6]));
        } r.sort();
        System.out.println(r);
        System.out.println("\n");

        //r.print();
        //System.out.println(r);
    }
}
