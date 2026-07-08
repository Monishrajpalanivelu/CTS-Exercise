package factory;

public class excelfactory extends abstractDocumentfactory {
      @Override
      public document createDocument() {
            return new ExcelDocument();
      }
}
