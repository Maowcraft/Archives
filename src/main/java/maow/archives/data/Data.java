package maow.archives.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic serializable data object, stores a map of fields.
 */
public class Data implements Serializable {
    private final Map<String, Object> fields;

    public Data() {
        this.fields = new HashMap<>();
    }

    public Data addField(String key, Object value) {
        this.fields.put(key, value);
        return this;
    }

    public Object getField(String key) {
        if (!this.fields.containsKey(key)) {
            throw new RuntimeException("Data does not contain field with key '" + key + "'.");
        }
        return this.fields.get(key);
    }

    public Map<String, Object> getFields() {
        return this.fields;
    }
}
