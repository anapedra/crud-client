package com.anapedra.crudclientes;

import com.anapedra.crudclientes.entities.Client;
import com.anapedra.crudclientes.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudClientesApplication implements CommandLineRunner {
     private final ClientRepository clientRepository;
    public CrudClientesApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudClientesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Client> clients=new ArrayList<>();

        Client c1=new Client(1L,"Ana Santana","77634239780",10.000, LocalDate.parse("2002-09-25"),5);
        Client c2=new Client(2L,"Maria de Lurdes Tomaz","44230037910",5.000, LocalDate.parse("1945-10-20"),10);
        Client c3=new Client(3L,"Paulo Augustin de Prado","78439240600",3.500 ,LocalDate.parse("2003-12-06"),6);
        Client c4=new Client(4L,"Marcos Salles Macedo","56357354104",6.300, LocalDate.parse("1979-06-30"),3);
        Client c5=new Client(5L,"Flavia Maganez Brito","52222520436",15.500, LocalDate.parse("1988-04-23"),2);
        Client c6=new Client(6L,"Marcone Frotes Siqueira","38849388780",4.500, LocalDate.parse("2000-07-21"),1);
        Client c7=new Client(7L,"Franco Martins Mendes","71498385613",3.600, LocalDate.parse("2005-09-25"),0);
        Client c8=new Client(8L,"Pedro Mendes da Cunha","77718135500",6.900, LocalDate.parse("2002-06-25"),1);
        Client c9=new Client(9L,"Sandro Merelles Franco","47583634806",9.800, LocalDate.parse("2001-08-21"),0);
        Client c10=new Client(10L,"Mácia Cardoso Imperatriz","17414925722",3.800, LocalDate.parse("2006-09-25"),0);
        clients.addAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
        clientRepository.saveAll(clients);


    }
}
