package repositories;

import models.Student;
import models.Worker;

import java.util.List;
import java.util.Scanner;

public class StudentRepository {
   private static Scanner scanner = new Scanner(System.in);
   private static String studentName, studentPhone,studentBirthdate,studentCPF,studentRegistration,studentStatus;
   private static int studentGrade;

    public static int createStudent(List<Student> studentList){
        System.out.println("\n~~ Registrando Um Aluno ~~");
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
        System.out.println("Qual a nota aluno?");
        System.out.println("...");
        studentGrade = Integer.parseInt(scanner.nextLine());
        System.out.println("Qual o estado da matrícula aluno? (Ativo, Irregular ou Inativo)");
        System.out.println("...");
        studentStatus = scanner.nextLine();
        Student student = new Student(studentGrade,studentName,studentPhone,studentBirthdate,studentCPF,studentStatus);
        studentList.add(student);
        return 0;
    }

    public static int studentReport(List<Student> studentList){
        int select;
        if (studentList.isEmpty()){
            System.out.println("Não existe aluno cadastrado.");
            return 0;
        }
        do{
        int quantityStudent = 0;
        System.out.println("~~ Relatório de Alunos ~~");
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
                    System.out.println("Voltando para o menu inicial...");
                    return 0;
                case 1:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("ativo")){
                            System.out.println("Alunos Ativos");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (quantityStudent==0){
                            System.out.println("Não existe aluno cadastrado!");
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("irregular")){
                            System.out.println("Alunos Irregulares");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (quantityStudent==0){
                            System.out.println("Não existe aluno com esse estado.");
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("inativo")){
                            System.out.println("Alunos Inativos");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (quantityStudent==0){
                            System.out.println("Não existe aluno com esse estado.");
                         }
                     }
                    break;
                case 4:
                    for (int i = 0; i < studentList.size(); i++) {
                        Student student = studentList.get(i);
                        if (student.getRegistryStatus().equalsIgnoreCase("atendimento pedagogico")){
                            System.out.println("Alunos Em Atendimento Pedagógico");
                            System.out.println(studentList.get(i));
                            quantityStudent++;
                        }
                        if (quantityStudent==0){
                            System.out.println("Não existe aluno com esse estado.");
                        }
                    }
                    break;
                case 5:
                    getMostCalls(studentList);
                case 6:
                   getStudentList(studentList);
                    break;
                default:
                    break;
            }
        }while (select !=0);
        return 0;
    }

    public static int changeStudentReg(String studentName, List<Student> studentList) {
        if (studentList.isEmpty()){
            System.out.println("Não existe aluno registrado.");
            return 0;
        }
        for (int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);
            if(student.getName().equalsIgnoreCase(studentName)){
                setStudentReg(student);
                System.out.println("Estado de matrícula do aluno " +student.getName() +" alterado com sucesso.\n");
                student.startCall();
            }else {
                System.out.println("Aluno não está registrado.");
            }
        }
        return 0;
    }

    private static void setStudentReg(Student student){
        do {
            System.out.println("Qual o estado de matrícula do aluno? (Ativo, Inativo, Irregular) "+"\n..."
                   );
            studentRegistration = scanner.nextLine();
        }while (!(studentRegistration.equalsIgnoreCase("ativo")|| studentRegistration.equalsIgnoreCase("inativo")
                || studentRegistration.equalsIgnoreCase("irregular") || studentRegistration.equalsIgnoreCase("atendimento pedagógico")
        || studentRegistration.equalsIgnoreCase("atendimento pedagogico")));

        if (studentRegistration.equalsIgnoreCase("atendimento pedagógico")
                || studentRegistration.equalsIgnoreCase("atendimento pedagogico")){
            student.startCall();
        }
        student.setRegistryStatus(studentRegistration);
    }

    public static int studentExists(List<Student> studentList, String studentName){
        if (studentList.isEmpty()){
            System.out.println("Aluno não registrado, voltando para o menu inicial...");
            return -1;
        }
        for (int i=0; i < studentList.size(); i++){
            Student student = studentList.get(i);
            if (student.getName().equalsIgnoreCase(studentName)){
                return i;
            }
        }
        return -1;
    }
    public static void getStudentList(List<Student> studentList) {
        if (studentList.isEmpty()){
            System.out.println("Não existe aluno registrado.");
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }
    public static void getMostCalls(List<Student> studentList){
        Student mostcallStudent = new Student(0,"Dev","0","0","0","0");
        for (int i = 0; i < studentList.size(); i++){
            Student student = studentList.get(i);
            if (mostcallStudent.getCalls() >= mostcallStudent.getCalls()){
                mostcallStudent = mostcallStudent;
            }
        }
        System.out.println("Pedagogo com o maior número de atendimentos pedagógicos: "+mostcallStudent.getName() + " | Quantidade de atendimentos: "+mostcallStudent.getCalls());
    }
}

