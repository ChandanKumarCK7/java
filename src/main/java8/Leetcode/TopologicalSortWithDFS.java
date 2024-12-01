package Leetcode;



import java.util.*;


public class TopologicalSortWithDFS {

    static int p = 0;
    static int[] output;

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        topoSort(V, adj);
        for (int node : output) {
            System.out.print(node + " ");
        }
        System.out.println();
        for(int i : output){
            System.out.println(i);
        }
    }


    public static void topoSort(int v, ArrayList<ArrayList<Integer>> adjL){
        Stack<Integer> stack= new Stack<>();
        output = new int[v];
        int[] visited = new int[v];
        for(int i =0; i < v; i++){
            if (visited[i] == 0)
                dfs(i, adjL, stack, visited);
        }

        while(stack.size() > 0){
            output[p++] = stack.pop();
        }


    }

    public static void dfs(int n, ArrayList<ArrayList<Integer>> adjL, Stack<Integer> stack, int[] visited){
        visited[n] = 1;
        for(int i : adjL.get(n)){
            if (visited[i] == 0)
                dfs(i, adjL, stack, visited);
        }
        stack.push(n);
    }
}
