public class GeoLocator{
     
	public String findGeo(String state){
		return switch(state){
			case "kebbi", "kaduna", "katsina", "kano", "sokoto", "zamfara" -> "You are from the North West";
			default -> "Oga, oga, oga... You are NOT from Nigeria!!!";
		};
	}


}