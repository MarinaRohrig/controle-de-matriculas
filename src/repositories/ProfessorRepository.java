package repositories;

import models.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorRepository {
    private static Scanner scanner = new Scanner(System.in);
    private  static String professorName,professorPhone,professorBirthdate,professorCPF, background, devArea, status;
    private static int select=0, quantityProfessor;

    public static int createProfessor(List<Professor> professorList, int idPerson){
        System.out.println("\n~~ Registrando Um Professor ~~");
        System.out.println("Qual o nome do professor?");
        System.out.println("...");
        professorName = scanner.nextLine();
        System.out.println("Qual o número de telefone do professor?");
        System.out.println("...");
        professorPhone = scanner.nextLine();
        System.out.println("Qual a data de nascimento do professor? (dia/mês/ano)");
        System.out.println("...");
        professorBirthdate = scanner.nextLine();
        System.out.println("Qual o CPF do professor?");
        System.out.println("...");
        professorCPF = scanner.nextLine();
        System.out.println("Qual a formação acadêmica do professor? (Graduação Incompleta, Graduação Completa, Mestrado, Doutorado)");
        System.out.println("...");
        background = scanner.nextLine();
        System.out.println("Qual a área de desenvolvimento do professor? (Front-End, Back-End or Full-Stack)");
        System.out.println("...");
        devArea = scanner.nextLine();
        System.out.println("O professor " + professorName + " está Ativo ou Inativo?");
        System.out.println("...");
        status = scanner.nextLine();
        Professor professor1 = new Professor(professorName,professorPhone,professorBirthdate,professorCPF,idPerson,background,devArea,status );
        professorList.add(professor1);
        return 0;
    }

    public static int getProfessorStatus(String status,List<Professor> professorList ) {
        System.out.println("\n~~ Verificando o Estado de Todos Os Professores ~~");
        quantityProfessor=0;
        for (int i = 0; i < professorList.size(); i++) {
            Professor professor = professorList.get(i);
            if (professor.getStatus().equalsIgnoreCase(status)) {
                System.out.println(professor.getInfo());
                quantityProfessor++;
            }
        }
        if (quantityProfessor == 0){
            System.out.println("Não existe professor para o estado informado");
        }
        return 0;
    }

    public static int getDevArea (List<Professor> professorList){
        do {
            quantityProfessor=0;
            System.out.println("\n~~ Relatório de Professores Por Área de Desenvolvimento ~~");
            System.out.println("Digite uma opção:");
            System.out.println("1 - Front-End");
            System.out.println("2 - Back-End ");
            System.out.println("3 - Full-Stack");
            System.out.println("4 - Todos");
            System.out.println("0 - Voltar");
            System.out.println("...");
            int select = Integer.parseInt(scanner.nextLine());
        switch(select){
            case 0:
                return 0;
            case 1:
                System.out.println("\n~~ Professores Que Trabalham Com Front-End ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Front-End")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("Não existe professor para essa área.");
                }
                break;
            case 2:
                System.out.println("\n~~ Professores Que Trabalham Com Back-End ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Back-End")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("Não existe professor para essa área.");
                }
                break;
            case 3:
                System.out.println("\n~~ Professores Que Trabalham Com Full-Stack ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Full-Stack")) {
                        System.out.println(professor.getInfo());
                        quantityProfessor++;
                    }
                }
                if (quantityProfessor == 0){
                    System.out.println("Não existe professor para essa área.");
                }
                break;
            case 4:
                System.out.println("\n~~ Professores Registrados ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    System.out.println(professor.getInfo());
                    quantityProfessor++;
                }
                if (quantityProfessor == 0){
                    System.out.println("Não existe professor registrado.");
                }
                break;
            default:
                break;
        }
        }while (select !=0);
        return 0;
    }
}
