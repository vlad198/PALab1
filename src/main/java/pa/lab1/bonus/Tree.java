package pa.lab1.bonus;

import java.util.Vector;

/**
 * class used to generate random tree
 */
public class Tree {

    // CONSTANTS
    public final double levelProbability;
    public final double maxNumberOfLevels;
    public final int maxNumberOfDescendents;

    // OBJECT DATA
    private final int root;
    private final int n;
    private final Vector<Integer> parent;

    /**
     * Constructor with some limits and probabilities, otherwise our generation can go on forever
     * @param levelProbability the probability to generate a new level for the tree
     * @param maxNumberOfLevels maximum number of leveles for the tree
     * @param maxNumberOfDescendents maximum number of descedents for a node in the tree
     */
    Tree(double levelProbability, double maxNumberOfLevels, int maxNumberOfDescendents) {
        this.levelProbability = levelProbability;
        this.maxNumberOfDescendents = maxNumberOfDescendents;
        this.maxNumberOfLevels = maxNumberOfLevels;
        this.root = 0;
        parent = new Vector<Integer>();
        parent.add(-1);
        this.n = generate(1, 0);
    }

    /**
     * generates the random tree
     * @param nthLevel current level
     * @param nodesSoFar the number of nodes generated at some point
     * @return the number of nodes in the tree without the root
     */
    private int generate(int nthLevel, int nodesSoFar) {
        double newLevelProbability = Math.random();

        if (newLevelProbability > levelProbability && nthLevel <= maxNumberOfLevels) {

            int numberOfDescendents = (int) (Math.random() * maxNumberOfDescendents + 1);
            int totalNodesSoFar = nodesSoFar;

            for (int i = 1; i <= numberOfDescendents; i++) {
                int child = totalNodesSoFar + 1;
                parent.add(child, nodesSoFar);
                totalNodesSoFar = generate(nthLevel + 1, child);
            }
            return totalNodesSoFar;
        } else
            return nodesSoFar;
    }

    /**
     * check if a node is a leaf or no for our tree
     * @param node the node checked
     * @return true if it is a leaf, false otherwise
     */
    private boolean isLeaf(int node) {
        for (Integer parrentNode : parent)
            if (parrentNode == node)
                return false;
        return true;
    }

    /**
     * print the tree with the given template
     * @param nthLevel - current level
     * @param currentNode - current node to print
     */
    private void print(int nthLevel, int currentNode) {

        for (int i = 0; i < nthLevel - 1; i++)
            System.out.print("  ");

        if (isLeaf(currentNode))
            System.out.println("-node" + currentNode);
        else {
            System.out.println("+node" + currentNode);
            for (int i = 0; i < parent.size(); i++)
                if (parent.get(i) == currentNode)
                    print(nthLevel + 1, i);
        }
    }

    /**
     * public method to print the tree
     */
    public void printTree() {
        print(1, 0);
    }


}
