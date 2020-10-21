package maow.archives.data.listener.event;

import maow.archives.data.Data;

/**
 * An event that is called whenever a Data object is loaded.
 *
 * @see maow.archives.data.listener.model.DataListenerModel
 * @see maow.archives.data.listener.event.DataEvent
 */
public class DataSavedEvent extends DataEvent {
    public DataSavedEvent(Data data) {
        super(data);
    }
}
