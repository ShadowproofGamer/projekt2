package Demo;

import java.util.ArrayList;
import java.util.List;

public class ThraededObservable1 {

    List<User> users = new ArrayList<>();
    private boolean shouldContinue = true;
    private Thread t;
    private Object usersSemaphore = new Object();

    public ThraededObservable1() {
        t = new Thread(() -> runInternal());
    }

    public void update() {
        synchronized (usersSemaphore) {
            for (User u : users) {
                u.sendNotification();
            }
        }
    }

    public void runInternal() {
        while(shouldContinue) {
            //wykonajPomiar();
            update();
            //postUpdate()... aktualizacja, sprzatniae
            try {

                Thread.sleep(250);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void register(User u) {
        synchronized (usersSemaphore) {
            users.add(u);
        }
    }

    public void startObservable() {
        t.start();
    }

    public void stopObservable() {
        shouldContinue = false;
    }

    public void waitFinish() {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
