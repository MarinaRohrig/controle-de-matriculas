package models;

public abstract class Person {
    private String name;
    private String phone;
    private String birthdate;
    private String cpf;

    private static int lastID;
    private int idPerson = 0;

    public Person(String name, String phone, String birthdate, String cpf) {
        this.setName(name);
        this.setPhone(phone);
        this.setBirthdate(birthdate);
        this.setCpf(cpf);
        this.idPerson = ++lastID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdPerson() {
        return idPerson;
    }
    
}
