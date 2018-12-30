package com.parvezmrobin.algo;

import com.parvezmrobin.ds.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {

    private Graph graph, directedGraph;

    @BeforeEach
    void setUp() {
        boolean t = true, f = false;
        boolean[][] paths = {
                {f, f, t, f, t, f},
                {f, f, f, t, f, f},
                {f, t, f, f, t, f},
                {f, f, f, f, f, t},
                {f, f, f, f, f, t},
                {f, f, f, f, f, f}
        };

        graph = new Graph(6);
        directedGraph = new Graph(6, false);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (paths[i][j]) {
                    graph.addPath(i, j);
                    directedGraph.addPath(i, j);
                }
            }
        }
    }

    @Test
    void bfs() {
        double cost = GraphAlgorithms.bfs(this.graph, 1, 4);
        assertEquals(2, cost);
        cost = GraphAlgorithms.bfs(graph, 0, 5);
        assertEquals(2, cost);
        cost = GraphAlgorithms.bfs(directedGraph, 1, 4);
        assertEquals(Double.POSITIVE_INFINITY, cost);
        cost = GraphAlgorithms.bfs(directedGraph, 0, 5);
        assertEquals(2, cost);
    }

    @Test
    void dfs() {
        double cost = GraphAlgorithms.dfs(this.graph, 1, 4);
        assertEquals(3, cost);
        cost = GraphAlgorithms.dfs(graph, 0, 5);
        assertEquals(2, cost);
        cost = GraphAlgorithms.dfs(directedGraph, 1, 4);
        assertEquals(Double.POSITIVE_INFINITY, cost);
        cost = GraphAlgorithms.dfs(directedGraph, 0, 5);
        assertEquals(2, cost);

        directedGraph.removePath(4, 5);
        directedGraph.removePath(2, 1);
        directedGraph.addPath(4, 1);
        directedGraph.addPath(2, 5);
        cost = GraphAlgorithms.dfs(directedGraph, 0, 5);
        assertEquals(4, cost);
    }
}