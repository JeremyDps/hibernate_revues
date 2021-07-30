package org.revuesHibernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pages", schema = "revues")
public class Pages {

    @Id
    @Column(name = "id")
    private int id;
    private String pageStart;
    private String pageEnd;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Articles> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageStart() {
        return pageStart;
    }

    public void setPageStart(String pageStart) {
        this.pageStart = pageStart;
    }

    public String getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(String pageEnd) {
        this.pageEnd = pageEnd;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id +
                ", pageStart='" + pageStart + '\'' +
                ", pageEnd='" + pageEnd + '\'' +
                '}';
    }
}
