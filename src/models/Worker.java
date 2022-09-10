package models;

public class Worker extends Person implements Registrable {
    private int workerCalls;

    public Worker(String name, String phone, String birthdate, String cpf) {
        super(name, phone, birthdate, cpf);
    }

    public int getWorkerCalls() {
        return workerCalls;
    }

    public void startCall() {
        this.workerCalls = ++workerCalls;
    }

    @Override
    public String toString() {
        return String.format("Nome do Pedagogo: " + this.getName() + " | ID: " + this.getIdPerson() + " | CPF: " + this.getCpf());
    }
}
