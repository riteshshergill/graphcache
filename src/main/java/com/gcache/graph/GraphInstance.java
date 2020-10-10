package com.gcache.graph;

import com.gcache.graph.model.DataWeighedEdge;
import com.gcache.graph.model.Node;
import org.jgrapht.graph.*;

/**
 * Utility class to create an instance of a JGraphT MultiGraph object.
 */
public class GraphInstance {

    private static Multigraph<Node, DataWeighedEdge> multiGraph = new Multigraph<>(DataWeighedEdge.class);

    /**
     *
     * @return the Multigraph instance
     */
    public static Multigraph<Node, DataWeighedEdge> getMultiGraph() {
        return multiGraph;
    }

    /**
     * Set the provided Multigraph instance
     * @param multiGraph
     */
    public static void setMultiGraph(Multigraph<Node, DataWeighedEdge> multiGraph) {
        GraphInstance.multiGraph = multiGraph;
    }

}
