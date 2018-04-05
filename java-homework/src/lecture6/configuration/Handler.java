package lecture6.configuration;

import java.util.List;

public abstract class Handler{
    protected String fileName;
    protected Handler(String fileName){
        this.fileName = fileName;
    }

    public static Handler getInstance(String fileName){
        //вместо return null; - написать обработку исключения
        if (fileName.endsWith(".xml")){
            return new XmlHandler(fileName);
        } else if (fileName.endsWith(".json")){
            return new JsonHandler(fileName);
        }
        throw new IllegalArgumentException("Filename should ends with .xml or .json!");

        //вместо return null; - написать обработку исключения

    }

    public abstract List<ConfigItem> read();
    public abstract void write(List<ConfigItem> list);
}
