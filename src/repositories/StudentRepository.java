package repositories;

import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentRepository {
   private static Scanner scanner = new Scanner(System.in);
   private static String studentName, studentPhone,studentBirthdate,studentCPF,studentRegistration,studentStatus;
   private static int studentGrade;

    public static int createStudent(List<Student> studentList, int id ){
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
        System.out.println("Qual o estado da matrícula aluno?");
        System.out.println("...");
        studentStatus = scanner.nextLine();
        Student student = new Student(studentGrade,studentName,studentPhone,studentBirthdate,studentCPF,studentStatus,id);
        studentList.add(student);
        return 0;
    }

    public int getStudentReg(String studentName,List<Student> studentList ) {
        System.out.println("~~ Verificar a Matrícula ~~");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Estado da matrícula de " + student.getName() + ": " + student.getRegistryStatus());
                student.startCall();
            }
        }
        System.out.println("Aluno não está registrado");
        return 0;
    }

    private int changeStudentReg(String studentName,List<Student> studentList) {
        System.out.println("~~ Mudar Estado Da Matrícula ~~");
        for (int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);
            if(student.getName().equalsIgnoreCase(studentName)){
                setStudentReg(student);
                System.out.println("Estado de matrícula do aluno " +student.getName() +" alterado com sucesso.");
                student.startCall();
            }else {
                System.out.println("Aluno não está registrado");
            }
        }
        return 0;
    }

    private void setStudentReg(Student student){
        do {
            System.out.println("Qual o estado de matrícula do aluno "+ student.getName() + "? (Ativo, Inativo, Irregular ou Atendimento Pedagógico)"+"\n..."
                   );
            studentRegistration = scanner.nextLine();
        }while (!(studentRegistration.equalsIgnoreCase("ativo")|| studentRegistration.equalsIgnoreCase("inativo")
                || studentRegistration.equalsIgnoreCase("irregular") || studentRegistration.equalsIgnoreCase("atendimento pedagógico") ||
                studentRegistration.equalsIgnoreCase("atendimento pedagogico")));
        student.setRegistryStatus(studentRegistration);
    }
    public void getStudentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getInfo());
        }
    }
}

