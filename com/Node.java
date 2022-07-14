package com;

public class Node implements Comparable<Node> {

    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost < o.cost)
            return -1;

        if (this.cost > o.cost)
            return 1;
        return 0;
    }
}
