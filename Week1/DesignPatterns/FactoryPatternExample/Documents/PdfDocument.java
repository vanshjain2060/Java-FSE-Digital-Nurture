package Week1.DesignPatterns.FactoryPatternExample.Documents;

public class PdfDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening PDF Docs");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Docs");
    }
}
