package applicationwithmongoDB;

import applicationwithmongoDB.DTO.AuthorDTO;
import applicationwithmongoDB.repositoryMongoBD.PostRepository;
import applicationwithmongoDB.repositoryMongoBD.entity.Post;
import applicationwithmongoDB.repositoryMongoBD.entity.User;
import applicationwithmongoDB.repositoryMongoBD.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@SpringBootApplication
public class ApplicationWithMongoDbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWithMongoDbApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd;MM;YYYY");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21;03;2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23;03;2018"), "Bom Dia", "Acordei Feliz Hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
