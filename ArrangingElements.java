public class ArrangingElements {
    private static int[] putEvensOnLeft(int[] arr){
        int[] res = new int[arr.length];
        int r = arr.length - 1;
        int l = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%2 == 1){
                res[r--] = arr[i];
            }else{
                res[l++] = arr[i];
            }
        }

        return res;
    }


    //using foreach loop
    private static int[] putEvensOnLeftWithForEach(int[] arr){
        int[] res = new int[arr.length];
        int r = arr.length - 1;
        int l = 0;

        for (int a:arr) {
            if(a%2 == 1){
                res[r--] = a;
            }else{
                res[l++] = a;
            }
        }

        return res;
    }

    private static int[] putEvensOnLeftInPlace(int[] arr){
        int i = 0;
        int j = 0;
        while(j<arr.length){
            if(arr[j]%2 == 0){
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i]-arr[j];
                i++;
            }
            j++;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        arr = putEvensOnLeftInPlace(arr);

        for(int a: arr){
            System.out.print(a + " ");
        }
    }


}
