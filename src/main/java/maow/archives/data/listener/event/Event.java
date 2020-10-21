package maow.archives.data.listener.event;

/**
 * Generic Listener event interface.
 */
public interface Event {
    /**
     * Specify a list of parameters for this Event that other classes can use.<br>
     * <br>
     * For a {@link maow.archives.data.listener.Listener} to access the parameters of an Event,
     * it must call this method from the instance of the Event in a Listener's {@link maow.archives.data.listener.Listener#listen(Event)} method.<br>
     * <br>
     * If a parameters value is not set by the Event's constructor (which you must specify yourself), then the parameters will be fixed.<br>
     * Certain Event subclasses, such as {@link DataEvent}, already specify a constructor parameter for this method.<br>
     * A constructor parameter is not necessary if this Event is being used as a marker.
     *
     * @return An array of objects, containing the Event's parameters.
     */
    Object[] getParams();
}
