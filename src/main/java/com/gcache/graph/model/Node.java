package com.gcache.graph.model;

/**
 * Node object to be stored in JGrapht MultiGraph instance
 */
public class Node {

    private String identifier;
    private Object data;

    public Node(String identifier, Object data) {
        this.identifier = identifier;
        this.data = data;
    }

    /**
     *
     * @return String unique identifier that identifies a node within the context
     * of your application
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier Set the unique identifier for the node within the context
     * of your application
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @return Object Get the data stored in the node
     */
    public Object getData() {
        return data;
    }

    /**
     * Set the data to be stored in the node
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
