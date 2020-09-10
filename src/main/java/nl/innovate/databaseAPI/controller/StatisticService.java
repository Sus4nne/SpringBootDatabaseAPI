package nl.innovate.databaseAPI.controller;

import nl.innovate.databaseAPI.exceptions.ConflictException;
import nl.innovate.databaseAPI.exceptions.ResourceNotFoundException;
import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatisticService {

    @Autowired
    private StatisticRepository repository;

    public Statistic findStatisticById(Integer id) {
        Optional<Statistic> statisticOptional = repository.findById(id);
        if (!statisticOptional.isPresent()) {
            throw new ResourceNotFoundException("Statistic not found with id " + id);
        }
        Statistic statistic = statisticOptional.get();
        return statistic;
    }

    public Statistic postStatistic(Statistic statistic) {
        if (statistic == null) {
            System.out.println("bad request");
        }
        return repository.save(statistic);
    }

    public Statistic putStatistic(Integer id, Statistic statistic) {
        if (!id.equals(statistic.getId())) {
            throw new ConflictException("Id " + id + " does not match the id of the Statistic.");
        }
        Statistic target = findStatisticById(id);
        target.replaceRecord(statistic);
        return repository.save(target);
    }

    public void deleteStatistic(Integer id) {
        Statistic target = findStatisticById(id);
        repository.delete(target);
    }

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
