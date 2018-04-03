package lecture6.configuration;

import java.util.List;

public class XmlHandler extends Handler{
    public XmlHandler(String fileName){
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
