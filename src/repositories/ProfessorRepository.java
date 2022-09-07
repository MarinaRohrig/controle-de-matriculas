package repositories;

import models.Professor;
import models.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorRepository {
    private static Scanner scanner = new Scanner(System.in);
    private  static String professorName,professorPhone,professorBirthdate,professorCPF, background, devArea, status;
     private static int select=0;

    public static int createProfessor(List<Professor> professorList){
        System.out.println("Registering a Professor");
        System.out.println("Whats the Professor's name?");
        professorName = scanner.nextLine();
        System.out.println("Whats " + professorName +"'s phone?");
        professorPhone = scanner.nextLine();
        System.out.println("Whats " + professorName + "'s birthdate?(day/month/year)");
        professorBirthdate = scanner.nextLine();
        System.out.println("Whats " + professorName + "'s CPF?");
        professorCPF = scanner.nextLine();
        System.out.println("Whats the "+professorName+"'s background? (Incomplete Graduation, Complete Graduation, Masters, Doctorate)");
        background = scanner.nextLine();
        System.out.println("Whats the development area" + professorName + "'s works? (Front-End, Back-End or Full-Stack)");
        devArea = scanner.nextLine();
        System.out.println("Whats the status for " + professorName + "'s (Active or Inactive)");
        status = scanner.nextLine();
        Professor professor1 = new Professor(professorName,professorPhone,professorBirthdate,professorCPF,background,devArea,status);
        professorList.add(professor1);


        return 0;

    }

    public static int getProfessorStatus(String status,List<Professor> professorList ) {
        System.out.println("~~ Verify Professor Registration Status ~~");
        for (int i = 0; i < professorList.size(); i++) {
            Professor professor = professorList.get(i);
            if (professor.getStatus().equalsIgnoreCase(status)) {
                System.out.println("Professor:" + professor.getName() + " ~ Status:  "+ professor.getStatus());
            }
        }
        return 0;
    }

    public static int getDevArea (List<Professor> professorList){
        do {
            System.out.println("~~ Relatory of Professor for Development Area~~");
            System.out.println("Select an Area:");
            System.out.println("1 - Front-End");
            System.out.println("2 - Back-End ");
            System.out.println("3 - Full-Stack");
            System.out.println("4 - All");
            System.out.println("0 - Return");
            int select = Integer.parseInt(scanner.nextLine());
        }while (select !=0);
        switch(select){
            case 0:
                return 0;
            case 1:
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Front-End")) {
                        System.out.println(professor.getInfo());
                    }
                }
                break;
            case 2:
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Back-End")) {
                        System.out.println(professor.getInfo());
                    }
                }
                break;
            case 3:
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Full-Stack")) {
                        System.out.println(professor.getInfo());
                    }
                }
                break;
            case 4:
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    System.out.println(professor.getInfo());
                }
                break;
            default:
                break;
        }
        return 0;
    }


}
