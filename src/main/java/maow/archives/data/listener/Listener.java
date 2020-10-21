package maow.archives.data.listener;

import maow.archives.data.listener.event.Event;
import maow.archives.data.listener.model.ListenerModel;

/**
 * Basic Listener class, when added to a {@link ListenerModel}, is notified of events by the model.
 */
public abstract class Listener {
    /**
     * Creates a Listener and adds it to the specified model.
     *
     * @param model The model to add this Listener to immediately.
     */
    public Listener(ListenerModel model) {
        model.addListener(this);
    }

    public Listener() {}

    /**
     * Called whenever the listener model notifies all of it's listeners.<br>
     * <br>
     *
     *
     * @param event An Event instance, can be checked with an if & instanceof statement for the specific type of Event.
     */
    public abstract void listen(Event event);
}
