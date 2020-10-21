package maow.archives.data.listener.model;

import maow.archives.data.Data;
import maow.archives.data.listener.event.DataLoadedEvent;
import maow.archives.data.listener.event.DataSavedEvent;

/**
 * ListenerModel made to store Data objects, notifies listeners whenever data is saved or loaded.
 */
public class DataListenerModel extends ListenerModel {
    private Data data;

    public void loadData(Data data) {
        this.data = data;
        this.notifyListeners(new DataLoadedEvent(this.data));
    }

    public void saveData() {
        this.notifyListeners(new DataSavedEvent(this.data));
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
