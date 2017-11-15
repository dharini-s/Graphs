package com.graph.connectivity;

import java.util.List;

/**
 * Class that implements the vertex structure
 */
public class Vertex {
    private int id;
    private State state;
    // Adjacency list of the vertex
    List<Vertex> adjList;

    //Constructor with only value specified
    public Vertex(int value) {
        this(value, null);
    }

    //Overloaded constructor
    public Vertex(int value, List<Vertex> list) {
        this.id = value;
        this.state = State.UNVISITED;
        this.adjList = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Vertex> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Vertex> adjList) {
        this.adjList = adjList;
    }


    @Override
    public String toString() {
        return "Vertex [id=" + id + "]";
    }
}