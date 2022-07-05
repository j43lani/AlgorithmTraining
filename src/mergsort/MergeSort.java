package mergsort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] data = {1,2,5,6,3,8,7,9,4};
        int lengthData = data.length;
        MergeSort ms = new MergeSort();
        ms.mergSortMethod(data,lengthData);
    }
    void mergSortMethod(int [] dataArray,int index){
        if(index<2) return;
        int mid = index/2;
        int [] left = new int[mid];
        int [] right = new int[index-mid];

        for(int i = 0; i < mid; i++){
            left[i] = dataArray[i];
        }
        for(int i = 0; i < (index-mid); i++){
            right[i] = dataArray[i+mid];
        }
        mergSortMethod(left,mid);
        mergSortMethod(right,index-mid);
        /*for(int i = mid; i < lengthData; i++){
            right[i] = dataArray[i];
        }*/
//        merge arrays
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mid && j < index-mid){
            if(left[i] <= right[j]){
                dataArray[k++] = left[i++];
            }else{
                dataArray[k++] = right[j++];
            }
        }
        while (i<mid){
            dataArray[k++] = left[i++];
        }
        while(j<index-mid){
            dataArray[k++] = right[j++];
        }

        System.out.println(Arrays.toString(dataArray));
    }
}
