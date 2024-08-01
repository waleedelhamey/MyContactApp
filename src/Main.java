import Beans.Contact;
import DAOImp.ContactDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> allContacts = new ArrayList<>();
        List<String> allNickNames = new ArrayList<>();
        int result;
        ContactDAO dao = new ContactDAO();

        allContacts = dao.getAllContacts();
        //System.out.println(allContacts);

        allNickNames = dao.getAllNickName();
        //System.out.println(allNickNames);

        //Contact c = dao.getContactByID(9);
        //System.out.println(c);
        //result = dao.deleteContactByName("Waleed");
        //checkExecution(result);
//        Contact addedContact = new Contact(	1,"Bruce Wayne",
//                "batman","XYZ Batcave","9876543210","6278287326",
//                "9182872363","batman@gmail.com","1976-02-03",
//                "batblog.com","Super Hero");
//
//        result = dao.insertContact(addedContact);
        String name = "Salma";
        result = dao.updateContactName(3,name);
        checkExecution(result);

    }
    public static void checkExecution(int result){
        if(result>0){
            System.out.println("Execution done successfully");
            return ;
        }
        System.out.println("Execution had a problem");


    }
}