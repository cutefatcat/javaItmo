package lecture32.ver2;

import lecture32.entity.Adress;
import lecture32.entity.Phonenumber;

import java.util.List;

public class Contact {
    private Integer id;
    private String name;
    private String surname;
    private String middlename;
    private String phonenumbers;
    private String address;
    private String description;

    List<Phonenumber> phonenumberList;
    List<Adress> adresses;
    //restriction- для того чтобы не дублировалось значение
    //sequence

    //задание все методы к новой схеме из 3х таблиц
    //можно смотреть транзакции

//в версии 2 нужно 2 табл номеров и адресов
    //orm. jpa - framework?

    public Contact(Integer id, String name, String phonenumbers){
        this.id = id;
        this.name = name;
        this.phonenumbers = phonenumbers;
    }


}
