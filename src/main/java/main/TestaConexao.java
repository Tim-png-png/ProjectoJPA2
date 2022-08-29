package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.JPAUtil;

public class TestaConexao {

	public static void main(String[] args) {
//		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ProjectoJPAPU");
//
//		EntityManager sessao = fabrica.createEntityManager();
//		
//		System.out.println(sessao);
//		
//		sessao.close();
//		fabrica.close();
//		
//		System.out.println(sessao);
		
		JPAUtil.getEntityManeger();
	}

}
