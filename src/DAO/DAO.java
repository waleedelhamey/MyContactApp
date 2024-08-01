package DAO;

import Beans.Contact;

import java.util.List;

public interface DAO {
    public static final String DB_URL =
            "jdbc:mysql://localhost:3306/adressbook";
    public static final String DRIVER =
            "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "root";
    public List<Contact> getAllContacts();
    public List<String> getAllNickName();
    public Contact getContactByID(int ID);
    public int insertContact(Contact iContact);
    public int deleteContactByName(String Name);
    public int updateContactName(int ID,String Name);
}
