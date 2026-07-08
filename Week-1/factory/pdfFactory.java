package factory;

public class pdfFactory extends abstractDocumentfactory {
      @Override
      public document createDocument() {
            return new pdfDocument();
      }
}
