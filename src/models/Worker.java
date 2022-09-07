package models;

public class Worker extends Person implements Registrable {
    private int totalCalls;

    public Worker(String name, String phone, String birthdate, String cpf,int idPerson) {
        super(name, phone, birthdate, cpf, idPerson);
    }

    public int getTotalCalls() {
        return totalCalls;
    }

    public void startCall() {
        this.totalCalls += totalCalls;
    }

    @Override
    public String getInfo() {
        return "Worker's name: " + this.getName() + "\nWorker's Phone: "+ this.getPhone() +"\nWorker's Birthdate: " + this.getBirthdate() +
                "\nWorker's CPF: " + this.getCpf();
    }
}
