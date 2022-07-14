package com;

import java.util.List;

public class Graph <V extends Comparable<V> , E> {
    protected int numberOfVertexes;

    public Graph(int numberOfVertexes) {
        this.numberOfVertexes = numberOfVertexes;
        this.adjacencyList = new List[numberOfVertexes];
    }

    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    public List<E>[] getAdjacencyList() {
        return adjacencyList;
    }
    protected List<E>[] adjacencyList;
}
