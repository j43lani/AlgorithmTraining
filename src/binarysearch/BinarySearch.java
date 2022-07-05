package binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] data = {2,4,5,7,8,10,13,14};
        int[] data = {2,4,5,6,7,8,9,10,11,12,13};
        Arrays.sort(data);
        int firstIndex = 0;
        int lastIndex = data.length-1;
        int searchValue = 11;
        BinarySearch bs = new BinarySearch();
//        recursive method
        int result = bs.sortRecrusively(data,firstIndex,lastIndex,searchValue);
        if(result < 0) {
            System.out.println("value not found on array");
        }else {
            System.out.println("value " + searchValue + " found at index " + result);
        }
//        looping method
        bs.sortLooping(data,searchValue);
//        simple method
        bs.simpleSearch(data,searchValue);
    }
    void simpleSearch(int[] dataArray, int searchValue){
        for(int i =0; i < dataArray.length;i++){
            if(dataArray[i]==searchValue){
                System.out.println("data found at index "+i);
                break;
            }
        }
    }
    int sortRecrusively(int[] dataArray, int firstIndex, int lastIndex, int searchValue){
        if(firstIndex <= lastIndex){
            int midIndex = (firstIndex+lastIndex)/2;
            if(dataArray[midIndex]==searchValue)
                return midIndex;
            if(dataArray[midIndex]>searchValue){ // right side
                return sortRecrusively(dataArray,firstIndex,midIndex-1,searchValue);
            }else{ // left side
                return sortRecrusively(dataArray,midIndex+1,midIndex+1,searchValue);
            }
        }
        return -1;
    }
    void sortLooping(int[] dataArray, int searchValue){
        int firstIndex = 0;
        int lastIndex = dataArray.length-1;
        int midIndex = (firstIndex+lastIndex)/2;
        while(firstIndex<=lastIndex){
            if(dataArray[midIndex]<searchValue){
                firstIndex = midIndex+1;
            }else if(dataArray[midIndex]== searchValue){
                System.out.println("element found at index "+midIndex);
                break;
            }else {
                lastIndex = midIndex-1;
            }
            midIndex = (firstIndex+lastIndex)/2;
        }
        if(firstIndex>lastIndex)
            System.out.println("data not fount on certain index");
    }
}
