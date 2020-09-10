package nl.innovate.databaseAPI.rest;

import lombok.extern.slf4j.Slf4j;
import nl.innovate.databaseAPI.controller.StatisticRepository;
import nl.innovate.databaseAPI.controller.StatisticService;
import nl.innovate.databaseAPI.controller.TotalRepository;
import nl.innovate.databaseAPI.controller.TotalService;
import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin()
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class StatisticEndpoint {
    private StatisticRepository statisticRepository;

    @Autowired
    private TotalRepository totalRepository;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private TotalService totalService;

    @Autowired
    public StatisticEndpoint(StatisticRepository statisticRepository) {
        log.info("LOG - Endpoint started.");
        this.statisticRepository = statisticRepository;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Statistic> getStatistics() {
        log.info("LOG - GET: statistics ALL ");
        return statisticRepository.findAll();
    }

    @GetMapping("/year/{year}")
    public @ResponseBody List<Statistic> getYear(@PathVariable Integer year) {
        log.info("LOG - GET: statistics YEAR/ " + year );
        return statisticRepository.findByYear(year);
    }

    @GetMapping("/month/{month}")
    public @ResponseBody List<Statistic> getMonthFromYear(@PathVariable Integer month) {
        log.info("LOG - GET: statistics MONTH/ " + month );
        return statisticRepository.findByMonth(month);
    }

    @GetMapping("/{year}/{month}")
    public @ResponseBody List<Statistic> getMonthFromYear(@PathVariable Integer year, @PathVariable Integer month) {
        log.info("LOG - GET: statistics YEAR " + year + " /MONTH " + month );
        return statisticRepository.findByYearAndMonth(year, month);
    }

    @GetMapping("/total")
    public @ResponseBody Total getTotals() {
        log.info("LOG - GET: statistics TOTAL OVERALL" );
        return totalService.getTotalsOverall();
    }

    @GetMapping("/total/current")
    public @ResponseBody Total getTotalsCurrentYear() {
        log.info("LOG - GET: statistics TOTAL/CURRENT " );
        return totalService.getTotalsCurrentYear();
    }

    @GetMapping("/total/{year}")
    public @ResponseBody Total getTotalsForYear(@PathVariable Integer year) {
        log.info("LOG - GET: statistics TOTAL/YEAR " + year );
        return totalService.getTotalsForYear(year);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Statistic postStatistic(@RequestBody @Valid Statistic statistic) {
        log.info("LOG - POST: statistic CREATED " + statistic.getYear() + " " + statistic.getMonth() );
        return statisticService.postStatistic(statistic);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Statistic changeStatistic(@PathVariable Integer id, @RequestBody @Valid Statistic statistic) {
        log.info("LOG - PUT: statistic CHANGED with id " + id );
        return statisticService.putStatistic(id, statistic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStatistic(@PathVariable Integer id) {
        log.info("LOG - DELETE: statistic DELETED with id " + id );
        statisticService.deleteStatistic(id);
    }
}
