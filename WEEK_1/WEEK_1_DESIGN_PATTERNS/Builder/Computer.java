public class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private Boolean faceUnlock;
     
    public Computer(Builder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.Storage=builder.Storage;
        this.faceUnlock=builder.faceUnlock;
    }

    public String getCPU(){
        return CPU;
    } 
    public String getRAM(){
        return RAM;
    }
    public String getStorage(){
        return Storage;
    }
    public Boolean isFaceUnlock(){
        return faceUnlock;
    }

    public static class Builder{
        private String CPU;
        private String RAM;
        private String Storage;
        private Boolean faceUnlock;

        public Builder setCPU(String CPU){
            this.CPU=CPU;
            return this;
        }
        public Builder setRAM(String RAM){
            this.RAM=RAM;
            return this;
        }
        public Builder setStorage(String Storage){
            this.Storage=Storage;
            return this;
        }
        public Builder setfaceUnlock(Boolean faceUnlock){
            this.faceUnlock=faceUnlock;
            return this;
        }
       
        public Computer build() {
            return new Computer(this);
        }
        
    }
}
