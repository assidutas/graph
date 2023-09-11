package com.lugis.graph;

import java.util.LinkedList;

// This class represents a directed graph using adjacency
public class SimpleGraph {
    private int vertexNum;
    private LinkedList<Integer>[] adj;

    // Constructor
    SimpleGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        adj = new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int from, int to) {
        adj[from].add(to);
    }

    //最朴素的BFS
    private void BFSWithLayer(int vertex) {
        boolean visited[] = new boolean[vertexNum];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            int count = queue.size();
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                vertex = queue.poll();
                System.out.println(vertex + " ");
                for (int n : adj[vertex]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    //记录访问的层次的BFS
    private void BFS(int vertex) {
        boolean visited[] = new boolean[vertexNum];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int n : adj[vertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.BFSWithLayer(2);
    }
}
