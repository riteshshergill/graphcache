package com.gcache.graph;

import com.gcache.CreateTestObjectsUtil;
import com.gcache.graph.model.DataWeighedEdge;
import com.gcache.graph.model.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class GraphUtilTest {

    GraphInstance graphInst = null;
    CreateTestObjectsUtil getTestObjects;
    GraphUtil graphUtil = null;

    @Before
    public void setUp() {
        getTestObjects = new CreateTestObjectsUtil();
        graphInst = getTestObjects.createTestGraph();
        graphUtil = new GraphUtil();
    }

    @Test
    public void testPrintGraph() {
        try {
            graphUtil.printGraph(GraphUtil.PrintOrder.DF, graphInst);
            graphUtil.printGraph(GraphUtil.PrintOrder.BF, graphInst);
            graphUtil.printGraph(GraphUtil.PrintOrder.EW, graphInst);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFindNode() {
        List<Node> nodes = getTestObjects.getThisInstance().findNodes("2");

        assert(nodes.size() > 0);
        assert(nodes.get(0).getData().equals("child2"));
    }

    @Test
    public void testFindEdge() {
        DataWeighedEdge edge = getTestObjects.getThisInstance().findEdge("0", "1");

        assert(edge != null);
        Node sourceVertex = (Node)edge.getSourceVertex();
        Node targetVertex = (Node)edge.getTargetVertex();
        assert(edge != null);
        assert(sourceVertex != null);
        assert(sourceVertex.getIdentifier().equals("0"));
        assert(sourceVertex.getData().equals("root"));
        assert(targetVertex != null);
        assert(targetVertex.getIdentifier().equals("1"));
        assert(targetVertex.getData().equals("child1"));
        assert(edge.getRelationMetadata().toString().equals("0:1"));
    }

    @Test
    public void testFindAllEdges() {
        List<DataWeighedEdge> edgeList = getTestObjects.getThisInstance().findAllEdges("0", "1");

        DataWeighedEdge edge = edgeList.get(0);

        assert(edge != null);
        Node sourceVertex = (Node)edge.getSourceVertex();
        Node targetVertex = (Node)edge.getTargetVertex();
        assert(edge != null);
        assert(sourceVertex != null);
        assert(sourceVertex.getIdentifier().equals("0"));
        assert(sourceVertex.getData().equals("root"));
        assert(targetVertex != null);
        assert(targetVertex.getIdentifier().equals("1"));
        assert(targetVertex.getData().equals("child1"));
        assert(edge.getRelationMetadata().toString().equals("0:1"));
    }
}
