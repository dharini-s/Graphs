package com.graph.connectivity;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implementation of a directed, weighted graph with BFS, DFS and
 * a method to get unreachable nodes from a given node in a graph
 */
public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Graph()  { }

    public Graph(List<Vertex> v, List<Edge> e) {
        this.vertices = v;
        this.edges = e;
    }

    /**
     * Breadth first search traversal from vertex v
     * @param v Traverse from vertex v
     */
    public void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<Vertex>();

        //Set all as unvisited
        for (int i = 0; i < getVertices().size(); i++) {
            getVertices().get(i).setState(State.UNVISITED);
        }        v.setState(State.VISITING);
        queue.add(v);
        Vertex vertex;

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            System.out.println(vertex.toString());
            for (int i = 0; i < vertex.getAdjList().size(); i++) {
                //System.out.println("AdjList size: " + i +" "+ vertex.getAdjList().size());
                Vertex neighbour = vertex.getAdjList().get(i);
                if (neighbour.getState().equals(State.UNVISITED)) {
                    neighbour.setState(State.VISITING);
                    queue.add(neighbour);
                }
            }

            vertex.setState(State.VISITED);
            vertex.toString();
        }
    }

    /**
     * Depth first search traversal from vertex v
     * @param v Traverse from vertex v
     */
    public void dfs(Vertex v)   {
        //Set all as unvisited
        for (int i = 0; i < getVertices().size(); i++) {
            getVertices().get(i).setState(State.UNVISITED);
        }
        dfsUtil(v);
    }

    // Utility method to carry out DFS
    private void dfsUtil(Vertex v)  {
        if(v == null)
            return;

        v.setState(State.VISITING);
        System.out.println(v.toString());
        for(int i = 0; i < v.adjList.size(); ++i)  {
            if(v.adjList.get(i).getState().equals(State.UNVISITED))
                dfsUtil(v.adjList.get(i));
        }
        v.setState(State.VISITED);
    }

    /**
     * Get a list of nodes that are not reachable from vertex v
     * @param v Starting point
     * @param all List of all vertices in the graph
     * @return List of all nodes not reachable from v
     */
    public List<Vertex> unconnected(Vertex v, List<Vertex> all) {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        List<Vertex> unconnNodes = new LinkedList<Vertex>();
        List<Vertex> connNodes = new LinkedList<Vertex>();

        //Set all as unvisited
        for (int i = 0; i < getVertices().size(); i++) {
            getVertices().get(i).setState(State.UNVISITED);
        }
        v.setState(State.VISITING);
        queue.add(v);
        Vertex vertex;

        while (!queue.isEmpty()) {
            vertex = queue.remove();

            if (!connNodes.contains(vertex))
                connNodes.add(vertex);
            for (int i = 0; i < vertex.getAdjList().size(); i++) {
                Vertex neighbour = vertex.getAdjList().get(i);
                if (neighbour.getState().equals(State.UNVISITED)) {
                    neighbour.setState(State.VISITING);
                    queue.add(neighbour);
                }
            }
            vertex.setState(State.VISITED);
        }

        for(Vertex vertex1: all)    {
            if(!connNodes.contains(vertex1))
                unconnNodes.add(vertex1);
        }

        return unconnNodes;
    }
}
