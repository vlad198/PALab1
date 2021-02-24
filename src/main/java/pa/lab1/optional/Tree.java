package pa.lab1.optional;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to generate trees
 */
public class Tree extends Graph {
    private final int root;

    /**
     * Constructor
     * @param g the graph used to generate the tree
     */
    Tree(Graph g) {
        this.n = g.getN();
        this.root = (int) (Math.random() * n + 1);
        this.matrix = new int[n + 1][n + 1];
        generatePartialTree(g);
    }

    /**
     * Generate partial tree of the given graph with random root
     * @param g the graph used to generate the tree
     */
    private void generatePartialTree(Graph g) {
        int[] visitedNode = new int[this.n + 1];
        int[][] givenGraphMatrix = g.getMatrix();

        Queue<Integer> q = new LinkedList<>();
        q.add(this.root);
        visitedNode[this.root] = 1;

        while (!q.isEmpty()) {
            int currentNode = q.peek();
            q.remove();

            for (int i = 1; i <= this.n; i++)
                if (visitedNode[i] == 0 && givenGraphMatrix[currentNode][i] == 1) {
                    visitedNode[i] = 1;
                    q.add(i);
                    this.matrix[currentNode][i] = this.matrix[i][currentNode] = 1;
                }
        }
    }
}
