package Builder;

public class Computer {
      private String RAM;
      private String STORAGE;
      private String CPU;
      private  Computer(ComputerBuilder builder){
            this.RAM=builder.RAM;
            this.STORAGE=builder.STORAGE;
            this.CPU=builder.CPU;
      }
      
  public String toString(){
      return "Computer [RAM=" + RAM + ", STORAGE=" + STORAGE + ", CPU=" + CPU + "]";
  }
  // Nested class
static class ComputerBuilder{
      private String RAM;
      private String STORAGE;
      private String CPU;
      public ComputerBuilder setRAM(String ram){
            this.RAM=ram;
            return this;
      }
      public ComputerBuilder setSTORAGE(String storage){
            this.STORAGE=storage;
            return this;
      }
      public ComputerBuilder setCPU(String cpu){
            this.CPU=cpu;
            return this;
      }
      public Computer build(){
            return new Computer(this);
      }
}
}
