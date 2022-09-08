package main;

import models.*;
import repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        List<Professor> professorList = new ArrayList<>();
        List<Worker> workerList = new ArrayList<>();
        int select, id = 1;

        do {
            System.out.println("~~ Bem-Vindo ao Sistema Automatizado da School Lab ~~");
            System.out.println("Digite uma opção:");
            System.out.println("1 - Registrar");
            System.out.println("2 - Mudar A Condição da Matrícula");
            System.out.println("3 - Iniciar Um Atendimento Pedagógico");
            System.out.println("4 - Relatórios");
            System.out.println("0 - Sair");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch(select){
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                case 1:
                    //registry
                    do {
                        System.out.println("~~ Registro ~~");
                        System.out.println("Digite uma opção:");
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.println("3 - Pedagogo");
                        System.out.println("0 - Voltar");
                        System.out.println("...");
                        select = Integer.parseInt(scanner.nextLine());
                        switch (select){
                            case 0:
                            System.out.println("Voltando para o menu inicial...\n");
                            break;
                            case 1:
                                StudentRepository.createStudent(studentList,id);
                                System.out.println();
                                id++;
                                select=0;
                                break;
                            case 2:
                                ProfessorRepository.createProfessor(professorList, id);
                                System.out.println();
                                id++;
                                select=0;
                                break;
                            case 3:
                                WorkerRepository.createWorker(workerList,id);
                                System.out.println();
                                id++;
                                select=0;
                                break;
                            default:
                                break;
                        }
                    }while (select!=0);
                    select = -1;
                    break;
                case 2:
                    System.out.println("Informe o nome do aluno que deseja editar a condição da matrícula");
                    System.out.println("...");
                    String name = scanner.nextLine();
                    StudentRepository.changeStudentReg(name,studentList);
                    break;
                case 3:
                    System.out.println("~~ Atendimento Pedagógico ~~");
                    System.out.println("Qual o nome do pedagogo?");

                    System.out.println("Qual o nome do aluno?");

                    break;
                case 4:
                    do {
                        System.out.println();
                        System.out.println("~~ Relatórios ~~");
                        System.out.println("Digite uma opção:");
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.println("3 - Pedagogo");
                        System.out.println("4 - Listar todas as pessoas cadastradas");
                        System.out.println("0 - Voltar");
                        System.out.println("...");
                        select = Integer.parseInt(scanner.nextLine());
                        switch(select){
                            case 0:
                                System.out.println("Voltando para o menu inicial...\n");
                                break;
                            case 1:
                                // relatórios do aluno
                                break;
                            case 2:
                                System.out.println("~~ Relatórios Do Professor ~~");
                                System.out.println("1 - Por status");
                                System.out.println("2 - Por área de desenvolvimento");
                                System.out.println("3 - Listar todos os professores");
                                System.out.println("0 - Voltar");
                                System.out.println("...");

                                // relatórios do professor
                                select=0;
                                break;
                            case 3:
                                // relatorios do pedagogo, mostra pedagogo com mais atendimentos
                                select=0;
                                break;
                            case 4:
                                // mostra tudãooo
                                System.out.println("Alunos");
                                StudentRepository.getStudentList(studentList);
                                System.out.println("Professores");
                                ProfessorRepository.getProfessorList(professorList);
                                System.out.println("Pedagogos");
                                WorkerRepository.getWorkerList(workerList);
                                System.out.println();
                                select=0;
                                break;
                            default:
                                break;
                        }
                    }while (select!=0);
                    select = -1;
                default:
                    break;
            }
        } while (select != 0);
        scanner.close();
    }
}
