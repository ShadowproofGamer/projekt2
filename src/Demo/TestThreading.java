package Demo;

public class TestThreading {
    public static void main(String[] args) {
        new TestThreading().run();
    }

    public void run() {
        ThraededObservable1 to1 = new ThraededObservable1();

        User u = new User();
        to1.register(u);
        to1.startObservable();
//        to1.start();

        try {
            Thread.sleep(3000);
            to1.stopObservable();

            to1.waitFinish();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
