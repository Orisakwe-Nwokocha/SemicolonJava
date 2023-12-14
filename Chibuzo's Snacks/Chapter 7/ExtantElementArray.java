public class ExtantElementArray {
    private static boolean isExisting;

    public static void main(String[] args) {
        int[] arrayInt = {1, 4, 5, 7, 3};
        String[] arrayStr = {"I", "do", "not", "know", "what", "to", "write"};
        double[] arrayDouble = {1.0, 2.0, 3.0, 4.0};
        char[] arrayChar = {'a', 'o', '$', '%', '2'};

        int elementToCheckInt = 77;
        String elementToCheckStr = "know";
        double elementToCheckDouble = 5.0;
        char elementToCheckChar = '$';

        boolean isExistingInt = extantElement(arrayInt, elementToCheckInt);
        boolean isExistingStr = extantElement(arrayStr, elementToCheckStr);
        boolean isExistingDouble = extantElement(arrayDouble, elementToCheckDouble);
        boolean isExistingChar = extantElement(arrayChar, elementToCheckChar);

        if (isExistingInt) {
            System.out.println("Element <" + elementToCheckInt + "> exists in the array.");
        } else {
            System.out.println("Element <" + elementToCheckInt + "> does not exist in the array.");
        }

        if (isExistingStr) {
            System.out.println("Element <" + elementToCheckStr + "> exists in the array.");
        } else {
            System.out.println("Element <" + elementToCheckStr + "> does not exist in the array.");
        }

        if (isExistingDouble) {
            System.out.println("Element <" + elementToCheckDouble + "> exists in the array.");
        } else {
            System.out.println("Element <" + elementToCheckDouble + "> does not exist in the array.");
        }

        if (isExistingChar) {
            System.out.println("Element <" + elementToCheckChar + "> exists in the array.");
        } else {
            System.out.println("Element <" + elementToCheckChar + "> does not exist in the array.");
        }

    }
    public static boolean extantElement(int[] list, int element){
        for (int index = 0; index < list.length; index++){
            if (list[index] == element){
               isExisting = true;
               break;
            } else {
                isExisting = false;
            }
        }
        return isExisting;
    }
    public static boolean extantElement(String[] list, String element){
        for (int index = 0; index < list.length; index++){
            if (list[index].equals(element)){
                isExisting = true;
                break;
            } else {
                isExisting = false;
            }
        }
        return isExisting;
    }
    public static boolean extantElement(double[] list, double element){
        for (int index = 0; index < list.length; index++){
            if (list[index] == element){
                isExisting = true;
                break;
            } else {
                isExisting = false;
            }
        }
        return isExisting;
    }
    public static boolean extantElement(char[] list, char element){
        for (int index = 0; index < list.length; index++){
            if (list[index] == element){
                isExisting = true;
                break;
            } else {
                isExisting = false;
            }
        }
        return isExisting;
    }
}
