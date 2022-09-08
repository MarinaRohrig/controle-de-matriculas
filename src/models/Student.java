package models;

public class Student extends Person implements Registrable {
    private String registryStatus;
    private int grade;
    private int calls = 0;

    public Student ( int grade, String name, String phone, String birthdate, String cpf, String registryStatus, int idPerson ){
        super(name,phone,birthdate,cpf,idPerson);
        this.grade = grade;
        setRegistryStatus(registryStatus);
       if (registryStatus.equalsIgnoreCase("Atendimento Pedagógico")){
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
    }

    @Override
    public String getInfo() {
        return "Nome do Aluno: "+ this.getName() + " | ID: " + this.getIdPerson() +" | CPF: " +this.getCpf() +"Qtd Atendimentos: " +this.getCalls();
    }
}
