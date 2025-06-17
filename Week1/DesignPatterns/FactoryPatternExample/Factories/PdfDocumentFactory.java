package Week1.DesignPatterns.FactoryPatternExample.Factories;

import Week1.DesignPatterns.FactoryPatternExample.Documents.Document;
import Week1.DesignPatterns.FactoryPatternExample.Documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument(); 
    }
}
