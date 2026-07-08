package factory;

public class testClass {
      public static void main(String[] args) {
            documentFactory factory = new documentFactory();
            // Doesnt follow open-close principle as it violates Open-Closed Principle (OCP)
            // If we need to add a new document type, we need to modify the existing code
            // document doc = factory.createDocument("PDF");
            // doc.documentType(); 
            // document doc2=factory.createDocument("Word");
            // doc2.documentType();
            // document doc3=factory.createDocument("Excel");
            // doc3.documentType();

            // Better Implementation
            abstractDocumentfactory pdf=new pdfFactory();
            document pdfDoc=pdf.createDocument();
            pdfDoc.documentType();
            abstractDocumentfactory word=new wordFactory();
            document wordDoc=word.createDocument();
            wordDoc.documentType();
            abstractDocumentfactory excel=new excelfactory();
            document excelDoc=excel.createDocument();
            excelDoc.documentType();
      }
}
