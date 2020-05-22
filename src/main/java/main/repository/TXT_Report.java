package main.repository;


import main.entity.PlaneSchedule;

import java.io.*;
import java.util.List;

/**
 * Clasa ce va genera un fisier TXT de raport al planurilor de zbor.
 */

public class TXT_Report implements Report {

    /**
     * Metoda ce va genera raportul
     * @return
     */
    @Override
    public String generateReport(List<PlaneSchedule> schedule) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("FlightsReport.txt"), "utf-8"))) {
            for(PlaneSchedule flight:schedule) {
                writer.write(flight.toString()+"\n\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Wrote a TXT report!";
    }
}
