package nl.innovate.databaseAPI.controller;


import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TotalService {

    @Autowired
    private TotalRepository repository;

    public Total getTotalsOverall() {
        Total total = new Total();
        List<Integer[]> list = repository.sumValues();
        if (list != null) {
            createTotal(list, total);
        }
        return total;
    }

    public Total getTotalsCurrentYear() {
        Total total = new Total();
        List<Integer[]> list = repository.sumValuesCurrent();
        if (list != null) {
            createTotal(list, total);
        }
        return total;
    }

    public Total getTotalsForYear(Integer year) {
        Total total = new Total();
        List<Integer[]> list = repository.sumValues(year);
        if (list != null) {
            createTotal(list, total);
        }
        return total;
    }

    public Total createTotal(List<Integer[]> list, Total total) {
        total.setId(0);
        total.setCountMonth(list.get(0)[0]);
        total.setSumValue1(list.get(0)[1]);
        total.setSumValue2(list.get(0)[2]);
        total.setSumValue3(list.get(0)[3]);

        return total;
    }

}
