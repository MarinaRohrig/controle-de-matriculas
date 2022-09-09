package models;

public class Student extends Person implements Registrable {
    private String registryStatus;
    private int grade;
    private int calls = 0;

    public Student(int grade, String name, String phone, String birthdate, String cpf, String registryStatus) {
        super(name, phone, birthdate, cpf);
        this.grade = grade;
        setRegistryStatus(registryStatus);
        if (registryStatus.equalsIgnoreCase("Atendimento Pedagógico")) {
            this.calls++;
        }
    }

    public String getRegistryStatus() {
        return registryStatus;
    }

    public void setRegistryStatus(String registryStatus) {
        this.registryStatus = registryStatus;
    }

    public int getGrade() {
        return grade;
    }

    public int getCalls() {
        return calls;
    }

    public void startCall() {
        this.calls += calls;
        this.setRegistryStatus("Atendimento Pedagógico");
    }

    @Override
    public String toString() {
        return String.format("Nome do Aluno: " + this.getName() + " | ID: " + this.getIdPerson() + " | CPF: " + this.getCpf());
    }
}
