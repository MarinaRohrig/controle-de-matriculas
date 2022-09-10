package main;

import models.*;
import repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Autor: Marina Larissa Carpes Röhrig
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        List<Professor> professorList = new ArrayList<>();
        List<Worker> workerList = new ArrayList<>();
        StudentRepository studentRepository = new StudentRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        WorkerRepository workerRepository = new WorkerRepository();
        int select;

        do {
            System.out.println("\n~~ Bem-Vindo ao Sistema Automatizado da School Lab ~~");
            System.out.println("Digite uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Mudar A Condição da Matrícula");
            System.out.println("3 - Iniciar Um Atendimento Pedagógico");
            System.out.println("4 - Relatórios");
            System.out.println("0 - Sair");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                case 1:
                    do {
                        System.out.println("\n~~ Cadastro ~~");
                        System.out.println("Digite uma opção:");
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.println("3 - Pedagogo");
                        System.out.println("0 - Voltar");
                        System.out.println("...");
                        select = Integer.parseInt(scanner.nextLine());
                        switch (select) {
                            case 0:
                                System.out.println("Voltando para o menu inicial.");
                                break;
                            case 1:
                                studentRepository.createStudent(studentList);
                                select = 0;
                                break;
                            case 2:
                                professorRepository.createProfessor(professorList);
                                select = 0;
                                break;
                            case 3:
                                workerRepository.createWorker(workerList);
                                select = 0;
                                break;
                            default:
                                break;
                        }
                    } while (select != 0);
                    select = -1;
                    break;
                case 2:
                    System.out.println("Informe o nome do aluno que deseja editar a condição da matrícula");
                    System.out.println("...");
                    String name = scanner.nextLine();
                    studentRepository.changeStudentReg(name, studentList);
                    break;
                case 3:
                    System.out.println("\n~~ Atendimento Pedagógico ~~");
                    System.out.println("Qual o nome do pedagogo?");
                    String workerName = scanner.nextLine();
                    int workerIndex = workerRepository.workerExists(workerList, workerName);
                    if (workerIndex == -1) {
                        System.out.println("Pedagogo não cadastrado");
                        break;
                    } else {
                        System.out.println("Qual o nome do aluno?");
                        String studentName = scanner.nextLine();
                        int studentIndex = studentRepository.studentExists(studentList, studentName);
                        if (studentIndex == -1) {
                            System.out.println("Aluno não cadastrado");
                            break;
                        } else {
                            workerList.get(workerIndex).startCall();
                            studentList.get(studentIndex).startCall();
                            System.out.println("Pedido de atendimento pedagógico registrado");
                        }
                    }
                    break;
                case 4:
                    do {
                        System.out.println("\n~~ Relatórios ~~");
                        System.out.println("Digite uma opção:");
                        System.out.println("1 - Aluno");
                        System.out.println("2 - Professor");
                        System.out.println("3 - Pedagogo");
                        System.out.println("4 - Listar todas as pessoas cadastradas");
                        System.out.println("0 - Voltar");
                        System.out.println("...");
                        select = Integer.parseInt(scanner.nextLine());
                        switch (select) {
                            case 0:
                                System.out.println("Voltando para o menu inicial");
                                break;
                            case 1:
                                studentRepository.studentReport(studentList);
                                break;
                            case 2:
                                professorRepository.professorReport(professorList);
                                break;
                            case 3:
                                workerRepository.workerReport(workerList);
                                break;
                            case 4:
                                System.out.println("Alunos");
                                studentRepository.getStudentList(studentList);
                                System.out.println("Professores");
                                professorRepository.getProfessorList(professorList);
                                System.out.println("Pedagogos");
                                workerRepository.getWorkerList(workerList);
                                System.out.println();
                                break;
                            default:
                                break;
                        }
                    } while (select != 0);
                    select = -1;
                    break;
                default:
                    break;
            }
        } while (select != 0);
        scanner.close();
    }
}
