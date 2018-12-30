package com.parvezmrobin.ds.contracts;

public interface GraphInterface {

    public void addPath(int from, int to, Number cost);

    public void removePath(int from, int to);
    
    public Number[] getChildren(int parent);

    public Number getCost(int from, int to);
}
