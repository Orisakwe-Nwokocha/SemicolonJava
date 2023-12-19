public class FloorAndCeil {
    public static void main(String[] args) {
        System.out.println(myFloor(-5.8));
        System.out.println(Math.floor(5.8));
        System.out.println();
        System.out.println(myCeil(-5.8));
        System.out.println(Math.ceil(5.8));
    }
    public static int myFloor(double num){
       if (num > 0) {
           return (int) num;
       } else {
           return (int) num + -1;
       }
    }
    public static int myCeil(double num){
        if (num > 0) {
            return (int) num + 1;
        } else {
            return (int) num;
        }
    }
}
