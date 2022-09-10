package models;

public class Student extends Person implements Registrable {
    private String registryStatus;
    private double grade;
    private int studentCalls;

    public Student(Double grade, String name, String phone, String birthdate, String cpf, String registryStatus) {
        super(name, phone, birthdate, cpf);
        this.grade = grade;
        setRegistryStatus(registryStatus);
    }

    public String getRegistryStatus() {
        return registryStatus;
    }

    public void setRegistryStatus(String registryStatus) {
        this.registryStatus = registryStatus;
    }

    public int getStudentCalls() {
        return studentCalls;
    }

    public void startCall() {
        this.studentCalls = ++studentCalls;
        this.setRegistryStatus("Atendimento Pedagógico");
    }

    @Override
    public String toString() {
        return String.format("Nome do Aluno: " + this.getName() + " | ID: " + this.getIdPerson() + " | CPF: " + this.getCpf());
    }
}
