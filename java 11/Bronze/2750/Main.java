import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        ArrayList<Integer> newList = new ArrayList<>();
        for(Integer val : list) {
            if(!newList.contains(val)) {
                newList.add(val);
            }
        }

        Collections.sort(newList);
        for(Integer val : newList) {
            System.out.println(val);
        }
        
    }
}