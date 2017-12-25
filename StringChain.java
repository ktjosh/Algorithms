/**
 * Filename : Stringchain.java
 * Created by ktjosh
 *
 * Problem: Considering a dictionary of words, if removing any letter from a word yeilds another word in the doctionary,
 * then thats a string chain,
 * Keep on doing so will increase the size of string chain. find maximum sized string chain
 */
import java.util.Arrays;

class  StringChain {
    public static void main(String[] args) {
/*
        ArrayList<Integer>a = new ArrayList<>();
        a.add(1);
        a.add(7);
        a.add(22);
        a.add(0);
        System.out.println(a.get(0));
        //a.remove();

        System.out.println(a.get(1));

*/

        String[] arr ={"dcba", "dba", "cba", "ba", "b", "a"};
        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
        ;
        stringchain(arr);

    }
    public static void stringchain(String[] arr)
    {

        int[] chain = new int[arr.length];

        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            chain[i] = 1;
            for (int j = i - 1; j > -1; j--) {
                if (arr[i].length() - arr[j].length() > 1)
                    break;
                ;

                if (arr[i].length() - arr[j].length() == 1) {
                    if (one_edit_distance(arr[i], arr[j])) {
                        if (chain[i] < chain[j] + 1) {
                            chain[i] = chain[j] + 1;
                            if (max < chain[i])
                                max = chain[i];
                        }
                    }

                }
            }

        }
        System.out.print(max);

    }

    public static boolean one_edit_distance(String a, String b)
    {
        int i =0;
        int j =0;
        while(i < a.length() && j < b.length())
        {
            if(a.charAt(i)==b.charAt(j))
            {
                i++;
                j++;
            }
            else
                i++;
        }
        if(j== b.length())
            return true;

        return false;
    }
}




