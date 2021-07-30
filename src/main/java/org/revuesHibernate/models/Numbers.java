package org.revuesHibernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "numbers", schema = "revues")
public class Numbers {

    @Id
    @Column(name = "id")
    private int id;
    private Integer number;
    private Integer year;
    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "journals_id")
    private Journals journals;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Articles> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Journals getJournals() {
        return journals;
    }

    public void setJournals(Journals journals) {
        this.journals = journals;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
