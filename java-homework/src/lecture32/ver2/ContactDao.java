package lecture32.ver2;

import lecture32.ver2.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ContactDao {
   // private JdbcTemplate jdbcTemplate
// часть с пары
    private final Connection con;
    public ContactDao(Connection con) {
        this.con = con;
    }
//
    public void save(Contact contact){
        assert contact != null;

        if (contact.getId() == null) {
            // INSERT
            try (PreparedStatement stmnt =
                         con.prepareStatement("INSERT INTO " + TABLE_NAME + " (id, name, address) " +
                                 "VALUES (?, ?, ?)")) {
                int id = nextId();

                stmnt.setInt(1, id);
                stmnt.setString(2, contact.getName());
                stmnt.setString(3, contact.getAddress());

                stmnt.executeUpdate();

                contact.setId(id);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            // UPDATE
            try (PreparedStatement stmnt =
                         con.prepareStatement("UPDATE " + TABLE_NAME + " SET name=?, address=? " +
                                 "WHERE id=?")) {

                stmnt.setString(1, contact.getName());
                stmnt.setString(2, contact.getAddress());
                stmnt.setInt(3, contact.getId());

                stmnt.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public Contact getById(Integer id){
        //String sql = "";
        if (id == null) {
            try (PreparedStatement stmnt =
                                        con.prepareStatement("SELECT * FROM CONTACT WHERE ID=?");                                "'") {
            } catch (SQLException e) {
                e.printStackTrace();
            }
//                int id = nextId();
//
//                stmnt.setInt(1, id);
//                stmnt.setString(2, contact.getName());
//                stmnt.setString(3, contact.getAddress());
//
//                stmnt.executeUpdate();
//
//                contact.setId(id);

            }}



   public void remoteById(Integer id){
        //if (contact.getId() == null) {
            try (PreparedStatement stmnt =
                         con.prepareStatement("DELETE * FROM CONTACT WHERE ID='?'")){
                stmnt.setString(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public List<Contact> findBy(){
        return
    }

    //часть с пары для подключ
    private void execUpdate(String sql, Contact contact){

    }
}
