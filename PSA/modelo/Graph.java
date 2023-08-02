package modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> implements Serializable {
    Map<T, Node<T>> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public Node<T> addNode(T data) {
        Node<T> newNode = new Node<>(data);
        nodes.put(data, newNode);
        return newNode;
    }

    public void addEdge(T data1, T data2, int weight) {
        Node<T> node1 = nodes.get(data1);
        Node<T> node2 = nodes.get(data2);
        if (node1 != null && node2 != null) {
            node1.addNeighbor(node2, weight);
        }
    }
}