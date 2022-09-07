package models;

public class Worker extends Person implements Registrable {
    private int totalCalls;

    public Worker(String name, String phone, String brithdate, String cpf) {
        super(name, phone, brithdate, cpf);
    }

    public int getTotalCalls() {
        return totalCalls;
    }

    public void startCall() {
        this.totalCalls += totalCalls;
    }

    @Override
    public String getInfo() {
        return "Worker's name: " + this.getName();
    }
}
