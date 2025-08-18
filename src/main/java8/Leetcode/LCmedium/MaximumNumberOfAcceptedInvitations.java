package Leetcode.LCmedium;





import java.util.*;

public class MaximumNumberOfAcceptedInvitations {
    public static int maxMatches(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int matches = 0;
        int[] girls = new int[n];
        Arrays.fill(girls, -1);


        for(int u=0; u<m; u++) {
            boolean[] visited = new boolean[n];
            if(Bipartite(grid, u, visited, girls))
                matches++;
        }

        return matches;
    }


    public static Boolean Bipartite(int[][] grid, int u, boolean[] visited, int[] girls) {


        for(int v=0; v<grid[u].length; v++) {
            if(grid[u][v]==0 || visited[v])
                continue;

            visited[v] = true;
            if(girls[v]<0 || Bipartite(grid, girls[v], visited, girls)) {
                girls[v] = u;
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{
            {1, 0},
            {1, 1}
        };
        int v = maxMatches(grid);

    }

}
