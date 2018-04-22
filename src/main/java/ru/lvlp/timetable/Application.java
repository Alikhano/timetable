package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
  public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ActPersistenceUnit");
        EntityManager em = factory.createEntityManager();



    }
}
