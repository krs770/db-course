package ru.mpei.example.ormdemo;

import jakarta.persistence.EntityManagerFactory;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class OrmDemoApplication {

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(OrmDemoApplication.class, args);

		EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);

		/*EntityManager entityManager = entityManagerFactory.createEntityManager();
		Avatar avatar = new Avatar();
		avatar.setPhotoUrl("photoUrl");

		entityManager.getTransaction().begin();
		entityManager.persist(avatar);
		entityManager.flush();
		entityManager.getTransaction().commit();


		Console.main(args);*/
	}

}
