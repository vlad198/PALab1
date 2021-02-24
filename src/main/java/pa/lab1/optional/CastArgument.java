package pa.lab1.optional;

public class CastArgument {

    public int stringToInteger(String textNumber){
        try {
            return Integer.parseInt(textNumber);
        } catch (NumberFormatException ex) {
            System.out.println("Argument is not an integer");
            System.exit(0);
        }
        return 0;
    }

}
