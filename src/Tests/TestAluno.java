package Tests;

import models.Student;
import repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int select = 0;
        int id = 1;
        do{
            System.out.println("~~ Test For Student Class And Report ~~");
            System.out.println("Select an option:");
            System.out.println("1 - Registry");
            System.out.println("2 - Report");
            System.out.println("0 - Exit");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch(select){
                case 0:
                    System.out.println("Ending Program...");
                    break;
                case 1:
                    //registrar student
                    StudentRepository.createStudent(studentList, id);
                    System.out.println();
                    id++;
                    break;
                case 2:
                    do{
                        System.out.println();
                        System.out.println("~~ Report ~~");
                        System.out.println("Select a Report:");
                        System.out.println("1 - Status");
                        System.out.println("2 - Development Area ");
                        System.out.println("0 - Return");
                        System.out.println("...");
                        //implementar os reports

                    }while (select!=0);
                    select = -1;
                default:
                    break;
            }
        }while (select !=0);
        scanner.close();
    }
}
