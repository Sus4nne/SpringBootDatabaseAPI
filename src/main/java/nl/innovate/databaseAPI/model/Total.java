package nl.innovate.databaseAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Total {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int countMonth;
    private int sumValue1;
    private int sumValue2;
    private int sumValue3;
}
