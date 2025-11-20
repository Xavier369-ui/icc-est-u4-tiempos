import java.util.List;
import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) throws Exception {

        int[] originalArray = generate(500000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array50000 = new int[50000];
        System.arraycopy(originalArray, 0, array50000, 0, 50000);

        int[] array100000 = new int[100000];
        System.arraycopy(originalArray, 0, array100000, 0, 100000);
        int[] array250000 = new int[250000];
        System.arraycopy(originalArray, 0, array250000, 0, 250000);

        int[][] arrays = {array1000, array50000, array100000};

        SortMethods sM = new SortMethods();

        for (int[] array : arrays) {
            int size = array.length;

            int[] copyBubble = array.clone();
            int[] copyBubbleAv = array.clone();
            int[] copyShell = array.clone();
            int[] copyMerge = array.clone();

            Callable<Void> bubble = () -> {
                sM.sortBubble(copyBubble);
                return null;
            };
            Results rBubble = BenchMarking.medir_tiempo(bubble, size, "BubbleSort");
            System.out.println("Array de tamaño " + size + " - BubbleSort: " + rBubble);

            Callable<Void> bubbleAv = () -> {
                sM.sortBubbleAvanzado(copyBubbleAv);
                return null;
            };
            Results rBubbleAv = BenchMarking.medir_tiempo(bubbleAv, size, "BubbleAvanzado");
            System.out.println("Array de tamaño " + size + " - BubbleAvanzado: " + rBubbleAv);

            Callable<Void> shell = () -> {
                sM.sortShell(copyShell);
                return null;
            };
            Results rShell = BenchMarking.medir_tiempo(shell, size, "ShellSort");
            System.out.println("Array de tamaño " + size + " - ShellSort: " + rShell);

            Callable<Void> merge = () -> {
                sM.sortMerge(copyMerge);
                return null;
            };
            Results rMerge = BenchMarking.medir_tiempo(merge, size, "MergeSort");
            System.out.println("Array de tamaño " + size + " - MergeSort: " + rMerge);

            
        }
    }

    public static int[] generate(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = (int) (Math.random() * 100000);
        }
        return numeros;
    }

    
}
