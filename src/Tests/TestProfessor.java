package Tests;

import models.Professor;
import repositories.ProfessorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProfessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Professor> professorList = new ArrayList<>();
        int select = 0;
        int option=0;
        do{
            System.out.println("~~ Test for Professor Class and Repository ~~");
            System.out.println("Select an option:");
            System.out.println("1 - Registry");
            System.out.println("2 - Repository");
            System.out.println("0 - Exit");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch(select){
                case 1:
                   ProfessorRepository.createProfessor(professorList);
                    break;
                case 2:
                    do{
                    System.out.println("~~ Repository ~~ ");
                    System.out.println("Select a Relatory:");
                    System.out.println("1 - Status");
                    System.out.println("2 - Category ");
                    System.out.println("0 - Return");

                    option = Integer.parseInt(scanner.nextLine());

                    switch (option) {
                        case 0:
                            select = (-1);
                            break;
                        case 1:
                            System.out.println("Inform the status (Active or Inactive)");
                            String status = scanner.nextLine();
                            ProfessorRepository.getProfessorStatus(status, professorList);
                            break;
                        case 2:
                            ProfessorRepository.getDevArea(professorList);
                            break;
                        default:
                            break;
                    }
                    }while (option!=0);
                default:
                    break;
            }



        }while (select !=0);

        scanner.close();
    }
}
