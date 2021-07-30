package org.revuesHibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SessionHibernate {

    // Je place une session dans un Tread
    public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    public static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    // Ce bloc s'éxécute quand la classe est instanciée au démarrage de l'application
    static {
        try {
            System.out.println(new Date() + ": initialisation de la session");
            // Récupérer la config d'hibernate dans le fichier hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // On instancie un serviceRegistry
            // Gérer la configuration d'hibernate sur notre session
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

            // On instancie notre session factory
            // Crée des sessions
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * méthode statique qui permet de créer une session
     * @return
     */
    public static Session currentSession() {
        // Je récupère la session du Tread en cours
        Session session = (Session) threadSession.get();

        // Si je n'ai pas de session
        if(session == null) {
            System.out.println("Je n'ai pas de session active");
            // J'ouvre une session avec mon objet sessionFactory
            // et je l'injecte dans le thread
            session = sessionFactory.openSession();
            threadSession.set(session);
        }
        System.out.println("J'ai bien récupéré ma session");
        return session;
    }

    /**
     * méthode statique pour fermer une session
     */
    public static void closeSession() {
        // Je récupère la session du Thread en cours
        Session session = (Session) threadSession.get();

        // Si j'ai une session
        if(session != null) {
            session.close();
        }
        // Je set à null mon Thread en cours
        threadSession.set(null);
        System.out.println("J'ia fermé ma session");
    }
}
