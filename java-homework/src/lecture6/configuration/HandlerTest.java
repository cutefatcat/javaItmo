package lecture6.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Pеализовать простое средство для считывания и записи информации из конфигурационных файлов.
 Реализацию механизмов чтения/записи файла опустим, чтобы сосредоточить внимание на структере кода
 Ханние данных в файле в формате ключ:значение

 За работу с каждым типом файла будет отвечать отдельный класс (например, XmlHandler, JsonHandler и тд),
 в родительском классе будет реализован метод getInstanse(), он, в зависимости от переданного в него имени файла,
 будет определять, к какому типу он относится и возвращать объект! соответствующего класса
 (например, return new XmlHandler(), return new JsonHandler() и тд).

 Попробовать сделать нужно всем! Вопросы задавайте
 */
public class HandlerTest {
    public static void main(String[] args) {
        //в зависимости от имени возращает конкр объект и потом вызываем методы рид и райт
        List<ConfigItem> data = new ArrayList<>();
        String xmlFile = "test.xml";
        String jsonFile = "test.json";
        String unknownFile = "test.unknown";
        if (Handler.validateFileType(xmlFile)) {
            Handler xmlHandler = Handler.getInstance("test.xml");
            xmlHandler.read();
            xmlHandler.write(data);
        }

        if (Handler.validateFileType(jsonFile)) {
            Handler jsonHandler = Handler.getInstance(jsonFile);
            jsonHandler.read();
            jsonHandler.write(data);
        }

        if (Handler.validateFileType(unknownFile)){
            Handler unknownHandler = Handler.getInstance(unknownFile);
            unknownHandler.read();
            unknownHandler.write(data);
        }
    }
}

