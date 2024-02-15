package geoPoliticalZone;

public enum GeoPoliticalZone {
    NORTH_WEST("kebbi", "kaduna", "katsina", "kano", "sokoto", "zamfara"),
    NORTH_EAST("adamawa", "borno", "bauchi", "gombe", "jigawa", "taraba", "yobe"),
    NORTH_CENTRAL("plateau", "kwara", "kogi", "benue", "niger", "nassarawa", "fct"),

    SOUTH_WEST("lagos", "ondo", "ogun", "osun", "oyo", "ekiti"),
    SOUTH_EAST("abia", "anambra", "ebonyi", "enugu", "imo"),
    SOUTH_SOUTH("bayelsa", "edo", "cross-river", "rivers", "delta", "akwa-ibom");

    private String[] states;

    GeoPoliticalZone(String... states) {
        this.states = states;
    }

    public String[] getStates() {
        return states;
    }
}
