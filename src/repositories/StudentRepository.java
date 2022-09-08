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
        System.out.println("Qual o n�mero de telefone do aluno?");
        System.out.println("...");
        studentPhone = scanner.nextLine();
        System.out.println("Qual a data de nascimento do aluno? (dia/m�s/ano)");
        System.out.println("...");
        studentBirthdate = scanner.nextLine();
        System.out.println("Qual o CPF do aluno?");
        System.out.println("...");
        studentCPF = scanner.nextLine();
        System.out.println("Qual a nota aluno?");
        System.out.println("...");
        studentGrade = Integer.parseInt(scanner.nextLine());
        System.out.println("Qual o estado da matr�cula aluno? (Ativo, Irregular ou Inativo)");
        System.out.println("...");
        studentStatus = scanner.nextLine();
        Student student = new Student(studentGrade,studentName,studentPhone,studentBirthdate,studentCPF,studentStatus,id);
        studentList.add(student);
        return 0;
    }

    public int getStudentReg(String studentName,List<Student> studentList ) {
        System.out.println("~~ Verificar a Matr�cula ~~");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Estado da matr�cula de " + student.getName() + ": " + student.getRegistryStatus());
                student.startCall();
            }
        }
        System.out.println("Aluno n�o est� registrado");
        return 0;
    }

    public static int changeStudentReg(String studentName, List<Student> studentList) {
        if (studentList.isEmpty()){
            System.out.println("N�o existe aluno registrado.");
            return 0;
        }
        for (int i=0; i<studentList.size(); i++){
            Student student = studentList.get(i);
            if(student.getName().equalsIgnoreCase(studentName)){
                setStudentReg(student);
                System.out.println("Estado de matr�cula do aluno " +student.getName() +" alterado com sucesso.\n");
                student.startCall();
            }else {
                System.out.println("Aluno n�o est� registrado.");
            }
        }
        return 0;
    }

    private static void setStudentReg(Student student){
        do {
            System.out.println("Qual o estado de matr�cula do aluno "+ student.getName() + "? (Ativo, Inativo, Irregular ou Atendimento Pedag�gico) "+"\n..."
                   );
            studentRegistration = scanner.nextLine();
        }while (!(studentRegistration.equalsIgnoreCase("ativo")|| studentRegistration.equalsIgnoreCase("inativo")
                || studentRegistration.equalsIgnoreCase("irregular") || studentRegistration.equalsIgnoreCase("atendimento pedag�gico")
        || studentRegistration.equalsIgnoreCase("atendimento pedagogico")));
        if (studentRegistration.equalsIgnoreCase("atendimento pedag�gico")
                || studentRegistration.equalsIgnoreCase("atendimento pedagogico")){
            student.startCall();
        }
        student.setRegistryStatus(studentRegistration);
    }
    public static void getStudentList(List<Student> studentList) {
        if (studentList.isEmpty()){
            System.out.println("N�o existe aluno registrado.");
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getInfo());
        }
    }
}

