package models;

public class Worker extends Person implements Registrable {
    private int call=-1;

    public Worker(String name, String phone, String birthdate, String cpf,int idPerson) {
        super(name, phone, birthdate, cpf, idPerson);
    }

    public int getCall() {
        return call;
    }

    public void startCall() {
        this.call += call;
    }

    @Override
    public String getInfo() {
        return "Nome do Pedagogo: " + this.getName() + " | Telefone: "+ this.getPhone() +" | Data de Nascimento: " + this.getBirthdate() +
                " | CPF: " + this.getCpf();
    }
}
