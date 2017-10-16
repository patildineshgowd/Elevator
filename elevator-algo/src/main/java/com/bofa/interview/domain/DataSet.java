package com.bofa.interview.domain;


import java.util.Queue;


public class DataSet {
    private int startingIndex;
    private Queue<Integer> routes;

    public DataSet(int startingIndex, Queue<Integer> routes){
        this.startingIndex = startingIndex;
        this.routes = routes;
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public void setStartingIndex(int startingIndex) {
        this.startingIndex = startingIndex;
    }

    public Queue<Integer> getRoutes() {
        return routes;
    }

    public void setRoutes(Queue<Integer> routes) {
        this.routes = routes;
    }
}
