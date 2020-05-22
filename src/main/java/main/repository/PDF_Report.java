package main.repository;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import main.entity.PlaneSchedule;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("FlightsReport.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for(PlaneSchedule flight:schedule) {
            Chunk chunk = new Chunk(flight.toString()+"\n\n", font);
            try {
                document.add(chunk);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        document.close();

        return "Wrote a PDF report!";
    }
}
