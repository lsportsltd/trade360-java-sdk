package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

/**
 * The {@code OutrightCompetition} class represents a competition in an outright sport.
 *
 * @param <T> the type of the events associated with the competition
 */
public class OutrightCompetition<T> {

    /**
     * The ID of the competition.
     */
    public int id;

    /**
     * The name of the competition.
     */
    public String name;

    /**
     * The type of the competition.
     */
    public int type;


    /**
     * The events associated with the competition.
     */
    public Iterable<T> events;
}