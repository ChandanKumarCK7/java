package Leetcode.LCmedium;



import java.util.*;







    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    class GraphDjikstras {
        public static List<Integer> shortestPath(int n, int m, int edges[][]) {

            // Create an adjacency list of pairs of the form node1 -> {node2, edge weight}
            // where the edge weight is the weight of the edge from node1 to node2.


            ArrayList<ArrayList<Pair>> a = new ArrayList<>();

            for(int i =0; i < n+1; i++){
                a.add(new ArrayList<>());
            }
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                a.get(u).add(new Pair(v, w));
                a.get(v).add(new Pair(u, w));
            }

            int[] dist = new int[n+1];
            int[] parent = new int[n+1];

            for(int i =1; i <= n; i++){
                dist[i] = Integer.MAX_VALUE;
                parent[i] = i;
            }

            PriorityQueue<Pair> p = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

            p.add(new Pair(0,1));

            dist[1] = 0;

            while(p.size() > 0){
//                System.out.println(p.size());
                Pair pair = p.poll();
                int distance = pair.first;
                int node = pair.second;



                for(Pair adjPair : a.get(node)){
                    int adjNode = adjPair.first;
                    int w = adjPair.second;
//                    System.out.println(node +" "+ adjNode +" "+ w+" dist "+dist[adjNode]);

                    if (w + distance < dist[adjNode]){
                        dist[adjNode] = w + distance;
                        parent[adjNode] = node;

                        p.add(new Pair(w + distance, adjNode));
//                        System.out.println(node +" "+ adjNode +" "+ w);
                    }
                }


            }

            int node = n;

            ArrayList<Integer> output = new ArrayList<>();
            while(parent[node] != node){
                output.add(node);
                node = parent[node];
            }

            output.add(1);
            Collections.reverse(output);


            return output;
        }

        public static void main(String[] args) {
            int V = 5, E = 6;

            int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

            GraphDjikstras obj = new GraphDjikstras();
            List < Integer > path = obj.shortestPath(V, E, edges);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }

    }






