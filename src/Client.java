import java.util.TreeMap;

public class Client implements Comparable<Client>{
    TreeMap<String, Data> d = new TreeMap<>();
    public void receive(String miejscowosc, Data d){
        this.d.put(miejscowosc, d);
    }

    @Override
    public int compareTo(Client c) {
        return 0;
    }
}
