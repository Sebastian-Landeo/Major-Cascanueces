package modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Node<T> implements Serializable {
    T data;
    Map<Node<T>, Integer> neighbors;

    public Node(T data) {
        this.data = data;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(Node<T> neighbor, int weight) {
        neighbors.put(neighbor, weight);
        neighbor.neighbors.put(this, weight);
    }
}