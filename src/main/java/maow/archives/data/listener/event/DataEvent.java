package maow.archives.data.listener.event;

import maow.archives.data.Data;

/**
 * An event that stores a Data object in it's parameters, the data is set using a constructor parameter.
 */
public class DataEvent implements Event {
    private final Data data;

    public DataEvent(Data data) {
        this.data = data;
    }

    @Override
    public Object[] getParams() {
        return new Object[]{data};
    }
}
