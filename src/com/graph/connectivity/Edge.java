package com.graph.connectivity;

/**
 * Class that implements the edge structure
 */
public class Edge {
    private int src;
    private int dest;
    private int weight;

    /**
     * Constructor that sets source and destination nodes
     * Used for unweighted graphs
     */
    public Edge(int from, int to) {
        // Setting default weight for unweighted graph as 1
        this(from, to, 1);
    }

    /**
     * Constructor that sets source, destination and weight of the edge
     * Used for weighted graphs
     */
    public Edge(int from, int to, int weight) {
        this.src = from;
        this.dest = to;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
    }

}
