package com.parvezmrobin.ds;


import com.parvezmrobin.ds.contracts.GraphInterface;


public class Graph implements GraphInterface {

    private Number[][] graph;
    private int numberOfNodes;
    private boolean isBidirectional;

    public Graph(int numberOfNodes) {
        this(numberOfNodes, true);
    }

    public Graph(int numberOfNodes, boolean isBidirectional) {
        this.graph = new Number[numberOfNodes][numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                this.graph[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        this.numberOfNodes = numberOfNodes;
        this.isBidirectional = isBidirectional;
    }

    @Override
    public void addPath(int from, int to, Number cost) {
        this.graph[from][to] = cost;
        if (this.isBidirectional) {
            this.graph[to][from] = cost;
        }
    }

    public void addPath(int from, int to) {
        this.addPath(from, to, 1);
    }

    @Override
    public void removePath(int from, int to) {
        this.graph[from][to] = Double.POSITIVE_INFINITY;
        if (this.isBidirectional) {
            this.graph[to][from] = Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public Number[] getChildren(int parent) {
        int childCount = 0;
        for (int i = 0; i < this.numberOfNodes; i++) {
            if (this.graph[parent][i] instanceof Double && (double) this.graph[parent][i] != Double.POSITIVE_INFINITY) {
                childCount++;
            }
        }
        Number[] children = new Number[childCount];
        for (int i = 0, j = 0; j < childCount; i++) {
            if (this.graph[parent][i] instanceof Double && (double) this.graph[parent][i] != Double.POSITIVE_INFINITY) {
                children[j++] = i;
            }
        }

        return children;
    }

    @Override
    public Number getCost(int from, int to) {
        return this.graph[from][to];
    }
}
