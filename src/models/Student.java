package models;

public class Student extends Person implements Registrable {
    private String registration;
    private int grade;
    private int calls = 0;

    public Student ( int grade, String name, String phone, String birthdate, String cpf, int idPerson ){
        super(name,phone,birthdate,cpf,idPerson);
        this.grade = grade;
        this.calls++;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getGrade() {
        return grade;
    }

    public int getCalls() {
        return calls;
    }

    public void startCall() {
        this.calls += calls;
    }

    @Override
    public String getInfo() {
        return "Student Name: "+ this.getName() + "\n Student ID:" + this.getIdPerson() +"\nRegistration Status: " + this.getRegistration() + "\nGrade: " + this.getGrade() +
                "\nNumber of Calls: " + this.getCalls();
    }
}
