package org.revuesHibernate;

import org.revuesHibernate.models.*;
import org.revuesHibernate.utils.SessionHibernate;
import repositories.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArticlesRepository articlesRepository = new ArticlesRepository();
        AuthorsRepository authorsRepository = new AuthorsRepository();
        JournalsRepository journalsRepository = new JournalsRepository();
        NumberRepository numberRepository = new NumberRepository();
        PagesRepository pagesRepository = new PagesRepository();

        // Création de 3 pages
        Pages p1 = new Pages();
        Pages p2 = new Pages();
        Pages p3 = new Pages();

        p1.setPageStart("Première pages pour p1");
        p1.setPageEnd("Dernière page pour p1");
        p2.setPageStart("Première pages pour p2");
        p2.setPageEnd("Dernière page pour p2");
        p3.setPageStart("Première pages pour p3");
        p3.setPageEnd("Dernière page pour p3");

        //pagesRepository.save(p1);
        //pagesRepository.save(p2);
        //pagesRepository.save(p3);

        // Récupération des toutes le contenu des tables
        List<Authors> allAuthors = authorsRepository.getAll(Authors.class);
        //allAuthors.forEach(a -> System.out.println(a.getFirstname() + " " + a.getLastname()));

        List<Journals> allJournals = journalsRepository.getAll(Journals.class);
        //allJournals.forEach(a -> System.out.println(a.getName()));

        List<Pages> allPages = pagesRepository.getAll(Pages.class);
        //allPages.forEach(a -> System.out.println(a.getPageStart() + " " + a.getPageEnd()));

        List<Numbers> allNumbers = numberRepository.getAll(Numbers.class);
        //allNumbers.forEach(a -> System.out.println(a.getNumber() + " " + a.getJournals().getName()));

        List<Articles> allArticles = articlesRepository.getAll(Articles.class);
        //allArticles.forEach(a -> System.out.println(a.getName() + " " + a.getContent()));

        // Récupérer un seul élement
        Authors author1 = authorsRepository.get(1, Authors.class);
        System.out.println(author1.getFirstname() + " " + author1.getLastname());
        author1.getArticles().forEach(a -> System.out.println(a.getName()));

        /*Authors author2 = authorsRepository.get(2, Authors.class);
        System.out.println(author2.getFirstname() + " " + author1.getLastname());
        author2.getArticles().forEach(a -> System.out.println(a.getName()));*/

        Articles article1 = articlesRepository.get(2, Articles.class);
        System.out.println(article1.getName());
        //article1.getAuthors().forEach(a -> System.out.println(a.getFirstname() + " " + a.getLastname()));


        // modification en base many to many
        Articles article11 = articlesRepository.get(11, Articles.class);
        System.out.println(article11.getName());

        List<Authors> authorsArticle = new ArrayList<Authors>();
        authorsArticle.add(author1);
        //authorsArticle.add(author2);

        article11.setAuthors(authorsArticle);
        articlesRepository.update(article11);

        // modification en base
        //author2.setEmail("jeanDupontLeBogoss@gmail.com");
        //authorsRepository.update(author2);

        // suppression
        authorsRepository.delete(author1);
    }
}
