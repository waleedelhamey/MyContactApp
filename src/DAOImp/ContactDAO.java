package DAOImp;

import Beans.Contact;
import DAO.DAO;

import java.security.cert.CertPath;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO implements DAO {
    private Contact createContactPerson(ResultSet rs) {
        Contact p = new Contact();
        try {
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setNick_name(rs.getString("nick_name"));
            p.setAddress(rs.getString("address"));
            p.setHome_phone(rs.getString("home_phone"));
            p.setWork_phone(rs.getString("work_phone"));
            p.setCell_phone(rs.getString("cell_phone"));
            p.setEmail(rs.getString("email"));
            p.setBirthdate(rs.getDate("birthday").toString());
            p.setWeb_site(rs.getString("web_site"));
            p.setProfession(rs.getString("profession"));
        } catch (SQLException ex) {
        }
        return p;
    }
    public List<Contact> getAllContacts()  {
        List<Contact> allContacts = new ArrayList<>();
        try {
            String sql = "Select * from contact";
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Contact p = createContactPerson(rs);
                allContacts.add(p);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return allContacts;
    }
    public List<String> getAllNickName(){
        List<String> allNickNames = new ArrayList<>();
        String sql = new String("select nick_name from contact");
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String nick_name = rs.getString("nick_name");
                allNickNames.add(nick_name);
            }
            rs.close();
            stmt.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getCause());
        }
        return allNickNames;
    }
    public Contact getContactByID(int ID){
        Contact newContact = new Contact();
        String sql = new String("select * from contact where id= ?");
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                newContact = createContactPerson(rs);
            }
            rs.close();
            ps.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getCause());
        }
        return newContact;
    }
    public int insertContact(Contact iContact){
        String sql = "INSERT INTO contact (name, nick_name, address," +
                " home_phone, work_phone, cell_phone, email, birthday," +
                " web_site, profession) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result=-1;
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);

            // Setting the values
            stmt.setString(1, iContact.getName());
            stmt.setString(2, iContact.getNick_name());
            stmt.setString(3, iContact.getAddress());
            stmt.setString(4, iContact.getHome_phone());
            stmt.setString(5, iContact.getWork_phone());
            stmt.setString(6, iContact.getCell_phone());
            stmt.setString(7, iContact.getEmail());
            stmt.setDate(8, java.sql.Date.valueOf(iContact.getBirthdate()));
            stmt.setString(9, iContact.getWeb_site());
            stmt.setString(10, iContact.getProfession());

            // Executing the statement
            result = stmt.executeUpdate();
            stmt.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getCause());
        }
        return result;
    }
    public int deleteContactByName(String Name){
        String sql = "delete from contact where name like '%" +
                Name + "%'";
        int result=-1;
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            // Executing the statement
            result = stmt.executeUpdate();
            stmt.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getCause());
        }
        return result;
    }
    public int updateContactName(int ID,String Name){
        String sql = "update contact set name =? where id=?";
        int result=-1;
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,Name);
            stmt.setInt(2,ID);
            result = stmt.executeUpdate();
            stmt.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getCause());
        }
        return result;
    }
}
