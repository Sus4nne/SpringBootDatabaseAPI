package nl.innovate.databaseAPI.controller;

import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@EnableJpaRepositories
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
    List<Statistic> findAll();

    List<Statistic> findByYear(Integer year);

    List<Statistic> findByMonth(Integer month);

    List<Statistic> findByYearAndMonth(Integer year, Integer month);



//    @Query(value = "SELECT count(month), sum(value1), sum(value2), sum(value3) FROM statistics_all WHERE year=2020", nativeQuery = true)
//    List<Tuple> sumValues();


//    private static final String SQL_QUERY_FIND_ALL = "SELECT id, year, month, value1, value2, value3 FROM statistics_all";
//
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    public StatisticRepository(NamedParameterJdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private RowMapper<Statistic> statisticRowMapper = (ResultSet rs, int rowNum) -> {
//        Statistic statistic = new Statistic();
//        statistic.setId(rs.getInt("id"));
//        statistic.setYear(rs.getInt("year"));
//        statistic.setMonth(rs.getInt("month"));
//        statistic.setValue1(rs.getInt("value1"));
//        statistic.setValue2(rs.getInt("value2"));
//        statistic.setValue3(rs.getInt("value3"));
//        return statistic;
//    };
//
//    public Iterable<Statistic> findAll() {
//        return this.jdbcTemplate.query(SQL_QUERY_FIND_ALL, statisticRowMapper);
//    }
}
