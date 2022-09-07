package models;

public class Student extends Person implements Registrable {
    private String registration;
    private int grade;
    private int calls = 0;

    public Student ( int grade, String name, String phone, String brithdate, String cpf ){
        super(name,phone,brithdate,cpf);
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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCalls() {
        return calls;
    }

    public void startCall() {
        this.calls += calls;
    }

    @Override
    public String getInfo() {
        return "Student Name: "+ this.getName() + "\nRegistration Status: " + this.getRegistration() + "\nGrade: " + this.getGrade() +
                "\nNumber of Calls: " + this.getCalls();
    }
}
