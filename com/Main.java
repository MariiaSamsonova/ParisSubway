package com;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "src/input.txt";
        WDGraph wdGraph = GraphFactory.createWDiGraph(inputFilePath);
        DijkstraSP dijkstraSP = new DijkstraSP();
        if (!dijkstraSP.verifyNonNegative(wdGraph)){
            System.out.println("Verify non negative failed!");
            return;
        }

        long startTime = System.nanoTime();
        dijkstraSP.dijkstraWithPriorityQueue(wdGraph, 0);
        long stopTime = System.nanoTime();
        long estimatedTime = stopTime - startTime;
        System.out.print("Improved dijkstra with priority queue elapsed in: ");

        System.out.println(estimatedTime);

        for (int v = 0 ; v< wdGraph.getNumberOfVertexes(); v++) {
            dijkstraSP.printSp(v);
        }

        startTime = System.nanoTime();
        dijkstraSP.dijkstraSP(wdGraph, 0);
        stopTime = System.nanoTime();
        estimatedTime = stopTime - startTime;
        System.out.print("Normal dijkstra elapsed in: ");
        System.out.println(estimatedTime);

        for (int v = 0 ; v< wdGraph.getNumberOfVertexes(); v++) {
            dijkstraSP.printSp(v);
        }
    }
}
