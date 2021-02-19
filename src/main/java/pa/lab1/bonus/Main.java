package pa.lab1.bonus;

public class Main {

    public static final double levelProbability = 0.4;
    public static final double maxNumberOfLevels = 5;
    public static final int maxNumberOfDescendents = 3;

    public static int generateAndPrint(int nthLevel, int nodesSoFar, int[] parent) {

        double newLevelProbability = Math.random(); // selectam probabilitate generarii unui nou set de descendeti pentru nodul curent

        if (newLevelProbability > levelProbability && nthLevel <= maxNumberOfLevels) { // daca se respecta conditiile de existenta :
            for (int i = 1; i <= nthLevel - 1; i++)                                    // probabilitatea sa fie in intervalul [levelProbability,1]
                System.out.print("  ");                                                // iar numarul maxim de nivele sa nu fie depasit
            System.out.print("+node" + nodesSoFar + "\n");

            int numberOfDescendents = (int) (Math.random() * maxNumberOfDescendents + 1); // vom genera un numar random de descendenti ai nodului curent

            int totalNodesSoFar = nodesSoFar; // numarul total de noduri pana la momentul respectiv

            for (int i = 1; i <= numberOfDescendents; i++) {
                int child = totalNodesSoFar + 1; // noul copil al nodului curent
                parent[child] = nodesSoFar;      // il marcam in vectorul de tati
                totalNodesSoFar = generateAndPrint(nthLevel + 1, child, parent); // reluam procesul cu noul copil
            }
            return totalNodesSoFar;
        } else {
            for (int i = 1; i <= nthLevel - 1; i++) // altfel vom afisa fruza
                System.out.print("  ");
            System.out.print("-node" + nodesSoFar + "\n");

            return nodesSoFar;
        }
    }

    public static void main(String[] args) {

        // Implement an efficient algorithm that generates a random rooted tree.
        // Create and display a textual representation of the tree.

        System.out.println("Reprezentarea arborelui : ");
        int[] parent = new int[1000];
        parent[0] = -1;

        int n = generateAndPrint(1, 0, parent) + 1;

        System.out.print("Vectorul de tati : ");
        for (int i = 0; i < n; i++)
            System.out.print(parent[i] + " ");
        System.out.println("\nNumber of nodes : " + n);
    }

}
