import java.util.Scanner;

public class GeoPoliticalZoneSwitch {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter your state (or FCT): ");
	String userInput = input.nextLine().toLowerCase();

	switch (userInput) {

		case "kebbi": case "kaduna": case "katsina": case "kano": case "sokoto": case "zamfara":
			System.out.printf("%nYou are from the North West%n");
			break;

		case "adamawa": case "borno": case "bauchi": case "gombe": case "jigawa": case "taraba": case "yobe":
			System.out.printf("%nYou are from the North East%n");
			break;

		case "plateau": case "kwara": case "kogi": case "benue": case "niger": case "nassarawa": case "fct":
			System.out.printf("%nYou are from the North Central%n");
			break;

		case "lagos": case "ondo": case "ogun": case "osun": case "oyo": case "ekiti":
			System.out.printf("%nYou are from the South West%n");
			break;

		case "abia": case "anambra": case "ebonyi": case "enugu": case "imo":
			System.out.printf("%nYou are from the South East%n");
			break;

		case "bayelsa": case "edo": case "cross-river": case "rivers": case "delta": case "akwa-ibom":
			System.out.printf("%nYou are from the South South%n");
			break;
		
		default:
			System.out.printf("%nOga, oga, oga... You are NOT from Nigeria!!!%n");
	}


   }

}
