package main;

import models.Professor;
import models.Registrable;
import models.Student;
import models.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String studentRegistration, studentName, studentCPF, studentPhone, studentBirthdate;
        String professorName,professorPhone,professorBirthdate,professorCPF;
        String workerName,workerPhone,workerBirthdate,workerCPF;
        int studentGrade=0;
        int option=0,optionRegister=0,optionRepository;
        List<Registrable> studentList = new ArrayList<>();
        List<Registrable> professorList = new ArrayList<>();
        List<Registrable> workerList = new ArrayList<>();

        System.out.println("~~Lab School Automatic System~~");
        System.out.println("Who are you?");
        name = scanner.nextLine();
        //Menu
        do {
            System.out.println("Whats your demand "+name+"?");
            System.out.println("1 - Register");
            System.out.println("2 - Student Registration Status");
            System.out.println("3 - Repositories");
            System.out.println("4 - Exit");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Register:");
                    System.out.println("1 - Student");
                    System.out.println("2 - Professor");
                    System.out.println("3 - Worker");
                    System.out.println("4 - Return");
                    optionRegister = Integer.parseInt(scanner.nextLine());
                    switch ( optionRegister){
                        case 1:
                            //Student Register
                            System.out.println("Registering a Student");
                            System.out.println("Whats the Student's name?");
                            studentName = scanner.nextLine();
                            System.out.println("Whats " + studentName +"'s registration status?" +
                                    " (Active, Inactive, Irregular or In Call).");
                             studentRegistration = scanner.nextLine();
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
                            Student student1 = new Student(studentRegistration,studentGrade,studentName, studentPhone,studentBirthdate,studentCPF);
                            studentList.add(student1);
                            option = 5;
                            break;
                        case 2:
                            // Professor Register
                            System.out.println("Registering a Professor");
                            System.out.println("Whats the Professor's name?");
                            professorName = scanner.nextLine();
                            System.out.println("Whats " + professorName +"'s phone?");
                            professorPhone = scanner.nextLine();
                            System.out.println("Whats " + professorName + "'s birthdate?(day/month/year)");
                            professorBirthdate = scanner.nextLine();
                            System.out.println("Whats " + professorName + "'s CPF?");
                            professorCPF = scanner.nextLine();
                            Professor professor1 = new Professor(professorName,professorPhone,professorBirthdate,professorCPF);
                            professorList.add(professor1);
                            System.out.println(professor1.getInfo());
                            option = 5;
                            break;
                        case 3:
                            //Worker Registration
                            System.out.println("Registering a Worker");
                            System.out.println("Whats the Worker's name?");
                            workerName = scanner.nextLine();
                            System.out.println("Whats " + workerName +"'s phone?");
                            workerPhone = scanner.nextLine();
                            System.out.println("Whats " + workerName + "'s birthdate?(day/month/year)");
                            workerBirthdate = scanner.nextLine();
                            System.out.println("Whats " + workerName + "'s CPF?");
                            workerCPF = scanner.nextLine();
                            Worker worker1 = new Worker(workerName,workerPhone,workerBirthdate,workerCPF);
                            professorList.add(worker1);
                            System.out.println(worker1.getInfo());
                            option = 5;
                            break;
                        case 4:
                            option = 5;
                            break;
                        default:
                            option = 6;
                            break;
                    }
                case 2:
                    //Student Registration Status
                    break;
                case 3:
                    //Repositories
                    System.out.println("Generate List of:");
                    System.out.println("1 - Student");
                    System.out.println("2 - Professor");
                    System.out.println("3 - Worker");
                    System.out.println("4 - Return to main menu");
                    optionRepository = Integer.parseInt(scanner.nextLine());
                    switch (optionRepository){
                        case 1:
                            for (int i = 0; i < studentList.size(); i++){
                                System.out.println(studentList.get(i).getInfo());
                        }
                            option = 5;
                            break;
                        case 2:
                            for (int i = 0; i < professorList.size(); i++){
                                System.out.println(professorList.get(i).getInfo());
                            }
                            option = 5;
                            break;
                        case 3:
                            for (int i = 0; i < workerList.size(); i++){
                                System.out.println(workerList.get(i).getInfo());
                            }
                            option = 5;
                            break;
                        case 4:
                            option=5;
                            break;
                        default :
                            option=6;
                            break;
                    }
                    break;
                case 4:
                    //Exit
                    System.out.println("Program Ending...");
                    break;
                default:
                    break;
            }
        }while (option > 4 || option <= 0);
        scanner.close();
    }

}
