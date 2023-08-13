package assignment2;

public class implementation {
    public static void main(String[] args) {
        System.out.println("values for n=10 and k=3 is ");
        System.out.println(permutations(10, 3)); // Output: 720
    }

    static int permutations(int n, int k) {
        if (k > n) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else {
            return n * permutations(n - 1, k - 1);
        }
    }
}
