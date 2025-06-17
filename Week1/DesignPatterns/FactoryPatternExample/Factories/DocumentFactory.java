package Week1.DesignPatterns.FactoryPatternExample.Factories;

import Week1.DesignPatterns.FactoryPatternExample.Documents.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument();
}
