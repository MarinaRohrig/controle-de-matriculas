package main;

import models.Student;

public class TestProgram {
    public static void main(String[] args) {
        Student student1 = new Student("Ativo",8,"Marina","(88)8888291",
                "27/06/1997",
                "200000");

        System.out.println("O aluno " + student1.getName() +" obteve a nota " +student1.getGrade() + " e está " +
                "com a matrícula " + student1.getRegistration());

    }
}
