package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjectoJPAPU");

	public static EntityManager getEntityManeger() {
		EntityManager sessao = factory.createEntityManager();
		return sessao;
	}
}
