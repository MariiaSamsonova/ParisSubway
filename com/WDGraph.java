package com;

import java.util.ArrayList;

public class WDGraph extends Graph<Integer, DirectedEdge> {
    public WDGraph(int numberOfVertexes) {
        super(numberOfVertexes);
    }

    public void addEdge(DirectedEdge edge){
        if (this.adjacencyList[edge.from()] == null){
            ArrayList<DirectedEdge> list = new ArrayList<DirectedEdge>();
            list.add(edge);
            this.adjacencyList[edge.from()] = list;
        }
        else{
            this.adjacencyList[edge.from()].add(edge);
        }
    }
}
