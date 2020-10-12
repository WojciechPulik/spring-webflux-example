package pl.wpulik;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class InitService {
	
private StudentRepo studentRepo;
	
	public InitService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void get() {
		studentRepo.deleteAll()
			.thenMany(Flux.just("Wojtek", "Andrzej", "Tola", "Kazio", "Ania", "Ignacy", "Antek",
					"Józef", "Jan", "Janinka", "Helenka", "Agnieszka", "Zdzisław", "Bogdan"))
			.map(name -> new Student(name))
			.flatMap(studentRepo::save)
			.thenMany(studentRepo.findAll())
			.subscribe(System.out::println);	
		
		studentRepo.save(new Student(("Spadochron"))).subscribe();
	}

}
