package Week1.DesignPatterns.FactoryPatternExample.Factories;

import Week1.DesignPatterns.FactoryPatternExample.Documents.Document;
import Week1.DesignPatterns.FactoryPatternExample.Documents.WordDodument;

public class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new WordDodument();
    }
}
