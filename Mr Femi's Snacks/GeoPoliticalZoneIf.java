import java.util.Scanner;

public class GeoPoliticalZoneIf {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter your state (or FCT): ");
	String state = input.nextLine();

	boolean isNorthWestState = state.equalsIgnoreCase("Kebbi") || state.equalsIgnoreCase("Katsina") || state.equalsIgnoreCase("Kano") || state.equalsIgnoreCase("Sokoto") || state.equalsIgnoreCase("Zamfara") || state.equalsIgnoreCase("Kaduna"); 

	boolean isNorthEastState = state.equalsIgnoreCase("Adamawa") || state.equalsIgnoreCase("Borno") || state.equalsIgnoreCase("Bauchi") || state.equalsIgnoreCase("Gombe") || state.equalsIgnoreCase("Jigawa") || state.equalsIgnoreCase("Taraba") || state.equalsIgnoreCase("Yobe"); 

	boolean isNorthCentralState = state.equalsIgnoreCase("Plateau") || state.equalsIgnoreCase("Kogi") || state.equalsIgnoreCase("Kwara") || state.equalsIgnoreCase("Benue") || state.equalsIgnoreCase("Niger") || state.equalsIgnoreCase("Nassarawa") || state.equalsIgnoreCase("FCT"); 

	boolean isSouthWestState = state.equalsIgnoreCase("Lagos") || state.equalsIgnoreCase("Ondo") || state.equalsIgnoreCase("Ogun") || state.equalsIgnoreCase("Osun") || state.equalsIgnoreCase("Oyo") || state.equalsIgnoreCase("Ekiti"); 

	boolean isSouthEastState = state.equalsIgnoreCase("Abia") || state.equalsIgnoreCase("Anambra") || state.equalsIgnoreCase("Ebonyi") || state.equalsIgnoreCase("Enugu") || state.equalsIgnoreCase("Imo"); 

	boolean isSouthSouthState = state.equalsIgnoreCase("Bayelsa") || state.equalsIgnoreCase("Edo") || state.equalsIgnoreCase("Cross-River") || state.equalsIgnoreCase("Rivers") || state.equalsIgnoreCase("Delta") || state.equalsIgnoreCase("Akwa-Ibom"); 

	boolean isNotAState = !isNorthWestState || !isNorthEastState || !isNorthCentralState || !isSouthWestState || !isSouthEastState || !isSouthSouthState;

	if (isNorthWestState) {	System.out.printf("%nYou are from the North West%n"); }	
	else if (isNorthEastState) {	System.out.printf("%nYou are from the North East%n"); }	
	else if (isNorthCentralState) { System.out.printf("%nYou are from the North Central%n"); }	
	else if (isSouthWestState) {	System.out.printf("%nYou are from the South West%n"); }	
	else if (isSouthEastState) {	System.out.printf("%nYou are from the South East%n"); }	
	else if (isSouthSouthState) { System.out.printf("%nYou are from the South South%n"); }
	else if (isNotAState) { System.out.printf("%nOga, oga, oga... You are NOT from Nigeria!!!%n"); }	


   }

}
