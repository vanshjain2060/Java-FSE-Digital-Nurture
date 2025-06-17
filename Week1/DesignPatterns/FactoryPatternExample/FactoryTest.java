package Week1.DesignPatterns.FactoryPatternExample;

import Week1.DesignPatterns.FactoryPatternExample.Documents.Document;
import Week1.DesignPatterns.FactoryPatternExample.Factories.DocumentFactory;
import Week1.DesignPatterns.FactoryPatternExample.Factories.ExcelDocumentFactory;
import Week1.DesignPatterns.FactoryPatternExample.Factories.PdfDocumentFactory;
import Week1.DesignPatterns.FactoryPatternExample.Factories.WordDocumentFactory;

public class FactoryTest {
    public static void main(String[] args) {
        
        DocumentFactory WordFactory = new WordDocumentFactory();
        Document word = WordFactory.createDocument();
        word.open();
        word.close();
        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
        excel.close();
        System.out.println();

        DocumentFactory PdfFactory = new PdfDocumentFactory();
        Document pdf = PdfFactory.createDocument();
        pdf.close();
        pdf.open();
    }
}
