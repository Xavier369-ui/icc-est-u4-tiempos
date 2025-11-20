package controllers;

public class SortMethods {

    public void sortBubble(int[] numeros){
        for(int i=0; i<numeros.length; i++){
            for(int j=0; j<numeros.length; j++){
                if(numeros[i] > numeros[j]){
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
    }
    public void sortBubbleAvanzado(int[] numeros){
        int n = numeros.length;
        for(int i = 0; i < n-1; i++){
            boolean swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if(numeros[j] > numeros[j+1]){
                    int temp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public void sortShell(int[] numeros){
        int n = numeros.length;
        for(int gap = n/2; gap > 0; gap /= 2){
            for(int i = gap; i < n; i++){
                int temp = numeros[i];
                int j;
                for(j = i; j >= gap && numeros[j - gap] > temp; j -= gap){
                    numeros[j] = numeros[j - gap];
                }
                numeros[j] = temp;
            }
        }
    }
    public void sortMerge(int[] numeros){
        if(numeros.length < 2){
            return;
        }
        int mid = numeros.length / 2;
        int[] left = new int[mid];
        int[] right = new int[numeros.length - mid];

        System.arraycopy(numeros, 0, left, 0, mid);
        System.arraycopy(numeros, mid, right, 0, numeros.length - mid);

        sortMerge(left);
        sortMerge(right);

        merge(numeros, left, right);
        
    }
    private void merge(int[] numeros, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                numeros[k++] = left[i++];
            } else {
                numeros[k++] = right[j++];
            }
        }
        while(i < left.length){
            numeros[k++] = left[i++];
        }
        while(j < right.length){
            numeros[k++] = right[j++];
        }
    }
    
}
