package com.warfield.problems;
/*
// /*


// Task Orchestration Engine

// Build a task orchestration engine that takes a set of tasks and the dependency between them as input and checks if the tasks can be executed and finished, and outputs the next set of tasks to be executed. The input to the engine will be a task array that represents the list of tasks, and a dependency array that represents the dependency between tasks.
// For eg.
// Example 1
// Task array = [0, 1, 2, 3, 4]
// Dependencies = [[1, 0], [2, 0], [3, 0], [4, 3]] => 1, 2, and 3 can execute only after 0 finishes, 4 can execute only after 3 finishes. The order of execution in this case will be
// Time T -> Task 0
// Time T+1 -> Task 1, 2, and 3
// Time T+2 -> Task 4

// Returns - [[0], [1, 2, 3], [4]]

// Example 2
// Task array = [0, 1, 2, 3, 4]
// Dependencies = [[1, 2][2, 3][3, 1]] - cannot execute
// */
//Your old code in go has been preserved below.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Vertex {
    int data;
    boolean isVisited;
    List<Vertex> neighbour =null;

    Vertex(int data) {
        this.data = data;
    }

    public void addNeighbours(List<Vertex> vertices){
        this.neighbour = vertices;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", isVisited=" + isVisited +
                ", neighbour=" + (neighbour==null?"-":String.valueOf(neighbour.get(0).data)) +
                '}';
    }
}


class Graph {
    final List<Vertex> vertices = new ArrayList<>();

    public void addVertex(Vertex v) {
        vertices.add(v);
    }


    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                '}';
    }
}


public class TaskExecutor {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        v1.addNeighbours(List.of(v2));
        v1.addNeighbours(List.of(v3));
        v2.addNeighbours(List.of(v3));
        v3.addNeighbours(List.of(v4));
        //v4.addNeighbours(List.of(v3));
        System.out.println(graph);

        for (Vertex vertex : graph.vertices) {
            int head = vertex.data;
            String path= String.valueOf(head);
            checkForCyclicDependency(vertex,head, path);
            resetVisitedFlag(graph);
        }

    }

    private static void resetVisitedFlag(Graph graph) {
        for (Vertex vertex: graph.vertices){
            vertex.isVisited=false;
        }
    }

    private static void checkForCyclicDependency(Vertex vertex,int head, String path) {
        vertex.isVisited=true;
        if(vertex.neighbour==null){
            System.out.println("No Cycle deducted: "+path);
        }else{
            Vertex neighbourVertex = vertex.neighbour.get(0);
            path=path+"->"+ neighbourVertex.data;
            if(neighbourVertex.data==head || neighbourVertex.isVisited){
                System.out.println("Cycle deducted :"+path);
                return;
            }
            checkForCyclicDependency(neighbourVertex,head, path);
        }
    }


}
