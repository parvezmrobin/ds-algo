package com.parvezmrobin.algo;

import com.parvezmrobin.ds.Graph;
import com.parvezmrobin.ds.Queue;
import com.parvezmrobin.ds.Stack;
import org.jetbrains.annotations.NotNull;

public class GraphAlgorithms {
    private static boolean[] visited;

    /**
     * An iterative implementation of breadth first search with Queue
     * @param graph The graph to search
     * @param from The node to start search from
     * @param to The node to search
     * @return The cost of $from to $to if there is a path, infinity otherwise
     */
    public static double bfs(@NotNull Graph graph, int from, int to){
        visited = new boolean[graph.getNumberOfNodes()];
        Queue<double[]> queue = new Queue<>(graph.getNumberOfNodes());
        double[] pair = {from, 0};
        queue.enqueue(pair);
        visited[from] = true;

        while (!queue.isEmpty()){
            double[] front = queue.dequeue();
            int parent = (int) front[0];
            double cost = front[1];
            if (parent == to) {
                return cost;
            }
            for (int child: graph.getChildren(parent)){
                if (!visited[child]) {
                    visited[child] = true;
                    pair = new double[]{child, cost + graph.getCost(parent, child)};
                    queue.enqueue(pair);
                }
            }
        }

        return Double.POSITIVE_INFINITY;
    }

    /**
     * An iterative implementation of depth first search with Stack
     * @param graph The graph to search
     * @param from The node to start search from
     * @param to The node to search
     * @return The cost of $from to $to if there is a path, infinity otherwise
     */
    public static double dfs(@NotNull Graph graph, int from, int to){
        visited = new boolean[graph.getNumberOfNodes()];
        Stack<double[]> stack = new Stack<>(graph.getNumberOfNodes());
        double[] pair = {from, 0};
        stack.push(pair);
        visited[from] = true;

        while (!stack.isEmpty()){
            double[] front = stack.pop();
            int parent = (int) front[0];
            double cost = front[1];
            if (parent == to) {
                return cost;
            }
            for (int child: graph.getChildren(parent)){
                if (!visited[child]) {
                    visited[child] = true;
                    pair = new double[]{child, cost + graph.getCost(parent, child)};
                    stack.push(pair);
                }
            }
        }

        return Double.POSITIVE_INFINITY;
    }
}
