package modelo;

import java.io.*;
import java.util.*;

public class DijkstraAlgorithm<T> implements Serializable {

    public void dijkstra(Graph<T> graph, T source, T destination) {
        Node<T> startNode = graph.nodes.get(source);
        Node<T> endNode = graph.nodes.get(destination);

        Map<Node<T>, Integer> distance = new HashMap<>();
        Map<Node<T>, Node<T>> previousNode = new HashMap<>();

        PriorityQueue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (Node<T> node : graph.nodes.values()) {
            if (node == startNode) {
                distance.put(node, 0);
            } else {
                distance.put(node, Integer.MAX_VALUE);
            }
            previousNode.put(node, null);
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            for (Node<T> neighbor : current.neighbors.keySet()) {
                int alt = distance.get(current) + current.neighbors.get(neighbor);
                if (alt < distance.get(neighbor)) {
                    distance.put(neighbor, alt);
                    previousNode.put(neighbor, current);
                }
            }
        }

        List<Node<T>> path = new ArrayList<>();
        Node<T> current = endNode;
        while (current != null) {
            path.add(current);
            current = previousNode.get(current);
        }
        Collections.reverse(path);

        System.out.println("Camino más corto desde " + source + " a " + destination + ":");
        for (Node<T> node : path) {
            System.out.print(node.data + " ");
        }
        System.out.println("\nDistancia total: " + distance.get(endNode));
    }

    public void saveGraph(Graph<T> graph, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(graph);
            System.out.println("Grafo guardado exitosamente en " + fileName);
        }
    }

    public Graph<T> loadGraph(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Graph<T>) inputStream.readObject();
        }
    }
}