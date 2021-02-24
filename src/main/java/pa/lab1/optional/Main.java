package pa.lab1.optional;

//  compile : javac -d . Main.java
//  run     : java -Xms8G -Xmx8G optional.Main 30000

public class Main {

    public static void main(String[] args) {

        CastArgument cast = new CastArgument();
        ValidateArgument validate = new ValidateArgument();
        MonitorizeTime programTime = new MonitorizeTime();

        validate.stringArrayNotEmpty(args, "Nu a fost dat n ca si argument.");

        programTime.setStart();

        int n = cast.stringToInteger(args[0]);

        Graph g = new Graph(n);

        System.out.println("Graph : ");
        g.printMatrix();

        if (g.connectedGraph()) {
            //ceva
            System.out.println("connected");

            Tree t = new Tree(g);
            System.out.println("Tree : ");
            t.printMatrix();

        } else
            g.printConnectedComponents();

        programTime.setEnd();

        System.out.println("Programul a durat " + programTime.getTimeBetween() + " nanosecunde");
    }
}