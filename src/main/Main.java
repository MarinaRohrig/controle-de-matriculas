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
        int select = 0, id = 1;

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
                        System.out.println("1 - Estudante");
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
                                break;
                            case 2:
                                ProfessorRepository.createProfessor(professorList, id);
                                System.out.println();
                                id++;
                            case 3:
                                WorkerRepository.createWorker(workerList,id);
                                System.out.println();
                                id++;
                        }
                    }while (select!=0);
                    select = -1;
                case 2:
                    StudentRepository.changeStudentReg()
                    break;
                case 3:
                    //start an educational call
                    break;
                case 4:
                    //reports
                    break;
                default:
                    break;
            }
        } while (select != 0);
        scanner.close();
    }
}
