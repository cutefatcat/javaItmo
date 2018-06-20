package lecture32.ver2.models;

public class Phonenumber {
    private Integer id;
    private String phonenumber;
    private Integer ContactId;

    public Phonenumber(Integer id, String phonenumber, Integer ContactId){
        this.id = id;
        this.phonenumber = phonenumber;
        this.ContactId = ContactId;
    }
}
