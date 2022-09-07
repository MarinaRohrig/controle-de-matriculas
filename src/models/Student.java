package models;

public class Student extends Person implements Registrable {
    private String registrationStatus;
    private int grade;
    private int calls = 0;

    public Student ( int grade, String name, String phone, String birthdate, String cpf, String status, int idPerson ){
        super(name,phone,birthdate,cpf,idPerson);
        this.grade = grade;
        setRegistrationStatus(status);
        this.calls++;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
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
        return "Student Name: "+ this.getName() + "\n Student ID:" + this.getIdPerson() +"\nRegistration Status: " + this.getRegistrationStatus() + "\nGrade: " + this.getGrade() +
                "\nNumber of Calls: " + this.getCalls();
    }
}
