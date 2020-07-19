package nl.innovate.databaseAPI.controller;

import nl.innovate.databaseAPI.model.Total;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TotalRepository extends CrudRepository<Total, Integer> {
   @Query(value = "SELECT count(month), sum(value1), sum(value2), sum(value3) FROM statistics_all WHERE year=2020", nativeQuery = true)
   List<Integer[]> sumValues();

//   @Query(value = "SELECT count(month), sum(value1), sum(value2), sum(value3) FROM statistics_all WHERE year=:year", nativeQuery = true)
//   List<Integer[]> sumValues(Integer year);
}
