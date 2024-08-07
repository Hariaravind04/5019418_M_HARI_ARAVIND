public class BuilderPatternExample {
    public static void main(String[] args) {
        
        Computer basic = new Computer.Builder()
            .setCPU("Intel Core i3")
            .setRAM("4GB")
            .setStorage("256GB SSD")
            .setfaceUnlock(false)
            .build();

        System.out.println("Basic Computer Configuration:");
        System.out.println("CPU: " + basic.getCPU());
        System.out.println("RAM: " + basic.getRAM());
        System.out.println("Storage: " + basic.getStorage());
        System.out.println("Face Unlock: " + basic.isFaceUnlock());

        Computer advance = new Computer.Builder()
            .setCPU("Ryzen AMD 9")
            .setRAM("16GB")
            .setStorage("512Gb SSD")
            .setfaceUnlock(true)
            .build();

            System.out.println("Advanced Computer Configuration:");
        System.out.println("CPU: " + advance.getCPU());
        System.out.println("RAM: " + advance.getRAM());
        System.out.println("Storage: " + advance.getStorage());
        System.out.println("Face Unlock: " +advance.isFaceUnlock());

        
}
}
