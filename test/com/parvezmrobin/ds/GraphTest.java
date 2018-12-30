package com.parvezmrobin.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void testGraph(){
        boolean t = true, f = false;
        boolean[][] paths = {
                {f, f, t, f, t, f},
                {f, f, f, t, f, f},
                {f, t, f, f, t, f},
                {f, f, f, f, f, t},
                {f, f, f, f, f, t},
                {f, f, f, f, f, f}
        };

        Graph graph = new Graph(10);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (paths[i][j]) {
                    graph.addPath(i, j);
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (Number j: graph.getChildren(i)){
                int k = (int) j;
                assertTrue(paths[i][k] || paths[k][i]);

                assertEquals(1, graph.getCost(i, k));
            }
        }


    }
}