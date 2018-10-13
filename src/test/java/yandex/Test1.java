package yandex;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader("/Users/aleksejmozzeckov/IdeaProjects/testing/src/test/files/test1.txt"));
        List<Integer> list = new LinkedList<>();
        while(fr.ready()){
            String values = fr.readLine();
            String [] numbers = values.split(",");
            for (String s : numbers)
                list.add(Integer.valueOf(s));  //
        }
        fr.close();

        sort(list);

        System.out.print("По возрастанию: ");
        for(int a : list)
            System.out.print(list.get(a)+" ");

        System.out.println();
        System.out.print("По убыванию: ");
        for (int i=list.size()-1;i>=0;i--)
            System.out.print(list.get(i)+" ");
    }
}
