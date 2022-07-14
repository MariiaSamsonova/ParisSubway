package com;

public class DirectedEdge extends Edge<Integer> {
    private final Integer weight;
    public DirectedEdge(Integer v, Integer w, Integer weight) {
        super(v,w);
        this.weight = weight;
    }
    public Integer weight() {
        return weight;
    }
}
