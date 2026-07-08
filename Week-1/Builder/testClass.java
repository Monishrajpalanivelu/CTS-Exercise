package Builder;


public class testClass {
      public static void main(String[] args) {
            Computer comp1=new Computer.ComputerBuilder().setRAM("16gb").setSTORAGE("512gb").setCPU("i7").build();
            Computer comp2=new Computer.ComputerBuilder().setRAM("8gb").setSTORAGE("256gb").setCPU("i5").build();
            System.out.println(comp1);
            System.out.println(comp2);
      }
}
