package nl.innovate.databaseAPI.controller;

import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticService {

    @Autowired
    private StatisticRepository repository;

    public Total getTotalsCurrentYear() {
        int year = LocalDate.now().getYear();
        Total total = new Total();
        if (repository.findByYear(year) != null) {
            List<Statistic> list = repository.findByYear(year);
            int countMonth = 0;
            int sumValue1 = 0;
            int sumValue2 = 0;
            int sumValue3 = 0;
            for (Statistic stat : list) {
                countMonth += 1;
                sumValue1 += stat.getValue1();
                sumValue2 += stat.getValue2();
                sumValue3 += stat.getValue3();
            }
            total.setCountMonth(countMonth);
            total.setSumValue1(sumValue1);
            total.setSumValue2(sumValue2);
            total.setSumValue3(sumValue3);
        }
        return total;
    }

    public Total getTotalsForYear(Integer year) {
        Total total = new Total();
        if (repository.findByYear(year) != null) {
            List<Statistic> list = repository.findByYear(year);
            int countMonth = 0;
            int sumValue1 = 0;
            int sumValue2 = 0;
            int sumValue3 = 0;
            for (Statistic stat : list) {
                countMonth += 1;
                sumValue1 += stat.getValue1();
                sumValue2 += stat.getValue2();
                sumValue3 += stat.getValue3();
            }
            total.setCountMonth(countMonth);
            total.setSumValue1(sumValue1);
            total.setSumValue2(sumValue2);
            total.setSumValue3(sumValue3);
        }
        return total;
    }

    public Total getTotals() {
        Total total = new Total();
        if (repository.findAll() != null) {
            List<Statistic> list = repository.findAll();
            int countMonth = 0;
            int sumValue1 = 0;
            int sumValue2 = 0;
            int sumValue3 = 0;
            for (Statistic stat : list) {
                countMonth += 1;
                sumValue1 += stat.getValue1();
                sumValue2 += stat.getValue2();
                sumValue3 += stat.getValue3();
            }
            total.setCountMonth(countMonth);
            total.setSumValue1(sumValue1);
            total.setSumValue2(sumValue2);
            total.setSumValue3(sumValue3);
        }
        return total;
    }

    // zoekfuncties hier


//    public Statistic getCurrentMonth() throws SQLException {
//        int currentMonth = LocalDate.now().getMonthValue();
//        int currentYear = LocalDate.now().getYear();
//        String currentMonthQuery = "SELECT id, year, month, value1, value2, value3 FROM statistics_all WHERE year=" + currentYear + " && month=" + currentMonth;
//        resultSet = statement.executeQuery(currentMonthQuery);
//
//        Statistic currentMonthStat = new Statistic();
////		while (resultSet.next()) {
////			currentMonthStat.id = resultSet.getInt(1);
////			currentMonthStat.year = resultSet.getInt(2);
////			currentMonthStat.month = resultSet.getInt(3);
////			currentMonthStat.value1 = resultSet.getInt(4);
////			currentMonthStat.value2 = resultSet.getInt(5);
////			currentMonthStat.value3 = resultSet.getInt(6);
////		}
//
//        return currentMonthStat;
//    }
}
