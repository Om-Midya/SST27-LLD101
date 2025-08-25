public class Demo08 {
    public static void main(String[] args) {
        Bicycle v = new Bicycle();
//        v.startEngine(); // won't crash, since now the error is at Compile time
        v.pedal(10);
    }
}
