package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tasks.model.bean.Task;

public class Teste {

	public static void main(String[] args) {
		Task task = new Task();
		task.setTitle("Título da tarefa");
		task.setDescription("Descrição da tarefa");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
