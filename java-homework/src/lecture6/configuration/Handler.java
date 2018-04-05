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
        } //else {
            return new JsonHandler(fileName);
        //}
    }

    public static boolean validateFileType(String fileName){
//        if (fileName.endsWith(".xml") || fileName.endsWith(".json")){
//            return true;
//        } else{
//            return false;
//        }
        return fileName.endsWith(".xml") || fileName.endsWith(".json");
    }

    public abstract List<ConfigItem> read();
    public abstract void write(List<ConfigItem> list);
}
