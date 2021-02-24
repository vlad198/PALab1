package pa.lab1.optional;

public class ValidateArgument {

    public void stringArrayNotEmpty(String[] arr,String message) {
        if (arr.length == 0) {
            System.out.println(message);
            System.exit(0);
        }
    }


}
