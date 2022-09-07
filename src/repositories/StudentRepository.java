package repositories;

import models.Registrable;
import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentRepository {
    Scanner scanner = new Scanner(System.in);
   private String studentName,studentRegistration,studentPhone,studentBirthdate,studentCPF;
    private int studentGrade;

    public int createStudent(List<Student> studentList, int id ){
        //Student Register
        System.out.println("Registering a Student");
        System.out.println("Whats the Student's name?");
        studentName = scanner.nextLine();
        do {
            System.out.println("Whats " + studentName + "'s grade? (0-10)");
            studentGrade = Integer.parseInt(scanner.nextLine());
        }while (studentGrade > 10 || studentGrade < 0);
        System.out.println("Whats " + studentName +"'s phone?");
        studentPhone = scanner.nextLine();
        System.out.println("Whats " + studentName + "'s birthdate?(day/month/year)");
        studentBirthdate = scanner.nextLine();
        System.out.println("Whats " + studentName + "'s CPF?");
        studentCPF = scanner.nextLine();
        Student student = new Student(studentGrade,studentName, studentPhone,studentBirthdate,studentCPF, id);
        setStudentReg(student);
        studentList.add(student);
        return 0;
    }

    public int getStudentReg(String stdName,List<Student> studentList ) {
        System.out.println("~~ Verify Student Registration Status ~~");
        for (int i = 0; i < studentList.size(); i++) {
            Student std = studentList.get(i);
            if (std.getName().equalsIgnoreCase(stdName)) {
                System.out.println("Registration Status for " + std.getName() + ": " + std.getRegistration());
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
        std.setRegistration(studentRegistration);
    }
    public void getStudentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getInfo());
        }
    }
}

