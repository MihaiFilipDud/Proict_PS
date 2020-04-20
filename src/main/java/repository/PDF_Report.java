package repository;

import entity.PlaneSchedule;

import java.util.List;

/**
 * Clasa ce va genera un fisier PDF de raport al planurilor de zbor.
 */
public class PDF_Report implements Report{


    /**
     * Metoda ce va genera raportul
     * @return
     */
    @Override
    public String generateReport(List<PlaneSchedule> schedule) {
        return null;
    }
}
