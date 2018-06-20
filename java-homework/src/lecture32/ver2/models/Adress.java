package lecture32.ver2.models;

public class Adress {
    private Integer id;
    private String adress;
    private Integer ContactId;

    public Adress(Integer id, String adress, Integer ContactId){
        this.id = id;
        this.adress = adress;
        this.ContactId = ContactId;
    }
}
