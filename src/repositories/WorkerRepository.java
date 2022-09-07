package repositories;

import models.Worker;

import java.util.List;
import java.util.Scanner;

public class WorkerRepository {

    private static Scanner scanner = new Scanner(System.in);
    private static String workerName,workerPhone,workerBirthdate,workerCPF;

    public static int createWorker(List<Worker> workerList, int id ){
        System.out.println("\n~~ Registrando Um Pedagogo ~~");
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
        Worker worker = new Worker(workerName,workerPhone,workerBirthdate,workerCPF,id);
        workerList.add(worker);
        return 0;
    }

    public static void getMostCalls(List<Worker> workerList){
        Worker mostCallsWorker = new Worker("Dev","0","0","0",-1);
        for (int i = 0; i < workerList.size(); i++){
            Worker worker = workerList.get(i);
            if (worker.getCall() > mostCallsWorker.getCall()){
                mostCallsWorker = worker;
            }
        }
        System.out.println("Pedagogo com o maior número de atendimentos pedagógicos: "+mostCallsWorker.getName() + " | Quantidade de atendimentos: "+mostCallsWorker.getCall());
    }
}
