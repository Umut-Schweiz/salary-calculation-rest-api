package ch.learnbees.salarycalculate;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.repository.WorkingHoursRepository;
import ch.learnbees.salarycalculate.persistency.repository.WorkerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SalaryCalculateApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(SalaryCalculateApplication.class, args);

		WorkingHoursRepository workingHoursRepository = configurableApplicationContext.getBean(WorkingHoursRepository.class);
		WorkerRepository workerRepository = configurableApplicationContext.getBean(WorkerRepository.class);

		WorkerEntity worker1 = new WorkerEntity("Umut" , "Dev", "Good");
		workerRepository.save(worker1);
		/*
		WorkerEntity worker2 = new WorkerEntity("James" , "QA", "Disabled");
		WorkerEntity worker3 = new WorkerEntity("Marco" , "SQL", "Lazy");


		workerRepository.save(worker2);
		workerRepository.save(worker3);
		*/

		WorkingHoursEntity workingHoursOfworker1= new WorkingHoursEntity( 3.0 , 60.0 );
		workingHoursOfworker1.setWorkerEntity(worker1);
		workingHoursRepository.save(workingHoursOfworker1);

		/*
		WorkingHoursEntity workingHoursOfworker2= new WorkingHoursEntity( 2.0 , 90.0);
		WorkingHoursEntity workingHoursOfworker3= new WorkingHoursEntity( 7.0 , 120.0);


		workingHoursRepository.save(workingHoursOfworker2);
		workingHoursRepository.save(workingHoursOfworker3);
		*/


	}

}
