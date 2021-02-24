package pa.lab1.optional;

/**
 * class used for it's casting methods
 * 1. string to int
 */
public class CastArgument {
    /**
     * Method to cast from string to integer
     * @param textNumber  message in case of error
     * @return  casted value
     */
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
