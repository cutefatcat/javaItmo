package lecture6.configuration;

import java.util.List;

public class JsonHandler extends Handler{
    public JsonHandler(String fileName){
        super(fileName);
    }

    @Override
    public List<ConfigItem> read() {
        return null;
    }

    @Override
    public void write(List<ConfigItem> list) {

    }
}
