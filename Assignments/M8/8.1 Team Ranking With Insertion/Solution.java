import java.util.Scanner;
/**
 * Class for ranking.
 */
class Ranking {
    /**
     * { this is a variable for country }.
     */
    private String country;
    /**
     * { this is a variable for no of wins }.
     */
    private int wins;
    /**
     * { this is a variable for no of losses }.
     */
    private int losses;
    /**
     * { this is a variable for no of draws }.
     */
    private int draws;
    /**
     * Constructs the object.
     * time complexity is 1.
     * @param      c     { country name }.
     * @param      w     { no of wins }.
     * @param      l     { no of losses }.
     * @param      d     { no of draws }.
     */
    Ranking(final String c, final int w, final int l, final int d) {
        this.country = c;
        this.wins = w;
        this.losses = l;
        this.draws = d;
    }
    /**
     * Gets the country.
     * time complexity is 1.
     * @return     The country.
     */
    public String getCountry() {
        return this.country;
    }
    /**
     * Gets the wins.
     * time complexity is 1.
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the losses.
     * time complexity is 1.
     * @return     The losses.
     */
    public int getLosses() {
        return this.losses;

    }
    /**
     * Gets the draws.
     * time complexity is 1.
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * this is a function for comparing.
     * time complexity is 1.
     * @param      that  The that
     *
     * @return     { returns int value }.
     */
    public int compareTo(final Ranking that) {
        if (this.getWins() < that.getWins()) {
            return 1;
        } else if (this.getWins() > that.getWins()) {
            return -1;
        } else {
        if (this.getLosses() < that.getLosses()) {
            return -1;
        } else if (this.getLosses() > that.getLosses()) {
            return 1;
        } else {
            if (this.getDraws() < that.getDraws()) {
                return 1;
            } else if (this.getDraws() > that.getDraws()) {
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
                //j--;
                if (j >= 0) {
                    count = rank.compareTo(ranking[j]);
                }
            } ranking[j + 1] = rank;
        }
    }
    /**
     * Returns a string representation of the object.
     * time complexity is 1.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += ranking[i].getCountry() + ",";
        }
        return s.substring(0, s.length() - 1);
    }

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
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            r.add(new Ranking((tokens[0]),
                Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                 Integer.parseInt(tokens[2 + 1])));
        } r.sort();
        System.out.println(r);
    }
}
