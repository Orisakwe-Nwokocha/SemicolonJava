import java.util.Scanner;

public class CylinderMain {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        
        CylinderClass cylinder = new CylinderClass();
        
        System.out.println("Enter radius:");
        int radius = input.nextInt();
        
        System.out.println("Enter height:");
        int height = input.nextInt();
        
        try {
            cylinder.setRadius(radius);
        }
        catch (IllegalArgumentException e){
            System.out.printf("Exception while initialising radius: %s%n", e.getMessage());
        }
        
        try {
            cylinder.setHeight(height);
        }
        catch (IllegalArgumentException e){
            System.out.printf("Exception while initialising height: %s%n", e.getMessage());
        }
        
        System.out.printf("%nVolume: %.2f", cylinder.cylinderVolume());
        
        input.close();
    }



}