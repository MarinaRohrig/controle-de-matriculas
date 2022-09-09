package repositories;

import models.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorRepository {
    private static Scanner scanner = new Scanner(System.in);
    private  static String professorName,professorPhone,professorBirthdate,professorCPF, background, devArea, status;
    private static int select=0, quantityProfessor;

    public static int createProfessor(List<Professor> professorList){
        System.out.println("\n~~ Registrando Um Professor ~~");
        System.out.println("Qual o nome do professor?");
        System.out.println("...");
        professorName = scanner.nextLine();
        System.out.println("Qual o n�mero de telefone do professor?");
        System.out.println("...");
        professorPhone = scanner.nextLine();
        System.out.println("Qual a data de nascimento do professor? (dia/m�s/ano)");
        System.out.println("...");
        professorBirthdate = scanner.nextLine();
        System.out.println("Qual o CPF do professor?");
        System.out.println("...");
        professorCPF = scanner.nextLine();
        System.out.println("Qual a forma��o acad�mica do professor? (Gradua��o Incompleta, Gradua��o Completa, Mestrado, Doutorado)");
        System.out.println("...");
        background = scanner.nextLine();
        System.out.println("Qual a �rea de desenvolvimento do professor? (Front-End, Back-End or Full-Stack)");
        System.out.println("...");
        devArea = scanner.nextLine();
        System.out.println("O professor " + professorName + " est� Ativo ou Inativo?");
        System.out.println("...");
        status = scanner.nextLine();
        Professor professor1 = new Professor(professorName,professorPhone,professorBirthdate,professorCPF, background,devArea,status );
        professorList.add(professor1);
        return 0;
    }

    public static int professorReport(List<Professor> professorList){
        do {
            System.out.println("\n~~ Relat�rios Do Professor ~~");
            System.out.println("1 - Por status");
            System.out.println("2 - Por �rea de desenvolvimento");
            System.out.println("3 - Todos os Professores");
            System.out.println("0 - Voltar");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("Voltando para o menu inicial.\n");
                    break;
                case 1:
                    System.out.println("Informe o estado. (Ativo ou Inativo)");
                    System.out.println("...");
                    String status = scanner.nextLine();
                    getProfessorStatus(status, professorList);
                    System.out.println();
                    break;
                case 2:
                    getDevArea(professorList);
                    System.out.println();
                    break;
                default:
                    break;
            }
        }while (select !=0);
        return 0;
    }

    public static int getProfessorStatus(String status,List<Professor> professorList ) {
        System.out.println("\n~~ Verificando o Estado de Todos Os Professores ~~");
        quantityProfessor=0;
        for (int i = 0; i < professorList.size(); i++) {
            Professor professor = professorList.get(i);
            if (professor.getStatus().equalsIgnoreCase(status)) {
                System.out.println(professor.toString());
                quantityProfessor++;
            }
            if (quantityProfessor == 0){
                System.out.println("N�o existe professor para o estado informado");
            }
        }
        return 0;
    }

    public static int getDevArea (List<Professor> professorList){
        do {
            quantityProfessor=0;
            System.out.println("\n~~ Relat�rio de Professores Por �rea de Desenvolvimento ~~");
            System.out.println("Digite uma op��o:");
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
                        System.out.println(professor.toString());
                        quantityProfessor++;
                    }
                    if (quantityProfessor == 0){
                        System.out.println("N�o existe professor para essa �rea.");
                    }
                }
                break;
            case 2:
                System.out.println("\n~~ Professores Que Trabalham Com Back-End ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Back-End")) {
                        System.out.println(professor.toString());
                        quantityProfessor++;
                    }
                    if (quantityProfessor == 0){
                        System.out.println("N�o existe professor para essa �rea.");
                    }
                }
                break;
            case 3:
                System.out.println("\n~~ Professores Que Trabalham Com Full-Stack ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    if (professor.getDevArea().equalsIgnoreCase("Full-Stack")) {
                        System.out.println(professor.toString());
                        quantityProfessor++;
                    }
                    if (quantityProfessor == 0){
                        System.out.println("N�o existe professor para essa �rea.");
                    }
                }
                break;
            case 4:
                System.out.println("\n~~ Professores Registrados ~~");
                for (int i = 0; i < professorList.size(); i++) {
                    Professor professor = professorList.get(i);
                    System.out.println(professor.toString());
                    quantityProfessor++;
                }
                if (quantityProfessor == 0){
                    System.out.println("N�o existe professor registrado.");
                }
                break;
            default:
                break;
        }
        }while (select !=0);
        return 0;
    }
    public static void getProfessorList(List<Professor> professorList){
        if (professorList.isEmpty()){
            System.out.println("N�o existe professor registrado.");
        }
        for (int i=0; i<professorList.size(); i++){
            System.out.println(professorList.get(i).toString());
        }

    }
}
