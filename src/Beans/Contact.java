package Beans;

public class Contact {
    private int id;
    private String name;
    private String nick_name;
    private String address;
    private String home_phone;
    private String work_phone;
    private String cell_phone;
    private String email;
    private String birthdate;
    private String web_site;
    private String profession;

    public Contact() {
    }

    public Contact(int id, String name, String nick_name, String address, String home_phone, String work_phone, String cell_phone, String email, String birthdaty, String web_site, String profession) {
        this.id = id;
        this.name = name;
        this.nick_name = nick_name;
        this.address = address;
        this.home_phone = home_phone;
        this.work_phone = work_phone;
        this.cell_phone = cell_phone;
        this.email = email;
        this.birthdate = birthdaty;
        this.web_site = web_site;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", address='" + address + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", work_phone='" + work_phone + '\'' +
                ", cell_phone='" + cell_phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdaty='" + birthdate + '\'' +
                ", web_site='" + web_site + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdaty) {
        this.birthdate = birthdaty;
    }

    public String getWeb_site() {
        return web_site;
    }

    public void setWeb_site(String web_site) {
        this.web_site = web_site;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
