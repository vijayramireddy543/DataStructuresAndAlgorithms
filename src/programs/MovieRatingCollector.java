package programs;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MovieRatingCollector {
    public static class RatingCollectorImpl implements RatingCollector {
        Map<String, List<Double>> movieWiseRatings = new ConcurrentHashMap<>();


        /**
         * Method used to save movie ratings
         *
         * @param movie represents movie name
         * @param rating represents rating between 0 to 100
         */
        @Override
        public void putNewRating(String movie, double rating) {
            if (rating >= 0) {
                movieWiseRatings.computeIfAbsent(movie, v -> new ArrayList<>()).add(rating);
            }
        }

        /**
         * Finds the movie average rating.
         *
         * @param movie represents movie name.
         * @return movie rating.
         */
        @Override
        public double getAverageRating(String movie) {
            return movieWiseRatings.get(movie).stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        }

        /**
         * Used to find number of ratings given.
         *
         * @param movie represents movie name.
         * @return how many ratings received.
         */
        @Override
        public int getRatingCount(String movie) {
            List<Double> ratings = movieWiseRatings.get(movie);
            return ratings != null ? ratings.size() : 0;
        }

        @Override
        public void print() {
            for (String s : movieWiseRatings.keySet()) {
                System.out.println(movieWiseRatings.get(s));
            }
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingCollector {
        // This is an input. Make note of this rating.  Rating can be a double number between 0 and 100.
        void putNewRating(String movie, double rating);

        // Get the average rating
        double getAverageRating(String movie);

        // Get the total number of ratings received for the movie
        int getRatingCount(String movie);

        void print();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingCollector stats = new RatingCollectorImpl();
            final Set<String> movies = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                movies.add(symbol);
                final double price = Double.parseDouble(tokens[1]);

                stats.putNewRating(symbol, price);

            }

            for (String movie : movies) {
                System.out.println(
                        String.format("%s %.4f %d", movie, stats.getAverageRating(movie), stats.getRatingCount(movie)));
            }

            stats.print();
        }
        scanner.close();

    }
}