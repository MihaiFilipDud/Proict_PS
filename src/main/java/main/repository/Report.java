package main.repository;

import main.entity.PlaneSchedule;

import java.util.List;

/**
 * Interfata comuna a raporturilor.
 */
public interface Report {
    String generateReport(List<PlaneSchedule> schedule);
}
