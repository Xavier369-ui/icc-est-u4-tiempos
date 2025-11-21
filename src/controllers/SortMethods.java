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
    public void sortInserccion(int[] numeros){
        int n = numeros.length;
        for(int i = 1; i < n; i++){
            int key = numeros[i];
            int j = i - 1;
            while(j >= 0 && numeros[j] > key){
                numeros[j + 1] = numeros[j];
                j = j - 1;
            }
            numeros[j + 1] = key;
        }
    }

    public void sortSeleccion(int[] numeros){
        int n = numeros.length;
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            for(int j = i + 1; j < n; j++){
                if(numeros[j] < numeros[minIdx]){
                    minIdx = j;
                }
            }
            int temp = numeros[minIdx];
            numeros[minIdx] = numeros[i];
            numeros[i] = temp;
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
    public void sortQuick(int[] numeros, int low, int high){
        if(low < high){
            int pi = partition(numeros, low, high);
            sortQuick(numeros, low, pi - 1);
            sortQuick(numeros, pi + 1, high);
        }
    }
    private int partition(int[] numeros, int low, int high){
        int pivot = numeros[high];
        int i = (low - 1);
        for(int j = low; j < high; j++){
            if(numeros[j] < pivot){
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }
        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[high];
        numeros[high] = temp;
        return i + 1;
    }
}
