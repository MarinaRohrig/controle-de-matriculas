package repositories;

import models.Worker;

import java.util.List;
import java.util.Scanner;

public class WorkerRepository {

    private static Scanner scanner = new Scanner(System.in);
    private static String workerName, workerPhone, workerBirthdate, workerCPF;
    private static int quantityWorker = 0;

    public static int createWorker(List<Worker> workerList) {
        System.out.println("\n~~ Cadastro de Pedagogo ~~");
        System.out.println("Qual o nome do pedagogo?");
        System.out.println("...");
        workerName = scanner.nextLine();
        System.out.println("Qual o número de telefone do pedagogo?");
        System.out.println("...");
        workerPhone = scanner.nextLine();
        System.out.println("Qual a data de nascimento do pedagogo? (dia/mês/ano)");
        System.out.println("...");
        workerBirthdate = scanner.nextLine();
        System.out.println("Qual o CPF do pedagogo?");
        System.out.println("...");
        workerCPF = scanner.nextLine();
        Worker worker = new Worker(workerName, workerPhone, workerBirthdate, workerCPF);
        workerList.add(worker);
        return 0;
    }

    public static void getWorkerList(List<Worker> workerList) {
        if (workerList.isEmpty()) {
            System.out.println("Não existe pedagogo cadastrado");
        }
        for (int i = 0; i < workerList.size(); i++) {
            System.out.println(workerList.get(i));
        }

    }

    public static int workerExists(List<Worker> workerList, String workerName) {
        quantityWorker = 0;
        if (workerList.isEmpty()) {
            System.out.println("Não existe pedagogo cadastrado");
            return -2;
        }
        for (int i = 0; i < workerList.size(); i++) {
            Worker worker = workerList.get(i);
            if (worker.getName().equalsIgnoreCase(workerName)) {
                quantityWorker++;
                return i;
            }
            if (i == workerList.size() - 1 && quantityWorker == 0) {
                System.out.println("Pedagogo não cadastrado");
            }
        }
        return -2;
    }

    public static void workerReport(List<Worker> workerList) {
        int select;
        if (workerList.isEmpty()) {
            System.out.println("Não existe pedagogo cadastrado");
            return;
        }
        do {
            System.out.println("\n ~~ Relatórios de Pedagogo ~~");
            System.out.println("Digite uma opção:");
            System.out.println("1 - Pedagogo com mais atendimentos pedagógicos");
            System.out.println("2 - Todos Os Pedagogos");
            System.out.println("0 - Voltar");
            System.out.println("...");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    getMostCalls(workerList);
                    break;
                case 2:
                    getWorkerList(workerList);
                    break;
                default:
                    break;
            }
        } while (select != 0);
    }

    public static void getMostCalls(List<Worker> workerList) {
        Worker mostCallsWorker = new Worker("Dev", "0", "0", "0");
        for (int i = 0; i < workerList.size(); i++) {
            Worker worker = workerList.get(i);
            if (worker.getWorkerCalls() >= mostCallsWorker.getWorkerCalls()) {
                mostCallsWorker = worker;
            }
        }
        System.out.println(mostCallsWorker + " | Quantidade de atendimentos: " + mostCallsWorker.getWorkerCalls());
    }
}
