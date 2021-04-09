/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: Homework 07 - Main
 * Student Name:
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // EntityManager initialization
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("real_estate");
        EntityManager em = emf.createEntityManager();

        // use find to instantiate and then display the "Keller Williams" agency, showing all of its agents
        Agency agency = em.find(Agency.class, 101);
        System.out.println(agency);
    }
}
