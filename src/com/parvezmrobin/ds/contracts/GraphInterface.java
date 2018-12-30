package com.parvezmrobin.ds.contracts;

public interface GraphInterface {
    public int getNumberOfNodes();

    public void addPath(int from, int to, double cost);

    public void removePath(int from, int to);
    
    public int[] getChildren(int parent);

    public double getCost(int from, int to);
}
