package pa.lab1.bonus;

import java.util.Vector;

public class Tree {

    // CONSTANTS
    public static final double levelProbability = 0.4;
    public static final double maxNumberOfLevels = 5;
    public static final int maxNumberOfDescendents = 3;

    // OBJECT DATA
    private final int root;
    private final int n;
    private final Vector<Integer> parent;

    Tree() {
        this.root = 0;
        parent = new Vector<Integer>();
        parent.add(-1);
        this.n = generate(1, 0);
    }

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

    private boolean isLeaf(int node) {
        for (Integer parrentNode : parent)
            if (parrentNode == node)
                return false;
        return true;
    }

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

    public void printTree() {
        print(1, 0);
    }


}
