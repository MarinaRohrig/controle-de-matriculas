package models;

public class Worker extends Person implements Registrable {
    private int calls = 0;

    public Worker(String name, String phone, String birthdate, String cpf) {
        super(name, phone, birthdate, cpf);
    }

    public int getCalls() {
        return calls;
    }

    public void startCall() {
        this.calls += calls;
    }

    @Override
    public String toString() {
        return String.format("Nome do Pedagogo: " + this.getName() + " | ID: " + this.getIdPerson() + " | CPF: " + this.getCpf());
    }
}
