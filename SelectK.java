/**
 * Filename : SelectK.java
 * Created by ktjosh
 *
 * Problem: Finds Kth smallest or largest element in an array of numbers.
 */


class SelectK{

    public static void main(String[] args)
    {

        int[] A = {8,6,11,33,42,5,9,2,0};
        int K = 5;
      System.out.println(select_random(A,K,0,A.length-1));

    }

    /**
     * Function returns the kth smallest or largest element.
     * @param A : array of integers
     * @param K : parameter k of kth element
     * @param start_index : start index of an array
     * @param end_index : end index of an array
     * @return return value : returns the element
     */


    public static int select_random(int[] A, int K, int start_index , int end_index)
    {

        int pivot = A[start_index];
        int left = start_index+1;
        int right = end_index;

        while(left < right)
        {
            while(left<=end_index && pivot > A[left] && left <= right) {

                left++;
              //  System.out.println("left:"+left);
            }

            while (right>=0 && pivot<A[right] && right >= left) {
                right--;
            }
           // System.out.println("right"+right);
            if(left < right)
            {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }


        }
        int temp = A[right];
        A[right]= A[start_index];
        A[start_index]= temp;

        if(K == right)
            return A[right];
        else if(K < right)
        return select_random(A,K,start_index,right-1);
        else
        return select_random(A,K,right+1,end_index);



    }

}