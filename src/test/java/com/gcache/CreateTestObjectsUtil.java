package com.gcache;

import com.gcache.graph.GraphInstance;
import com.gcache.graph.GraphUtil;
import com.gcache.graph.model.DataWeighedEdge;
import com.gcache.graph.model.Node;

public class CreateTestObjectsUtil {

    GraphUtil graphUtil = new GraphUtil();

    public GraphInstance createTestGraph() {
        Node rootNode = new Node("0", "root");
        Node childNode1 = new Node("1", "child1");
        Node childNode2 = new Node("2", "child2");
        Node childNode3 = new Node("3", "child3");
        Node childNode4 = new Node("4", "child4");
        Node childNode5 = new Node("5", "child5");
        Node childNode6 = new Node("6", "child6");

        graphUtil.addRelationship(rootNode, childNode1);
        graphUtil.addRelationship(rootNode, childNode2);
        graphUtil.addRelationship(childNode1, childNode3);
        graphUtil.addRelationship(childNode1, childNode4);
        graphUtil.addRelationship(childNode1, childNode5);
        graphUtil.addRelationship(childNode2, childNode6);

        return graphUtil.getCurrentGraphInstance();
    }


    public Node createTestNode() {
        return new Node("12345", "12345 string data");
    }

    public DataWeighedEdge createTestEdge() {
        GraphInstance sampleGraph = this.createTestGraph();
        return sampleGraph.getMultiGraph().edgeSet().stream().findAny().get();
    }

    public GraphUtil getThisInstance() {
        return this.graphUtil;
    }
}
