package modelo;

import java.io.*;
import java.util.*;

public class GraphCreator {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Node<String> node1 = graph.addNode("1");
        Node<String> node2 = graph.addNode("2");
        Node<String> node3 = graph.addNode("3");
        Node<String> node4 = graph.addNode("4");
        Node<String> node5 = graph.addNode("5");
        Node<String> node6 = graph.addNode("6");
        Node<String> node7 = graph.addNode("7");
        Node<String> node8 = graph.addNode("8");
        Node<String> node9 = graph.addNode("9");
        Node<String> node10 = graph.addNode("10");
        Node<String> node11 = graph.addNode("11 (Oficina)");
        Node<String> node12 = graph.addNode("12 (Oficina)");
        Node<String> node13 = graph.addNode("13 (Oficina)");
        Node<String> node14 = graph.addNode("14 (Salon)");
        Node<String> node15 = graph.addNode("15 (Salon)");
        Node<String> node16 = graph.addNode("16 (Escalera)");
        Node<String> node17 = graph.addNode("17 (Salon)");
        Node<String> node18 = graph.addNode("18 (Salon)");
        Node<String> node19 = graph.addNode("19 (Escalera)");
        Node<String> node20 = graph.addNode("20 (Baño)");
        Node<String> node21 = graph.addNode("21 (Salon)");
        Node<String> node22 = graph.addNode("22 (Salon)");
        Node<String> node23 = graph.addNode("23 (Salon)");
        Node<String> node24 = graph.addNode("24 (Salon)");
        Node<String> node25 = graph.addNode("25 (Salon)");

        // Agregar conexiones y pesos
        graph.addEdge(node1.data, node11.data, 2);
        graph.addEdge(node1.data, node2.data, 3);
        graph.addEdge(node2.data, node12.data, 4);
        graph.addEdge(node2.data, node3.data, 5);
        graph.addEdge(node2.data, node4.data, 6);
        graph.addEdge(node3.data, node13.data, 7);
        graph.addEdge(node4.data, node14.data, 8);
        graph.addEdge(node4.data, node21.data, 9);
        graph.addEdge(node4.data, node5.data, 10);
        graph.addEdge(node5.data, node15.data, 11);
        graph.addEdge(node5.data, node22.data, 12);
        graph.addEdge(node5.data, node6.data, 13);
        graph.addEdge(node6.data, node16.data, 14);
        graph.addEdge(node6.data, node8.data, 15);
        graph.addEdge(node6.data, node7.data, 16);
        graph.addEdge(node7.data, node17.data, 17);
        graph.addEdge(node8.data, node18.data, 18);
        graph.addEdge(node8.data, node23.data, 19);
        graph.addEdge(node8.data, node9.data, 20);
        graph.addEdge(node9.data, node19.data, 21);
        graph.addEdge(node9.data, node24.data, 22);
        graph.addEdge(node9.data, node10.data, 23);
        graph.addEdge(node10.data, node20.data, 24);
        graph.addEdge(node10.data, node25.data, 25);

        String fileName = "graph.ser";
        saveGraph(graph, fileName);
        System.out.println("Grafo creado y guardado exitosamente en " + fileName);
    }

    public static <T> void saveGraph(Graph<T> graph, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
