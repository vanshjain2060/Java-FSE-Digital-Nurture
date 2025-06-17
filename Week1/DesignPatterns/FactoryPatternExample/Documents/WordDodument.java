package Week1.DesignPatterns.FactoryPatternExample.Documents;

public class WordDodument implements Document{
    @Override
    public void open() {
        System.out.println("Opening Word Docs");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Docs");
    }
}
