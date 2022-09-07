package repositories;

import models.Professor;
import models.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorRepository {
    private static Scanner scanner = new Scanner(System.in);
    private  static String professorName,professorPhone,professorBirthdate,professorCPF, background, devArea, status;
     private static int select=0, quantityProfessor;

    public static int createProfessor(List<Professor> professorList, int idPerson){
        System.out.println("\n~~ Registering A Professor ~~");
        System.out.println("What is the professors name?");
        System.out.println("...");
        professorName = scanner.nextLine();
        System.out.println("What is " + professorName +"'s phone number?");
        System.out.println("...");
        professorPhone = scanner.nextLine();
        System.out.println("What is " + professorName + "'s birthdate? (day/month/year)");
        System.out.println("...");
        professorBirthdate = scanner.nextLine();
        System.out.println("What is " + professorName + "'s CPF?");
        System.out.println("...");
        professorCPF = scanner.nextLine();
        System.out.println("What is "+professorName+"'s background? (Incomplete Graduation, Complete Graduation, Masters, Doctorate)");
        System.out.println("...");
        background = scanner.nextLine();
        System.out.println("What is the development area " + professorName + "'s works in? (Front-End, Back-End or Full-Stack)");
        System.out.println("...");
        devArea = scanner.nextLine();
        System.out.println("What is the status for " + professorName + "? (Active or Inactive)");
        System.out.println("...");
        status = scanner.nextLine();
        Professor professor1 = new Professor(professorName,professorPhone,professorBirthdate,professorCPF,idPerson,background,devArea,status );
        professorList.add(professor1);
        return 0;
    }

    public static int getProfessorStatus(String status,List<Professor> professorList ) {
        System.out.println("\n~~ Verifying All Professors Status ~~");
        quantityProfessor=0;
        for (int i = 0; i < professorList.size(); i++) {
            Professor professor = professorList.get(i);
            if (professor.getStatus().equalsIgnoreCase(status)) {
                System.out.println(professor.getInfo());
                quantityProfessor++;
            }
        }
        if (quantityProfessor == 0){
            System.out.println("There are no professor for this status");
        }
        return 0;
    }

    public static int getDevArea (List<Professor> professorList){
        do {
            quantityProfessor=0;
            System.out.println("\n~~ Professors Report For Development Area ~~");
            System.out.println("Select an area:");
            System.out.println("1 - Front-End");
            System.out.println("2 - Back-End ");
            System.out.println("3 - Full-Stack");
            System.out.println("4 - All");
            System.out.println("0 - Return");
            System.out.println("...");
            int select = Integer.parseInt(scanner.nextLine());
        switch(select){
            case 0:
                return 0;
            case 1:
                System.out.println("\n~~ Showing Professors That Work In Front-End ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Front-End")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("There are no professor for this area");
                }
                break;
            case 2:
                System.out.println("\n~~ Showing Professors That Work In Back-End ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Back-End")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("There are no professor for this area");
                }
                break;
            case 3:
                System.out.println("\n~~ Showing Professors That Work In Full-Stack ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Full-Stack")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("There are no professor for this area");
                }
                break;
            case 4:
                System.out.println("\n~~ Showing All Professors ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    System.out.println(professor.getInfo());
                    quantityProfessor++;
                }
                if (quantityProfessor == 0){
                    System.out.println("There are no professor registered");
                }
                break;
            default:
                break;
        }
        }while (select !=0);
        return 0;
    }
}
