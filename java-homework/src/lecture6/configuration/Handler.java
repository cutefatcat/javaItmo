package lecture6.configuration;

import java.util.List;

public abstract class Handler{
    protected String fileName;
    protected Handler(String fileName){
        this.fileName = fileName;
    }

    public static Handler getInstance(String fileName){
        if (fileName.endsWith(".xml")){
            return new XmlHandler(fileName);
        } else if (fileName.endsWith(".json")){
            return new JsonHandler(fileName);
        }
        return null;
    }

    public abstract List<ConfigItem> read();
    public abstract void write(List<ConfigItem> list);
}
