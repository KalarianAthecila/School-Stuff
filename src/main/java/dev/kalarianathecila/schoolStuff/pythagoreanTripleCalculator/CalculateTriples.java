package dev.kalarianathecila.schoolStuff.pythagoreanTripleCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculateTriples {

    private int max;
    private List<int[]> triples;
    private int comparisons;

    public CalculateTriples(int max) {
        this.max = max;
        this.triples = new ArrayList<>();
        this.comparisons = 0;
    }

    public void calculate() {
        triples.clear();
        comparisons = 0;
        for (int a = 1; a <= max; a++) {
            for (int b = a; b <= max; b++) {
                int cSquared = a * a + b * b;
                int c = (int) Math.round(Math.sqrt(cSquared));
                comparisons++;
                if (c <= max && c * c == cSquared) {
                    triples.add(new int[]{a, b, c});
                }
            }
        }
    }

    public int comparisons() {
        return comparisons;
    }

    public void printTriples() {
        System.out.println("Pythagorean triples up to " + max + ":");
        for (int[] triple : triples) {
            System.out.println("(" + triple[0] + ", " + triple[1] + ", " + triple[2] + ")");
        }
        System.out.println("\nTotal count: " + triples.size());
        System.out.println("\nComparisons made: " + comparisons());
    }
}
