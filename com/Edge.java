package com;

public class Edge <V> {
    private final V v;
    private final V w;

    public Edge(V v, V w) {
        this.v = v;
        this.w = w;
    }

    public V from(){
        return v;
    }

    public V to(){
        return w;
    }

}
