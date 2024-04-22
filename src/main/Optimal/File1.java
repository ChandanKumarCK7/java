import java.util.Scanner;








public class File1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        int N = scanner.nextInt();

        int[] A = new int[N];

        // Input array elements
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int c = 0;

        // Nested loops to iterate through all combinations
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (A[i] > A[j] && A[l] > A[k]) {
                            c += 1;
                        }
                    }
                }
            }
        }

        // Output the result
        System.out.println(c);
    }
}
