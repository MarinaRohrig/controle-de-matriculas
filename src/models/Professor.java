package models;

public class Professor extends Person implements Registrable{
    private String background;
    private String devArea;
    private String status;

    public Professor(String name, String phone, String brithdate, String cpf) {
        super(name, phone, brithdate, cpf);
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDevArea() {
        return devArea;
    }

    public void setDevArea(String devArea) {
        this.devArea = devArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return "Professor's name: " + this.getName() +"\n Professor's area:";
    }
}
