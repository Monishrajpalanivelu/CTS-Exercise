package factory;

public class wordFactory extends abstractDocumentfactory {
      @Override
      public document createDocument() {
            return new WordDocument();
      }
}
