package nl.innovate.databaseAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="statistics_all")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int month;
    private int value1;
    private int value2;
    private int value3;
    // add date imported/created
}
