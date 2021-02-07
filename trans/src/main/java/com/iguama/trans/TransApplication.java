package com.iguama.trans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.iguama.trans.service.TransaccionService;

import java.util.Scanner;

@SpringBootApplication
public class TransApplication {
//public class TransApplication  extends SpringBootServletInitializer {


	public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(TransApplication.class, args);
        TransaccionService transaccionService = applicationContext.getBean(TransaccionService.class);
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tipo Reporte (1-consola/2-archivo): ");

		int num = scanner.nextInt();

		if (num == 1) {
			
	    	transaccionService.runReports();		         
		
		} else {
					
		System.out.println("Reporte de Archivos todavia no esta habilitado.");
		scanner.close();
		
		}
		
	}

}
