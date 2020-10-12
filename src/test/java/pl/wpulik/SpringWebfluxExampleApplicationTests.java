package pl.wpulik;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
class SpringWebfluxExampleApplicationTests {

	@Test
	void contextLoads() {
		
		Flux.just("Wojtek", "Andrzej", "Tola", "Kazio", "Ania", "Ignacy", "Antek",
				"Józef", "Jan", "Janinka", "Helenka", "Agnieszka", "Zdzisław", "Bogdan")
			.filter(name -> name.startsWith("J"))
			.subscribe(System.out::println);
		
		//Mono.just();
	}

}
