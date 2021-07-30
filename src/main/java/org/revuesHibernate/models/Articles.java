package org.revuesHibernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles", schema = "revues")
public class Articles {

    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private String content;

    @ManyToMany(mappedBy = "articles")
    private List<Pages> pages;

    @ManyToMany(mappedBy = "articles")
    private List<Authors> authors;

    @ManyToMany(mappedBy = "articles")
    private List<Numbers> numbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Pages> getPages() {
        return pages;
    }

    public void setPages(List<Pages> pages) {
        this.pages = pages;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Numbers> numbers) {
        this.numbers = numbers;
    }
}
