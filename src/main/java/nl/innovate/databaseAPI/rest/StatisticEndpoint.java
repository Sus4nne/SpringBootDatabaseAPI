package nl.innovate.databaseAPI.rest;

import lombok.extern.slf4j.Slf4j;
import nl.innovate.databaseAPI.controller.StatisticRepository;
import nl.innovate.databaseAPI.controller.StatisticService;
import nl.innovate.databaseAPI.controller.TotalRepository;
import nl.innovate.databaseAPI.model.Statistic;
import nl.innovate.databaseAPI.model.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
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
    public StatisticEndpoint(StatisticRepository statisticRepository) {
        log.info("LOG - Hier komt ie 1. ");
        this.statisticRepository = statisticRepository;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Statistic> getStatistics() {
        log.info("LOG - GET: statistieken - Aanroep voor het ophalen van alle statistieken. ");
        return statisticRepository.findAll();
    }

    @GetMapping("/year/{year}")
    public @ResponseBody List<Statistic> getYear(@PathVariable Integer year) {
        return statisticRepository.findByYear(year);
    }

    @GetMapping("/month/{month}")
    public @ResponseBody List<Statistic> getMonthFromYear(@PathVariable Integer month) {
        return statisticRepository.findByMonth(month);
    }

    @GetMapping("/{year}/{month}")
    public @ResponseBody List<Statistic> getMonthFromYear(@PathVariable Integer year, @PathVariable Integer month) {
        return statisticRepository.findByYearAndMonth(year, month);
    }

    @GetMapping("/total")
    public @ResponseBody List<Integer[]> getTotals() {
        return totalRepository.sumValues();
    }

    @GetMapping("/total/current")
    public @ResponseBody Total getTotalsCurrentYear() {
        return statisticService.getTotalsCurrentYear();
    }

    @GetMapping("/total/{year}")
    public @ResponseBody Total getTotalsForYear(@PathVariable Integer year) {
        return statisticService.getTotalsForYear(year);
    }
    //zoekfunctie uit de service aanroepen op de service object


}
