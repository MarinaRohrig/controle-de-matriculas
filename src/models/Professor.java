package models;

public class Professor extends Person implements Registrable{
    private String background;
    private String devArea;
    private String status;

    public Professor(String name, String phone, String birthdate, String cpf,int idPerson, String backgroud, String devArea, String status) {
        super(name, phone, birthdate, cpf, idPerson);
        this.background = backgroud;
        this.devArea = devArea;
        this.status = status;
    }


    public String getDevArea() {
        return devArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return "Professor's Name: " + this.getName() + " | Phone: "+this.getPhone()+ " | Birthdate: "+this.getBirthdate()+" | CPF: " + this.getCpf() +
                " | Background: " + this.background +" | Development Area: " + this.getDevArea() + " | Status: " + this.getStatus();
    }
}
