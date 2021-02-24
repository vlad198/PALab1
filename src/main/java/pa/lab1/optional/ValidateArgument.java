package pa.lab1.optional;

/**
 * Class to validate arguments
 */
public class ValidateArgument {
    /**
     * method to validate not empty arrays
     * @param arr the given array to validate
     * @param message message in case the array is empty
     */
    public void stringArrayNotEmpty(String[] arr,String message) {
        if (arr.length == 0) {
            System.out.println(message);
            System.exit(0);
        }
    }


}
