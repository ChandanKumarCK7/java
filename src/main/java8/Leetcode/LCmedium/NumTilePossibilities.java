package Leetcode.LCmedium;


import java.util.Arrays;

// LC - 1079
public class NumTilePossibilities {

    public static void main(String[] args){
        System.out.println('1' + 2);
        System.out.println(numTilePossibilities("BAA"));
    }

        public static int numTilePossibilities(String tiles) {
            // Track frequency of each uppercase letter (A-Z)
            int[] charCount = new int[26];
            for (char c : tiles.toCharArray()) {
                charCount[c - 'A']++;
            }

            // Find all possible sequences using character frequencies
            return findSequences(charCount);
        }

        private static int findSequences(int[] charCount) {
            int totalCount = 0;

            // Try using each available character
            for (int pos = 0; pos < 26; pos++) {
                if (charCount[pos] == 0) {
                    continue;
                }

                // Add current character and recurse
                totalCount++;
                charCount[pos]--;
                System.out.println(Arrays.toString(charCount));
                totalCount += findSequences(charCount);
                charCount[pos]++;
            }

            return totalCount;
        }

}
