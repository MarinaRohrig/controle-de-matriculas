package models;

public class Professor extends Person implements Registrable{
    private String background;
    private String devArea;
    private String status;

    public Professor(String name, String phone, String birthdate, String cpf, String backgroud, String devArea, String status) {
        super(name, phone, birthdate, cpf);
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
    public String toString() {
        return String.format ("Nome do Professor: "+ this.getName() + " | ID: " + this.getIdPerson() +" | CPF: " +this.getCpf());
    }
}
