package Leetcode;


import java.util.*;
class NumberOfClosedIslands {


    static private int[][] grid;

    public static void main(String[] args){
//        int[][] array= new int[][]
//                {
//                        {0, 1, 1, 1},
//                        {1, 1, 0, 1},
//                        {1, 1, 1, 1},
//                        {1, 1, 1, 1}
//                };

        int[][] array= new int[][]
                {
                        {1,1,1,1,1,1,1,0},
                        {1,0,0,0,0,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}
                };

        System.out.println(closedIsland(array));
    }

    public static int closedIsland(int[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid[0].length-1; j++) {
                if (grid[i][j] == 0 && dfs(i,j, grid)) {
                    islands++;
                    System.out.println(i+" "+ j);
                }

            }
//            System.out.println(Arrays.toString(grid[i]));
        }


        return islands;
    }

    private static boolean dfs(int i, int j, int[][] grid) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 1) return true;
        boolean isEdge = (i == 0 || i == grid.length-1) || (j == 0 || j == grid[0].length-1);
        grid[i][j] = 1;
        boolean top = dfs(i-1, j, grid);
        boolean bottom = dfs(i+1, j, grid);
        boolean left = dfs(i, j-1, grid);
        boolean right = dfs(i, j+1, grid );
        return top && bottom && left && right && !isEdge;
    }
}