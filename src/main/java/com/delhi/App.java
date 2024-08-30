package com.delhi;

import jakarta.persistence.*;
import com.delhi.gui.*;

public class App {
    public static void main(String[] args ) {

        AppPanel panel = new AppPanel();
        AppFrame frame = new AppFrame(panel);
        System.out.println("Hello World!" );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cosmetic");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();

    }
}
