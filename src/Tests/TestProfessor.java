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
        int id = 1;
        do {
            System.out.println("~~ Test For Professor Class And Report ~~");
            System.out.println("Select an option:");
            System.out.println("1 - Registry");
            System.out.println("2 - Report");
            System.out.println("0 - Exit");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("Ending Program...");
                    break;
                case 1:
                    ProfessorRepository.createProfessor(professorList);
                    System.out.println();
                    break;
                case 2:
                    do {
                        System.out.println();
                        System.out.println("~~ Report ~~");
                        System.out.println("Select a Report:");
                        System.out.println("1 - Status");
                        System.out.println("2 - Development Area ");
                        System.out.println("0 - Return");
                        System.out.println("...");

                        select = Integer.parseInt(scanner.nextLine());

                        switch (select) {
                            case 0:
                                System.out.println("Returning to main menu...\n");
                                break;
                            case 1:
                                System.out.println("Inform the status (Active or Inactive)");
                                System.out.println("...");
                                String status = scanner.nextLine();
                                ProfessorRepository.getProfessorStatus(status, professorList);
                                System.out.println();
                                break;
                            case 2:
                                ProfessorRepository.getDevArea(professorList);
                                System.out.println();
                                break;
                            default:
                                break;
                        }
                    } while (select != 0);
                    select = -1;
                default:
                    break;
            }
        } while (select != 0);
        scanner.close();
    }
}
