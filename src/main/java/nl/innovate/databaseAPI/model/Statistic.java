package nl.innovate.databaseAPI.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name="statistics_all")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Year is mandatory")
    @Range(min = 2000, max = 2100)
    private int year;

    @NotNull(message = "Month is mandatory")
    @Range(min = 1, max = 12)
    private int month;

    @NotNull(message = "Value1 is mandatory")
    @PositiveOrZero
    private int value1;

    @NotNull(message = "Value2 is mandatory")
    @PositiveOrZero
    private int value2;

    @NotNull(message = "Value3 is mandatory")
    @PositiveOrZero
    private int value3;

    public void replaceRecord(Statistic other) {
        setId(other.id);
        setYear(other.year);
        setMonth(other.month);
        setValue1(other.value1);
        setValue2(other.value2);
        setValue3(other.value3);
    }
    // add date imported/created
}
