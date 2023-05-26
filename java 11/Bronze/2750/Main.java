import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        HashSet<Integer> hs = new HashSet<Integer>(list);
        
        list.sort(Comparator.naturalOrder());
        list.clear();
        list.addAll(hs);
        
        hs.clear();

        for(Integer val : list) {
            System.out.println(val);
        }
        
    }
}