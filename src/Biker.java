import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * @author Sathish Gopalakrishnan This class maintains information about a biker
 *         (in the Tour de France). It contains the biker's name and a map <yy,
 *         speed>. The map stores the biker's average speed for year yy.
 * 
 */
public class Biker {
    private String lastName;
    private String firstName;

    // This map maintains the average speed for different years.
    // The key is the year and the value is the biker's speed for that year.
    // Also notice the use of the Integer and Double classes in place of
    // the primitive int and double types.
    // This is a SortedMap, so information can be retrieved in sorted order
    // of years.
    private SortedMap<Integer, Double> averageSpeeds;

    // this represents the number of years this biker has
    // participated in the Tour de France
    private int numEvents;

    /**
     * Constructor to create a new Biker object.
     * 
     * @param lastName
     *            The biker's last name.
     * @param firstName
     *            The biker's first name.
     * @param year
     *            A year the biker participated in the Tour de France.
     * @param avgSpeed
     *            The biker's average speed in the Tour de France in the given
     *            year.
     */
    public Biker(String lastName, String firstName, int year, double avgSpeed) {
        // Notice the use of the keyword _this_.
        this.lastName = lastName;
        this.firstName = firstName;

        // Set numEvents to 1
        numEvents = 1;

        averageSpeeds = new TreeMap<Integer, Double>();

        // Notice that we are passing int and double
        // in place of Int and Double.
        // This is an example of _autoboxing_ in Java.
        averageSpeeds.put(year, avgSpeed);
    }

    /**
     * Add biker statistics for another year at the Tour de France.
     * 
     * @param year
     *            The year for the new statistics.
     * @param avgSpeed
     *            The biker's average speed in the given year.
     */
    public void addPerformanceStats(int year, double avgSpeed) {
        // add a new entry only if there is no duplication
        // otherwise silently ignore
        if (!averageSpeeds.containsKey(year)) {
            // add the new data
            averageSpeeds.put(year, avgSpeed);
            // increment numEvents
            ++numEvents;
        }
    }

    /**
     * Return the biker's full name.
     * 
     * @return the biker's full name.
     */
    public String getName() {
        return new String(firstName + " " + lastName);
    }

    /**
     * A method to identify the best improvement that the biker had at the Tour
     * de France. If the biker's speed was x in year yy1 at the Tour de France
     * and y in year yy2 (yy2 > yy1, and yy2 was the next appearance after yy1)
     * then the improvement is y-x. This method returns the best improvement for
     * the biker.
     * 
     * @return The best improvement for the biker in the Tour de France. If
     *         there was never an improvement or if the biker participated only
     *         once then the improvement is 0.
     */
    public double getBestGain() {
        // TODO this is where you must add your code
        // the return statement is bogus for now
        // You need to implement this method correctly.
        
//        for (Map.Entry<Integer, Double> //thisEntry : averageSpeeds.entrySet()) {
//            // is Map sorted? yes
//            // thisEntry.getKey() //year
//            // thisEntry.getValue() //average speed for that year
//        }
        return 0.0;
    }

    /**
     * Returns the median speed among the biker's appearances at the Tour de
     * France.
     * 
     * @return The median speed from the set of the biker's appearances.
     */
    public double getMedianSpeed() {
        // TODO: return the median speed for this biker across the years
        // the return statement is bogus for now.
        // You need to implement this method correctly.
        List<Double> bikerSpeeds = new ArrayList<Double>();
        //ArrayList<Double> sortedBikerSpeeds = new ArrayList<Double>(); 
        for (int year : averageSpeeds.keySet()) {
            bikerSpeeds.add(averageSpeeds.get(year));
            //bikerSpeeds = averageSpeeds.get(year);
        }
        Collections.sort(bikerSpeeds);
        int midpoint = bikerSpeeds.size()/2;
        if (bikerSpeeds.size()%2 == 1) {
            return bikerSpeeds.get(midpoint);
        } else {
            return (bikerSpeeds.get(midpoint-1) + bikerSpeeds.get(midpoint))/2.0;
        }
    }

    /**
     * Returns the biker's speed given a participation.
     * 
     * @param yy
     *            The year for which the speed is desired.
     * @return The biker's average speed in year yy. If the biker did not
     *         participate in year yy or if the year is invalid then return 0.
     */
    public double getSpeedForYear(int yy) {
        if (yy < 0)
            return 0.0;
        if (averageSpeeds.containsKey(yy)) {
            return averageSpeeds.get(yy);
        } else
            return 0.0;
    }

}
