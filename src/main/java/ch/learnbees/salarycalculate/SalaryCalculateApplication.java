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

		WorkingHoursEntity workingHoursOfWorker1= new WorkingHoursEntity( 3.0 , 60.0 );
		WorkerEntity worker1 = new WorkerEntity("Umut" , "Dev", "Good" , workingHoursOfWorker1);
		workerRepository.save(worker1);
		workingHoursOfWorker1.setWorkerEntity(worker1);
		workingHoursRepository.save(workingHoursOfWorker1);

		WorkingHoursEntity workingHoursOfWorker2= new WorkingHoursEntity( 2.0 , 90.0);
		WorkerEntity worker2 = new WorkerEntity("James" , "QA", "Disabled" , workingHoursOfWorker2);
		workerRepository.save(worker2);
		workingHoursOfWorker2.setWorkerEntity(worker2);
		workingHoursRepository.save(workingHoursOfWorker2);

		WorkingHoursEntity workingHoursOfWorker3= new WorkingHoursEntity( 7.0 , 120.0);
		WorkerEntity worker3 = new WorkerEntity("Marco" , "SQL", "Lazy",workingHoursOfWorker3);
		workerRepository.save(worker3);
		workingHoursOfWorker3.setWorkerEntity(worker3);
		workingHoursRepository.save(workingHoursOfWorker3);

		/*
		WorkingHoursEntity workingHoursOfWorker1= new WorkingHoursEntity( 3.0 , 60.0 );
		WorkingHoursEntity workingHoursOfWorker2= new WorkingHoursEntity( 2.0 , 90.0);
		WorkingHoursEntity workingHoursOfWorker3= new WorkingHoursEntity( 7.0 , 120.0);

		WorkerEntity worker1 = new WorkerEntity("Umut" , "Dev", "Good" , workingHoursOfWorker1);
		WorkerEntity worker2 = new WorkerEntity("James" , "QA", "Disabled" , workingHoursOfWorker2);
		WorkerEntity worker3 = new WorkerEntity("Marco" , "SQL", "Lazy",workingHoursOfWorker3);

		workerRepository.save(worker1);
		workingHoursRepository.save(workingHoursOfWorker1);
		workingHoursOfWorker1.setWorkerEntity(worker1);

		workerRepository.save(worker2);
		workingHoursRepository.save(workingHoursOfWorker2);
		workingHoursOfWorker2.setWorkerEntity(worker2);

		workerRepository.save(worker3);
		workingHoursRepository.save(workingHoursOfWorker3);
		workingHoursOfWorker3.setWorkerEntity(worker3);
		*/

	}

}
