package maow.archives.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores a map of Data objects, used to load multiple Data objects without adding them to the data model directly, thereby overwriting the previous Data object.
 */
public class DataGroup {
    private final Map<String, Data> data;

    public DataGroup() {
        this.data = new HashMap<>();
    }

    public DataGroup addData(String key, Data data) {
        this.data.put(key, data);
        return this;
    }

    public Data getData(String key) {
        if (!this.data.containsKey(key)) {
            throw new RuntimeException("DataGroup does not contain data with key '" + key + "'.");
        }
        return this.data.get(key);
    }

    public Collection<Data> getAllData() { return this.data.values(); }
}
