import maow.archives.api.Archives;
import maow.archives.data.Data;
import maow.archives.data.DataGroup;
import maow.archives.data.listener.Listener;
import maow.archives.data.listener.event.DataLoadedEvent;
import maow.archives.data.listener.event.Event;

public class TestImplementation {
    public static String NAME = "Death and Destruction OwO";
    public static boolean COOL = true;

    public static void main(String[] args) {
        Data maowData = new Data().addField("name", "Maow").addField("cool", false);
        Data notMaowData = new Data().addField("name", "everyone but Maow").addField("cool", true);

        Archives.addListener(new Listener() {
            @Override
            public void listen(Event event) {
                if (event instanceof DataLoadedEvent) {
                    Data data = (Data) event.getParams()[0];
                    NAME = (String) data.getField("name");
                    COOL = (Boolean) data.getField("cool");
                }
            }
        });

        DataGroup group = new DataGroup();

        Archives.saveData(maowData, "maow_data.bin");
        Archives.saveData(notMaowData, "not_maow_data.bin");

        Archives.loadDataToGroup(group, "maow_data", "maow_data.bin");
        Archives.loadDataToGroup(group, "not_maow_data", "not_maow_data.bin");

        for (Data data : group.getAllData()) {
            Archives.loadData(data);
            System.out.println("Is " + NAME + " cool? : " + COOL);
        }
    }
}
