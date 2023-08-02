package modelo;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String fileName = "graph.ser";
        Graph<String> graph = new Graph<>();
        DijkstraAlgorithm<String> dijkstraAlgorithm = new DijkstraAlgorithm<>();

        try {
            graph = dijkstraAlgorithm.loadGraph(fileName);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nodo de inicio: ");
            String startNode = scanner.nextLine();
            System.out.print("Ingrese el nodo de destino: ");
            String endNode = scanner.nextLine();

            dijkstraAlgorithm.dijkstra(graph, startNode, endNode);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}