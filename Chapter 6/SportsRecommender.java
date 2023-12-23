public class SportsRecommender {
    public static void main(String[] args) {
        System.out.println(sportsRecommender(20));
        System.out.println(sportsRecommender(25));
        System.out.println(sportsRecommender(30));
        System.out.println(sportsRecommender(10));
        System.out.println(sportsRecommender(19));
        System.out.println(sportsRecommender(31));
        System.out.println(sportsRecommender(35));
        System.out.println(sportsRecommender(40));
        System.out.println(sportsRecommender(0));
        System.out.println(sportsRecommender(41));
        System.out.println(sportsRecommender(9));
        System.out.println(sportsRecommender(25.5));
        System.out.println(sportsRecommender(-1));

    }
    public static String sportsRecommender(double celsius) {
        if (celsius >= 20 && celsius <= 30) {
            return "It’s lovely weather for sports today!";
        }

        if (celsius >= 10 && celsius <= 40) {
            return "It’s reasonable weather for sports today.";
        }

        else  {
            return "“Please exercise with care today, watch out for the weather!";
        }
    }
}
