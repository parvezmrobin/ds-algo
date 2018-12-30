package com.parvezmrobin.ds.contracts;

public interface GraphInterface {
    int getNumberOfNodes();

    void addPath(int from, int to, double cost);

    void removePath(int from, int to);

    int[] getChildren(int parent);

    double getCost(int from, int to);
}
