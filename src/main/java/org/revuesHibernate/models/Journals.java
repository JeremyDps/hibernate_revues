package org.revuesHibernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "journals", schema = "revues")
public class Journals {

    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private Integer period;

    @OneToMany(mappedBy = "journals", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Numbers> numbers) {
        this.numbers = numbers;
    }
}
