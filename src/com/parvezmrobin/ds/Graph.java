package com.parvezmrobin.ds;


import com.parvezmrobin.ds.contracts.GraphInterface;


public class Graph implements GraphInterface {

    private double[][] graph;
    private int numberOfNodes;
    private boolean isBidirectional;

    public Graph(int numberOfNodes) {
        this(numberOfNodes, true);
    }

    public Graph(int numberOfNodes, boolean isBidirectional) {
        this.graph = new double[numberOfNodes][numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                this.graph[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        this.numberOfNodes = numberOfNodes;
        this.isBidirectional = isBidirectional;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    @Override
    public void addPath(int from, int to, double cost) {
        validateIndices(from, to);
        this.graph[from][to] = cost;
        if (this.isBidirectional) {
            this.graph[to][from] = cost;
        }
    }

    private void validateIndices(int from, int to) {
        validateFromIndex(from);
        validateToIndex(to);
    }

    private void validateToIndex(int to) {
        if (to >= this.numberOfNodes) {
            throw new IndexOutOfBoundsException("to " + to + " index out of bound.");
        }
    }

    private void validateFromIndex(int from) {
        if (from >= this.numberOfNodes) {
            throw new IndexOutOfBoundsException("from " + from + " index out of bound.");
        }
    }

    public void addPath(int from, int to) {
        this.validateIndices(from, to);
        this.addPath(from, to, 1);
    }

    @Override
    public void removePath(int from, int to) {
        this.validateIndices(from, to);
        this.graph[from][to] = Double.POSITIVE_INFINITY;
        if (this.isBidirectional) {
            this.graph[to][from] = Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public int[] getChildren(int parent) {
        this.validateFromIndex(parent);
        int childCount = 0;
        for (int i = 0; i < this.numberOfNodes; i++) {
            if (this.graph[parent][i] != Double.POSITIVE_INFINITY) {
                childCount++;
            }
        }
        int[] children = new int[childCount];
        for (int i = 0, j = 0; j < childCount; i++) {
            if (this.graph[parent][i] != Double.POSITIVE_INFINITY) {
                children[j++] = i;
            }
        }

        return children;
    }

    @Override
    public double getCost(int from, int to) {
        this.validateIndices(from, to);
        return this.graph[from][to];
    }
}
