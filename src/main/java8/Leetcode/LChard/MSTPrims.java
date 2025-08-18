package Leetcode.LChard;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MSTPrims {
    public static void main(String[] args){

        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        ArrayList<Tuple> adjacencyList = new ArrayList<>();

        for(int[] edge : edges){
            adjacencyList.add(new Tuple(edge[0], edge[1], edge[2]));
        }
        int n = edges.length;
        boolean[] visited = new boolean[n];

        int[] maxWeight = new int[n];
        Arrays.fill(maxWeight, Integer.MAX_VALUE);

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Tuple(edges[0][0], edges[0][1], edges[0][2]));

        maxWeight[0] = 0;

        while(pq.size() > 0){
            Tuple tuple = pq.poll();
            int start = tuple.start;
            int end = tuple.end;
            int weight = tuple.weight;

            visited[start] = true;

            for(Tuple adj : adjacencyList){
                if (adj.start >=0 && adj.start < n && adj.end >= 0 && adj.end < n && visited[adj.start] == false){
                    
                }
            }
        }


    }
}

class Tuple{
    int start;
    int end;
    int weight;

    public Tuple(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}