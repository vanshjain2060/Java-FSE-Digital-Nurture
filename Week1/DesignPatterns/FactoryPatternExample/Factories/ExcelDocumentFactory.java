package Week1.DesignPatterns.FactoryPatternExample.Factories;

import Week1.DesignPatterns.FactoryPatternExample.Documents.Document;
import Week1.DesignPatterns.FactoryPatternExample.Documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
