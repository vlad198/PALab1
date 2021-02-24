package pa.lab1.optional;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class to generate graphs
 */
public class Graph {
    protected int n;
    protected int[][] matrix;

    /**
     * Default Constructor generates matrix
     * with random number of nodes
     */
    Graph() {
        this.n = (int) (Math.random() * 10_000) + 1;
        genMatrix();
    }

    /**
     * Constructor
     * @param numberOfNodes  number of node for the given graph
     */
    Graph(int numberOfNodes) {
        this.n = numberOfNodes;
        genMatrix();
    }

    /**
     * BFS algorithm
     * @param node  start node(first node in the queue)
     * @param k     mark for every node in the matrix(node i is int k-th connected component)
     * @param viz   vector of marks for every node(node i is in the viz[i] connected component)
     */
    public void BFS(int node, int k, int[] viz) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        viz[node] = k;

        while (!q.isEmpty()) {
            int currentNode = q.peek();
            q.remove();

            for (int i = 1; i <= this.n; i++)
                if (viz[i] == 0 && this.matrix[currentNode][i] == 1) {
                    viz[i] = k;
                    q.add(i);
                }
        }
    }

    /**
     * check if the graph is connex
     * @return  true if the graph si connex , false otherwise
     */
    public boolean connectedGraph() {
        int[] viz = new int[n + 1];
        int k = 0;

        BFS(1, 1, viz);

        for (int i = 1; i <= this.n; i++)
            if (viz[i] == 0)
                return false;

        return true;
    }


    /**
     * Print the adjacency matrix of the graph
     */
    public void printMatrix() {
        for (int i = 1; i <= this.n; i++) {
            for (int j = 1; j <= this.n; j++) {
                char unicode = this.matrix[i][j] == 1 ? '\u25A3' : '\u25A1';
                System.out.print(unicode);
            }
            System.out.print('\n');
        }
    }

    /**
     *
     * @param viz vector of marks for every node(node i is in the viz[i] connected component)
     * @return the number of connected components
     */
    private int generateConnectedComponents(int[] viz) {
        int numberOfConnectedComponents = 0;
        for (int i = 1; i <= this.n; i++)
            if (viz[i] == 0)
                BFS(i, ++numberOfConnectedComponents, viz);
        return numberOfConnectedComponents;
    }

    /**
     * Print all the connected components of the graph
     */
    public void printConnectedComponents() {
        int[] components = new int[this.n + 1];

        int numberOfConnectedComponents = generateConnectedComponents(components);

        for (int i = 1; i <= numberOfConnectedComponents; i++) {
            System.out.print("Componenta " + i + " : ");

            for (int j = 1; j <= this.n; j++)
                if (components[j] == i)
                    System.out.print(j + " ");
            System.out.print('\n');
        }
    }


    /**
     * Generates random matrix
     */
    private void genMatrix() {
        this.matrix = new int[n + 1][n + 1];

        int maxNumberOfEdges = n * (n - 1) / 2;

        int m = (int) (Math.random() * maxNumberOfEdges);

        while (m > 0) {
            int x = (int) (Math.random() * n) + 1;
            int y = (int) (Math.random() * n) + 1;

            while (x == y || this.matrix[x][y] != 0) {
                x = (int) (Math.random() * n) + 1;
                y = (int) (Math.random() * n) + 1;
            }

            this.matrix[x][y] = this.matrix[y][x] = 1;
            m--;
        }
    }

    /**
     * getter for number of nodes
     * @return number of nodes
     */
    public int getN() {
        return this.n;
    }

    /**
     * getter for the adjacency matrix of the graph
     * @return adjacency matrix of the graph
     */
    public int[][] getMatrix() {
        return this.matrix;
    }

}
