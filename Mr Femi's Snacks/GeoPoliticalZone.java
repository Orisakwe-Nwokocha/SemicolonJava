import java.util.Scanner;

public class GeoPoliticalZone {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter your state (or FCT): ");
	String userInput = input.nextLine();

	switch (userInput) {

		case "Kebbi": case "Kaduna": case "Katsina": case "Kano": case "Sokoto": case "Zamfara":
			System.out.printf("%nYou are from the NW%n");
			break;

		case "Adamawa": case "Borno": case "Bauchi": case "Gombe": case "Jigawa": case "Taraba": case "Yobe":
			System.out.printf("%nYou are from the NE%n");
			break;

		case "Plateau": case "Kwara": case "Kogi": case "Benue": case "Niger": case "Nassarawa": case "FCT":
			System.out.printf("%nYou are from the NC%n");
			break;

		case "Lagos": case "Ondo": case "Ogun": case "Osun": case "Oyo": case "Ekiti":
			System.out.printf("%nYou are from the SW%n");
			break;

		case "Abia": case "Anambra": case "Ebonyi": case "Enugu": case "Imo":
			System.out.printf("%nYou are from the SE%n");
			break;

		case "Bayelsa": case "Edo": case "Cross-River": case "Rivers": case "Delta": case "Akwa-Ibom":
			System.out.printf("%nYou are from the SS%n");
			break;
	}


   }

}
