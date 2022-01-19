import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CSI {
    TreeMap<Client,String[]> clientsMap = new TreeMap<>();
    TreeMap<String, Data> dataMap = new TreeMap<>();
    TreeMap<String, TreeMap<String, Data>> archive = new TreeMap<>();
    private boolean shouldContinue = true;
    private Thread t;
    private static Semaphore mutex = new Semaphore(1);

    public void postUpdate() {
        try{
            if (mutex.tryAcquire(100, TimeUnit.MILLISECONDS)){
                for (Map.Entry<Client,String[]> o: clientsMap.entrySet()){
                    Client k = o.getKey();
                    String[] s = o.getValue();
                    for (String miejscowosc:s){
                        k.receive(miejscowosc, dataMap.get(miejscowosc));
                    }
                }
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }


    }


}
