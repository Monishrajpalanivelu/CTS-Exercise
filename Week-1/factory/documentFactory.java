package factory;

public class documentFactory {
      public document createDocument(String str){
            if(str.equals("PDF"))return new pdfDocument();
            if(str.equals("Word"))return new WordDocument();
            if(str.equals("Excel"))return new ExcelDocument();
            return null;       
      }
}
