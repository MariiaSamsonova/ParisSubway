package com;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraSP {

    private PriorityQueue<Node> priorityQueue;
    private Set<Integer> markedSet;
    private boolean[] marked;
    private int[] previous;
    private int[] distance;
    private int numberOfVertexes;
    private int rootVertex;


    boolean verifyNonNegative(WDGraph G){
        for (List<DirectedEdge> edges : G.getAdjacencyList()) {
            for (DirectedEdge edge : edges){
                if (edge.weight() < -1){
                    return false;
                }
            }
        }
        return true;
    }

    public void dijkstraWithPriorityQueue(WDGraph G, int s){
        markedSet = new HashSet<>();
        priorityQueue = new PriorityQueue<>();
        rootVertex = s;
        numberOfVertexes = G.getNumberOfVertexes();
        previous = new int[numberOfVertexes];
        distance = new int[numberOfVertexes];
        marked = new boolean[numberOfVertexes];
        for (int i = 0; i < numberOfVertexes; i++) {
            previous[i] = -1;
            distance[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }

        priorityQueue.add(new Node(rootVertex, 0));
        distance[rootVertex] = 0;

        while (markedSet.size() != numberOfVertexes) {
            if (priorityQueue.isEmpty())
            {
                return;
            }
            int v = priorityQueue.remove().node;

            if (marked[v]){
                continue;
            }
            marked[v] = true;
            markedSet.add(v);

            List<DirectedEdge> adjacentEdges = G.getAdjacencyList()[v];
            if (adjacentEdges == null) continue;

            for(DirectedEdge edge : adjacentEdges){

                if (!marked[v]) continue;

                int to = edge.to();
                int weight = edge.weight();

                if(distance[to] > ( distance[v] + weight)){
                    distance[to] = distance[v] + weight;
                    previous[to] = v;
                }

                priorityQueue.add(new Node(to, distance[to]));
            }
        }
    }
    public void dijkstraSP(WDGraph G, int s){
        rootVertex = s;
        numberOfVertexes = G.getNumberOfVertexes();
        marked = new boolean[numberOfVertexes];
        previous = new int[numberOfVertexes];
        distance = new int[numberOfVertexes];

        for (int i = 0; i < numberOfVertexes; i++) {
            marked[i] = false;
            previous[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[rootVertex] = 0;

        for(int i = 0; i < numberOfVertexes; i++){
            int vBest = 0;
            int min = Integer.MAX_VALUE;

            for (int v = 0 ; v < numberOfVertexes; v ++){
                if (distance[v] < min && !marked[v]){
                    vBest = v;
                    min = distance[v];
                }
            }

            int v = vBest;
            marked[v] = true;

            List<DirectedEdge> adjacentEdges = G.getAdjacencyList()[v];
            if (adjacentEdges == null) continue;

            for(DirectedEdge edge : adjacentEdges){

                if (!marked[v]) continue;

                int to = edge.to();
                int weight = edge.weight();

                if(distance[to] > ( distance[v] + weight)){
                    distance[to] = distance[v] + weight;
                    previous[to] = v;
                }
            }
        }
    }

    boolean hasPathTo(int v){
        return distance[v] != Integer.MAX_VALUE;
    }

    int distTo(int v){
        return distance[v];
    }

    void printSp(int v){
        if (!hasPathTo(v) || v == rootVertex){
            return;
            //System.out.print("Cant find path from ");
            //System.out.print(rootVertex);
            //System.out.print(" to ");
            //System.out.println(v);
        }

        System.out.print("The SP distance from ");
        System.out.print(rootVertex);
        System.out.print(" to ");
        System.out.print(v);
        System.out.print(" is ");
        System.out.print(distTo(v));
        System.out.print(", path: ");
        StringBuilder sb = new StringBuilder();
        sb.insert(0, v);
        sb.insert(0, "->");

        while (previous[v] != -1 && v != rootVertex){
            sb.insert(0, previous[v]);
            v = previous[v];
            if (v != rootVertex){
                sb.insert(0, " -> ");
            }
        }
        System.out.println(sb);
    }
}