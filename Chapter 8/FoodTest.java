import java.util.EnumSet;

public class FoodTest {
    public static void main(String... ori) {
        System.out.println("All food:");
        
        for (Food food : Food.values()) {
            System.out.printf("%-9s%-12s%4d%n", food, food.getType(), food.getNoOfCalories());           
        }  
        
        System.out.printf("%nDisplay a range of enum constants:%n");
        
        for (Food food : EnumSet.range(Food.BANANA, Food.CARROT)) {
            System.out.printf("%-9s%-12s%4d%n", food, food.getType(), food.getNoOfCalories());           
        }      
        
    }
}