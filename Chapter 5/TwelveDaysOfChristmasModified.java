public class TwelveDaysOfChristmasModified {

   public static void main(String[] args) {

	for (int i = 1; i <= 12; i++) {

		System.out.printf("On the %s day", christmasDay(i));
		

		switch (i) {
			case 1 -> System.out.printf(" of Christmas my true love sent to me%nA partridge in a pear tree%n%n");
				
			case 2 -> System.out.printf(" of Christmas my true love sent to me%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 3 -> System.out.printf(" of Christmas my true love sent to me%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 4 -> System.out.printf(" of Christmas my true love sent to me%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 5 -> System.out.printf(" of Christmas my true love sent to me%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 6 -> System.out.printf(" of Christmas my true love sent to me%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 7 -> System.out.printf(" of Christmas my true love sent to me%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 8 -> System.out.printf(" of Christmas my true love sent to me%nEight maids a-milking,%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 9 -> System.out.printf(" of Christmas my true love sent to me%nNine ladies dancing,%nEight maids a-milking,%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 10 -> System.out.printf(" of Christmas my true love sent to me%nTen lords a-leaping,%nNine ladies dancing,%nEight maids a-milking,%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 11 -> System.out.printf(" of Christmas my true love sent to me%nEleven pipers piping,%nTen lords a-leaping,%nNine ladies dancing,%nEight maids a-milking,%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n");
				
			case 12 -> System.out.printf(" of Christmas my true love sent to me%nTwelve drummers drumming,%nEleven pipers piping,%nTen lords a-leaping,%nNine ladies dancing,%nEight maids a-milking,%nSeven swans a-swimming,%nSix geese a-laying,%nFive golden rings,%nFour calling birds,%nThree French hens,%nTwo turtle doves,%nAnd a partridge in a pear tree%n%n"); 
				
		}


	}


   }

	public static String christmasDay(int day) {
	
	switch (day) {
			case 1: return "first";
				
			case 2: return "second";
				
			case 3: return "third";
				
			case 4: return "fourth";
				
			case 5: return "fifth";
				
			case 6: return "sixth";
				
			case 7: return "seventh";
				
			case 8: return "eighth";
				
			case 9: return "ninth";
				
			case 10: return "tenth";
				
			case 11: return "eleventh";
				
			case 12: return "twelfth";
			
			default: return "null";
				
		}
	
		

	}
	



}




