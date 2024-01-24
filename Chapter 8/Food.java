public enum Food {
    APPLE("Fruit", 95),
    BANANA("Fruit", 105),
    CARROT("Vegetable", 25);

   private final String type;
   private final int noOfCalories;
   
   Food(String type, int noOfCalories) {
       this.type = type;
       this.noOfCalories = noOfCalories;
   }
   
   public String getType() {
       return type;
   }
   
   public int getNoOfCalories() {
       return noOfCalories;
   }

}