package com.graph.connectivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to create a sample graph and execute the methods in the Graph class
 */
public class GraphRunner {
    public static void main(String args[]) {

        // Set 4 vertices
        List<Vertex> v = new LinkedList<Vertex>();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        //Setting adjList for each vertex
        List<Vertex> adjList = new LinkedList<Vertex>();
        adjList.add(v2);
        adjList.add(v3);
        v1.setAdjList(adjList);

        adjList = new LinkedList<Vertex>();
        adjList.add(v4);
        v2.setAdjList(adjList);

        adjList = new LinkedList<Vertex>();
        adjList.add(v2);
        v3.setAdjList(adjList);

        adjList = new LinkedList<Vertex>();
        adjList.add(v3);
        v4.setAdjList(adjList);

        v.add(v1);
        v.add(v2);
        v.add(v3);
        v.add(v4);

        // Create and add edges
        Edge e1 = new Edge(1, 2);
        List<Edge> e = new LinkedList<Edge>();
        e.add(e1);
        e1 = new Edge(1, 3);
        e.add(e1);
        e1 = new Edge(2, 4);
        e.add(e1);
        e1 = new Edge(4, 3);
        e.add(e1);
        e1 = new Edge(3, 2);
        e.add(e1);

        // Create a graph from the vertices and edges list
        Graph g = new Graph(v, e);

        // BFS from vertex 1
        g.bfs(v1);
        System.out.println("********************");

        // DFS from vertex 2
        g.dfs(v2);
        System.out.println("********************");

        // v has all the vertices
        List<Vertex> unconnectedNodes = g.unconnected(v2, v);
        System.out.println("No. of unconnected nodes from " + v2.getId() + ": " + unconnectedNodes.size());
        System.out.println(unconnectedNodes.toString());
    }
}
