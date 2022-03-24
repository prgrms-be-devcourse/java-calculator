package service;

import creator.CreatorManagement;
import creator.type.RepositoryType;
import repository.CalculatorRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ClientService implements Service{

    CalculatorRepository repository = CreatorManagement
            .createCalculatorRepository(RepositoryType.InMemory);

    BufferedReader br;
    BufferedWriter bw;

    public ClientService(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void run() {

    }
}
