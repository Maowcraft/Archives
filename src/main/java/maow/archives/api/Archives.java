package maow.archives.api;

import maow.archives.data.Data;
import maow.archives.data.DataGroup;
import maow.archives.data.listener.Listener;
import maow.archives.data.listener.model.DataListenerModel;
import maow.archives.util.IOUtil;

// This whole library totally isn't over-engineered or anything, I swear!
/**
 * Simplified data storage API class. Handles listeners, models, and events for you.
 */
public class Archives {
    private static final DataListenerModel DATA_MODEL = new DataListenerModel();

    /**
     * Supply a {@link Listener} to the generic data model, is notified every time data is loaded or saved using this class.
     *
     * @param listener An instance of your listener.
     */
    public static void addListener(Listener listener) {
        DATA_MODEL.addListener(listener);
    }

    /**
     * Saves a {@link Data} object as a binary data file, also informs the data model of the changes.
     *
     * @param path File path and name to save data file to.
     */
    public static void saveData(Data data, String path) {
        IOUtil.writeObject(path, data);
        DATA_MODEL.saveData();
    }

    /**
     * Loads a {@link Data} from a binary data file, also informs the data model of the changes.<br>
     * <br>
     * If the specified file does not exist or if the object loaded from the file is not a Data, this will return an empty Data object.
     *
     * @param path File path and name to load data file from.
     */
    public static void loadData(String path) {
        Data data = IOUtil.readData(path);
        DATA_MODEL.loadData(data);
    }

    /**
     * Loads a {@link Data} directly from the Object, also informs the data model of the changes.
     *
     * @param data The data to load.
     */
    public static void loadData(Data data) {
        DATA_MODEL.loadData(data);
    }

    /**
     * Loads a {@link Data} from a binary data file to a {@link DataGroup} without informing the data model.<br>
     * Allows the user to load multiple Data files without overwriting each one.
     *
     * @param group The group to load the specified Data to.
     * @param dataKey The key for the Data in the group.
     * @param path File path and name to load data file from.
     */
    public static void loadDataToGroup(DataGroup group, String dataKey, String path) {
        Data data = IOUtil.readData(path);
        group.addData(dataKey, data);
    }
}
