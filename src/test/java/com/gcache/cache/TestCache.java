package com.gcache.cache;

import com.gcache.CreateTestObjectsUtil;
import com.gcache.graph.GraphInstance;
import com.gcache.graph.GraphUtil;
import com.gcache.graph.model.DataWeighedEdge;
import com.gcache.graph.model.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class TestCache {

    CreateTestObjectsUtil getTestObjects;
    GraphInstance testInstance = null;
    Node testNode = null;
    DataWeighedEdge edge = null;

    GraphInstance graphInst = null;

    CacheUtil cacheUtil = new CacheUtil();

    @Before
    public void setUp() {
        getTestObjects = new CreateTestObjectsUtil();
        testInstance = getTestObjects.createTestGraph();
        testNode = getTestObjects.createTestNode();
        edge = getTestObjects.createTestEdge();
        cacheUtil.initCacheDefault(100L, null, null);
    }

    @Test
    public void testCachingOfGraph() {
        String graphKey = UUID.randomUUID().toString();
        cacheUtil.cacheGraph(graphKey, testInstance);
        graphInst = (GraphInstance)cacheUtil.getObject(graphKey);
        assert(graphInst != null);
        assert(graphInst.getMultiGraph().edgeSet().size() == 12);
    }

    @Test
    public void testCachingOfNode() {
        String nodeKey = UUID.randomUUID().toString();
        cacheUtil.cacheNode(nodeKey, testNode);
        Node cachedNode = (Node) cacheUtil.getObject(nodeKey);
        assert(cachedNode != null);
        assert(cachedNode.getIdentifier().equals("12345"));
        assert(cachedNode.getData().equals("12345 string data"));

    }

    @Test
    public void testCachingOfEdge() {
        String edgeKey = UUID.randomUUID().toString();
        cacheUtil.cacheEdge(edgeKey, edge);
        DataWeighedEdge cachedEdge = (DataWeighedEdge) cacheUtil.getObject(edgeKey);
        Node sourceVertex = (Node)cachedEdge.getSourceVertex();
        Node targetVertex = (Node)cachedEdge.getTargetVertex();
        assert(cachedEdge != null);
        assert(sourceVertex != null);
        assert(sourceVertex.getIdentifier().equals("0"));
        assert(sourceVertex.getData().equals("root"));
        assert(targetVertex != null);
        assert(targetVertex.getIdentifier().equals("1"));
        assert(targetVertex.getData().equals("child1"));
        assert(cachedEdge.getRelationMetadata().toString().equals("0:1"));
    }
}
