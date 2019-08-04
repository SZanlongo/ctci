package chapter_4_Trees_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Question_4_2 {
    public static final int GRAPH_SIZE = 6;

    public static void main(String[] args) {
        Graph graph = new Graph(GRAPH_SIZE);
        Node[] vertices = new Node[GRAPH_SIZE];
        vertices[0] = new Node("a", 1);
        vertices[1] = new Node("b", 1);
        vertices[2] = new Node("c", 1);
        vertices[3] = new Node("e", 2);
        vertices[4] = new Node("d", 1);
        vertices[5] = new Node("f", 0);

        vertices[0].addNeighbor(vertices[1]);
        vertices[1].addNeighbor(vertices[2]);
        vertices[2].addNeighbor(vertices[3]);
        vertices[3].addNeighbor(vertices[4]);
        vertices[3].addNeighbor(vertices[5]);
        vertices[4].addNeighbor(vertices[1]);

        for (int i = 0; i < GRAPH_SIZE; i++) {
            graph.addVertex(vertices[i]);
        }

        Node s = vertices[0];
        Node g = vertices[4];

        System.out.println(bfsPath(graph, s, g));

    }

    // do a BFS on the graph
    public static boolean bfsPath(Graph graph, Node start, Node goal) {
        Queue<Node> q = new LinkedList<Node>();

        start.state = 1;// root visited
        q.add(start);

        while (!q.isEmpty()) {// while there are unexplored vertices
            Node n = q.remove();// remove next element
            for (Node neighbor : n.neighbors) {// for every neighbor
                if (neighbor.state == 0) {
                    if (neighbor == goal) {
                        return true;
                    }
                    neighbor.state = 1;// mark as visited
                    q.add(neighbor);// add neighbor to queue
                }
            }
        }
        return false;// explored entire graph with no path to goal
    }

}

class Node {
    public Node[] neighbors;// list of neighbors
    public int state = 0;// unvisited=0, visited=1
    public String name;
    public int nCount = 0;// number of neighbors

    public Node(String name, int nCount) {
        this.name = name;
        neighbors = new Node[nCount];
    }

    public void addNeighbor(Node n) {
        neighbors[nCount++] = n;
    }

    public Node[] getNeighbors() {
        return neighbors;
    }
}

class Graph {
    public Node[] vertices;
    public int nVert = 0;// number of vertices

    public Graph(int size) {
        vertices = new Node[size];
    }

    public void addVertex(Node n) {
        vertices[nVert++] = n;
    }
}