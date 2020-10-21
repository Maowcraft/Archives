package maow.archives.data.listener.model;

import maow.archives.data.listener.Listener;
import maow.archives.data.listener.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * A listener model specifies when {@link Listener} should be notified, as well as storing all of it's registered listeners and other values.
 */
public class ListenerModel {
    protected final List<Listener> listeners;

    public ListenerModel() {
        this.listeners = new ArrayList<>();
    }

    /**
     * Register a listener with this model, this listener is then notified each time the {@link #notifyListeners(Event)} event in this class is called.
     *
     * @param listener The listener to register.
     */
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    /**
     * Notifies all {@linkplain Listener}s with an attached {@link Event}, can only be called by the listener models.
     *
     * @param event The Event to send to the Listener.
     */
    protected void notifyListeners(Event event) {
        for (Listener listener : listeners) {
            listener.listen(event);
        }
    }
}
