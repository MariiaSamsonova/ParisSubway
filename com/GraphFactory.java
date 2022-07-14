package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphFactory {
    public  static WDGraph createWDiGraph(String inputFilePath) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(inputFilePath));

        int numberOfVertexes = in.nextInt();
        int numberOfEdges = in.nextInt();

        ArrayList<String> stationNames = new ArrayList<>();

        for (int v= 0 ; v < numberOfVertexes ; v++ ){
            in.nextInt();
            stationNames.add(in.nextLine());
        }

        in.nextLine();

        WDGraph wdGraph = new WDGraph(numberOfVertexes);

        for (int e = 0 ; e < numberOfEdges ; e++ ){
            int v = in.nextInt();
            int w = in.nextInt();
            int weight = in.nextInt();
            if ( weight == -1){
                continue;
            }
            DirectedEdge edge = new DirectedEdge(v,w,weight);
            wdGraph.addEdge(edge);
        }
        in.close();

        return wdGraph;
    }
}



