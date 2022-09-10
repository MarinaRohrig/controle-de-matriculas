package repositories;

import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static String studentName, studentPhone, studentBirthdate, studentCPF, studentRegistration;
    private static double studentGrade;
    private static int quantityStudent = 0;

    public static int createStudent(List<Student> studentList) {
        System.out.println("\n~~ Cadastro de Aluno ~~");
        System.out.println("Qual o nome do aluno?");
        System.out.println("...");
        studentName = scanner.nextLine();
        System.out.println("Qual o número de telefone do aluno?");
        System.out.println("...");
        studentPhone = scanner.nextLine();
        System.out.println("Qual a data de nascimento do aluno? (dia/mês/ano)");
        System.out.println("...");
        studentBirthdate = scanner.nextLine();
        System.out.println("Qual o CPF do aluno?");
        System.out.println("...");
        studentCPF = scanner.nextLine();
        do {
            System.out.println("Qual a nota aluno? (Ex. 2.2)");
            System.out.println("...");
            studentGrade = Double.parseDouble(scanner.nextLine());
        } while (studentGrade < 0 || studentGrade > 10);
        System.out.println("Qual o estado da matrícula aluno? (Ativo, Irregular ou Inativo)");
        System.out.println("...");
        studentRegistration = scanner.nextLine();
        Student student = new Student(studentGrade, studentName, studentPhone, studentBirthdate, studentCPF, studentRegistration);
        studentList.add(student);
        return 0;
    }

    public static void studentReport(List<Student> studentList) {
        int select;
        if (studentList.isEmpty()) {
            System.out.println("Não existe aluno cadastrado");
            return;
        }
        do {
            quantityStudent = 0;
            System.out.println("\n~~ Relatório de Alunos ~~");
            System.out.println("Digite uma opção:");
            System.out.println("1 - Ativos");
            System.out.println("2 - Irregulares");
            System.out.println("3 - Inativos");
            System.out.println("4 - Em Atendimento Pedagógico");
            System.out.println("5 - Aluno Com Mais Atendimento Pedagógico");
            System.out.println("6 - Todos Os Alunos");
            System.out.println("0 - Voltar");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("Voltando para o menu inicial");
                    return;
                case 1:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("ativo")) {
                            System.out.println("Alunos Ativos");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (i == studentList.size() - 1 && quantityStudent == 0) {
                            System.out.println("Não existe aluno com esse estado");
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("irregular")) {
                            System.out.println("Alunos Irregulares");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (i == studentList.size() - 1 && quantityStudent == 0) {
                            System.out.println("Não existe aluno com esse estado");
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("inativo")) {
                            System.out.println("Alunos Inativos");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (i == studentList.size() - 1 && quantityStudent == 0) {
                            System.out.println("Não existe aluno com esse estado");
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("atendimento pedagogico")
                                || student.getRegistryStatus().equalsIgnoreCase("atendimento pedagógico")) {
                            System.out.println("Alunos Em Atendimento Pedagógico");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (i == studentList.size() - 1 && quantityStudent == 0) {
                            System.out.println("Não existe aluno com esse estado");
                        }
                    }
                    break;
                case 5:
                    getMostCalls(studentList);
                    break;
                case 6:
                    getStudentList(studentList);
                    break;
                default:
                    break;
            }
        } while (select != 0);
    }

    public static int changeStudentReg(String studentName, List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Não existe aluno cadastrado");
            return 0;
        }
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getName().equalsIgnoreCase(studentName)) {
                setStudentReg(student);
                System.out.println("Estado de matrícula do aluno " + student.getName() + " alterado com sucesso.\n");
                quantityStudent++;
            }
            if (i == studentList.size() - 1 && quantityStudent == 0) {
                System.out.println("Aluno não está cadastrado");
            }
        }
        return -1;
    }

    private static void setStudentReg(Student student) {
        String studentReg;
        do {
            System.out.println("Qual o estado de matrícula do aluno? (Ativo, Inativo, Irregular) " + "\n..."
            );
            studentReg = scanner.nextLine();
        } while (!(studentReg.equalsIgnoreCase("ativo") || studentReg.equalsIgnoreCase("inativo")
                || studentReg.equalsIgnoreCase("irregular") || studentReg.equalsIgnoreCase("atendimento pedagógico")
                || studentReg.equalsIgnoreCase("atendimento pedagogico")));

        if (studentReg.equalsIgnoreCase("atendimento pedagógico")
                || studentReg.equalsIgnoreCase("atendimento pedagogico")) {
            student.startCall();
        }
        student.setRegistryStatus(studentReg);
    }

    public static int studentExists(List<Student> studentList, String studentName) {
        quantityStudent = 0;
        if (studentList.isEmpty()) {
            System.out.println("Não existe aluno cadastrado");
            return -2;
        }
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getName().equalsIgnoreCase(studentName)) {
                quantityStudent++;
                return i;
            }
            if (i == studentList.size() - 1 && quantityStudent == 0) {
                System.out.println("Estudante não cadastrado");
            }
        }
        return -2;
    }

    public static void getStudentList(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Não existe aluno cadastrado");
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    public static void getMostCalls(List<Student> studentList) {
        Student mostCallStudent = new Student(0.0, "Dev", "0", "0", "0", "0");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getStudentCalls() >= mostCallStudent.getStudentCalls()) {
                mostCallStudent = student;
            }
        }
        System.out.println(mostCallStudent + " | Quantidade de atendimentos: " + mostCallStudent.getStudentCalls());
    }
}

