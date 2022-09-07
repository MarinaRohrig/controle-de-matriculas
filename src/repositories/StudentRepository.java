package repositories;

import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentRepository {
   private static Scanner scanner = new Scanner(System.in);
   private static String studentName, studentPhone,studentBirthdate,studentCPF,studentRegistration,studentStatus;
   private static int studentGrade;

    public static int createStudent(List<Student> studentList, int id ){
        System.out.println("\n~~ Registering A student ~~");
        System.out.println("What is the students name?");
        System.out.println("...");
        studentName = scanner.nextLine();
        System.out.println("What is " + studentName +"'s phone number?");
        System.out.println("...");
        studentPhone = scanner.nextLine();
        System.out.println("What is " + studentName + "'s birthdate? (day/month/year)");
        System.out.println("...");
        studentBirthdate = scanner.nextLine();
        System.out.println("What is " + studentName + "'s CPF?");
        System.out.println("...");
        studentCPF = scanner.nextLine();
        System.out.println("What is " + studentName + "'s grade?");
        System.out.println("...");
        studentGrade = Integer.parseInt(scanner.nextLine());
        System.out.println("What is " + studentName + "'s registry status? (Active, Inactive, Irregular or In Call)");
        System.out.println("...");
        studentStatus = scanner.nextLine();
        Student student = new Student(studentGrade,studentName,studentPhone,studentBirthdate,studentCPF,studentStatus,id);
        studentList.add(student);
        return 0;
    }

    public int getStudentReg(String stdName,List<Student> studentList ) {
        System.out.println("~~ Verify A Student Registration Status ~~");
        for (int i = 0; i < studentList.size(); i++) {
            Student std = studentList.get(i);
            if (std.getName().equalsIgnoreCase(stdName)) {
                System.out.println("Registration Status for " + std.getName() + ": " + std.getRegistrationStatus());
                std.startCall();
            }
        }
        System.out.println("Student is not registered");
        return 0;
    }

    public int changeStudentReg(String stdName,List<Student> studentList) {
        System.out.println("~~ Change Student Registration Status ~~");
        for (int i=0; i<studentList.size(); i++){
            Student std = studentList.get(i);
            if(std.getName().equalsIgnoreCase(stdName)){
                setStudentReg(std);
                System.out.println("Changing registration status for student: " +std.getName());
                std.startCall();
            }else {
                System.out.println("Student's is not registered");
            }
        }
        return 0;
    }

    private void setStudentReg(Student std){
        do {
            System.out.println("Whats " + std.getName() + "'s registration status?" +
                    " (Active, Inactive, Irregular or In Call).");
            studentRegistration = scanner.nextLine();
        }while (!(studentRegistration.equalsIgnoreCase("active")|| studentRegistration.equalsIgnoreCase("inactive")
                || studentRegistration.equalsIgnoreCase("irregular") || studentRegistration.equalsIgnoreCase("in call")));
        std.setRegistrationStatus(studentRegistration);
    }
    public void getStudentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getInfo());
        }
    }
}

