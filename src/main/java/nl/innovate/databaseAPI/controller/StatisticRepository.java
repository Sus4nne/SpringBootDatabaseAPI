package nl.innovate.databaseAPI.controller;

import nl.innovate.databaseAPI.model.Statistic;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
    List<Statistic> findAll();

    List<Statistic> findByYear(Integer year);

    List<Statistic> findByMonth(Integer month);

    List<Statistic> findByYearAndMonth(Integer year, Integer month);

}
