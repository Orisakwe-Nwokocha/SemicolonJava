package geoPoliticalZone;

public class FindGeoZone {
    public static GeoPoliticalZone findGeoZone(String state) {
        for (GeoPoliticalZone zone : GeoPoliticalZone.values()) {
            GeoPoliticalZone geoZone = findZone(state, zone);
            if (geoZone != null) return geoZone;
        }

        return null;
    }

    private static GeoPoliticalZone findZone(String state, GeoPoliticalZone zone) {
        String[] states = zone.getStates();
        for (String s : states) {
            if (s.equalsIgnoreCase(state)) return zone;
        }

        return null;
    }
}
