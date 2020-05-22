package main.repository;

/**
 * Clasa de Fcatory ce se va ocupa cu crearea unui obiect de tipul potrivit.
 */
public class ReportFactory {
    /**
     * Metoda ce va returna un obiect de tip Raport in functie de tipul de fisier dat ca parametru.
     * @param type
     * @return
     */
    public Report getReport(String type){
        if(type.equalsIgnoreCase("pdf")){
            return new PDF_Report();
        }else if(type.equalsIgnoreCase("txt")){
            return new TXT_Report();
        }
        return null;
    }
}
