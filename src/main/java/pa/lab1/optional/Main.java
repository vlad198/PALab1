package pa.lab1.optional;

import java.util.*;

//  compile : javac -d . Main.java
//  run     : java -Xms8G -Xmx8G optional.Main 30000


public class Main {

    // implementarea algoritmului BFS
    public static void BFS(int node, int k, int n, int[] viz, int[][] matrix) {
        Queue<Integer> q = new LinkedList<>(); // definim coada

        q.add(node); // adaugam nodul de plecare
        viz[node] = k; // il marcam ca vizitat

        while (!q.isEmpty()) { // cat timp mai avem noduri in coada
            int currentNode = q.peek(); // extragem nodul din coada
            q.remove();

            for (int i = 1; i <= n; i++) // ii parcurgem toti vecinii nevizitati si ii adaugam in coada si ii marcam ca vizitati
                if (viz[i] == 0 && matrix[currentNode][i] == 1) {
                    viz[i] = k;
                    q.add(i);
                }
        }
    }

    public static void printMatrix(int n, int[][] matrix) {
        for (int i = 1; i <= n; i++) { // afisare clasica de matrice
            for (int j = 1; j <= n; j++) {
                char unicode = matrix[i][j] == 1 ? '\u25A3' : '\u25A1';
                System.out.print(unicode);
            }
            System.out.print('\n');
        }
    }


    public static void main(String[] args) {

//      Let n be an integer given as a command line argument. Validate the argument!

        long startTime = System.nanoTime(); // timpul de inceput al programului

        if (args.length == 0) { // daca nu am dat argumentul de la linia de comanda
            System.out.println("Nu a fost dat numarul n ca argument.");
            System.exit(0);
        }

        int n = 0;

        // ref : https://stackoverflow.com/questions/35936799/validation-so-input-is-only-integer-in-java/35937125
        try {
            n = Integer.parseInt(args[0]); // incercam sa transformam stringul in int
        } catch (NumberFormatException ex) {
            System.out.println("Not an integer");
            System.exit(0);
        }

        // Create a n x n matrix, representing the adjacency matrix of a random graph .

        int[][] matrix = new int[n + 1][n + 1]; // matricea grafului

        int maxNumberOfEdges = n * (n - 1) / 2; // numarul maxim de muchii

        int m = (int) (Math.random() * maxNumberOfEdges); // un numar arbitrar

        System.out.println("Max number of edges : " + maxNumberOfEdges);
        System.out.println("Number of edges : " + m);

        while (m > 0) {
            int x = (int) (Math.random() * n) + 1; // generam o pereche de noduri
            int y = (int) (Math.random() * n) + 1;

            while (x == y || matrix[x][y] != 0) { // daca nodurile nu coincid si perechea nu a mai aparut atunci tuplul este valid
                x = (int) (Math.random() * n) + 1; // altfel generam perechi pana una va respecta conditia
                y = (int) (Math.random() * n) + 1;
            }

            matrix[x][y] = matrix[y][x] = 1; // marcam muchia in matricea de incidenta
            m--; // scadem numarul de muchii
        }


        System.out.println("Graph : ");
        printMatrix(n,matrix);

        // Verify if the generated graph is connected and display the connected components (if it is not).

        int[] viz = new int[n + 1]; // vectorul de vizitare
        int k = 0;

        for (int i = 1; i <= n; i++) // mergem pe toate nodurile iar din ficare parcurgem toate nodurile posibile si le marcam
            if (viz[i] == 0)         // ca facand parte din componenta k
                BFS(i, ++k, n, viz, matrix);

        if (k == 1) { // graful este conex
            System.out.println("This graph is connected");

            // Assuming that the generated graph is connected, implement an algorithm that creates a partial
            // tree of the graph. Display the adjacency matrix of the tree.

            int root = 1;                                // consideram radacina 1
            int[][] partialTree = new int[n + 1][n + 1]; // generam o matrice de nxn
            int[] visitedNode = new int[n + 1];          // vectorul de vizitare

            Queue<Integer> q = new LinkedList<>(); // coada pentru BFS-ul necesar pentru a crea
            // arborele partial
            q.add(root);                // adaugam radacina in coada
            visitedNode[root] = 1;      // o marcam ca vizitate

            while (!q.isEmpty()) { // cat timp coada nu e vida
                int currentNode = q.peek(); // extragem un nod din coada
                q.remove();

                for (int i = 1; i <= n; i++)    // ii parcurgem toti vecinii nevizitati
                    if (visitedNode[i] == 0 && matrix[currentNode][i] == 1) {
                        visitedNode[i] = 1; // marcam nodul ca vizitat
                        q.add(i);           // adaugam in coada
                        partialTree[currentNode][i] = partialTree[i][currentNode] = 1; // marcam muchia in matricea de adiacenta a arborelui
                    }
            }

            System.out.println("Tree : ");
            printMatrix(n, partialTree);


        } else {

            for (int i = 1; i <= k; i++) {  // pentru fiecare componenta conexa k
                System.out.print("Componenta " + i + " : ");

                for (int j = 1; j <= n; j++) // afisam nodurile care fac parte din aceasta componenta
                    if (viz[j] == i)
                        System.out.print(j + " ");
                System.out.print('\n');
            }
        }

        long endTime = System.nanoTime(); // timpul de sfarsit
        long totalTime = endTime - startTime;   // durata timpului


        System.out.println("Programul a durat " + totalTime + " nanosecunde");
    }
}