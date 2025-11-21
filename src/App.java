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

        int[][] arrays = { array1000, array50000, array100000, array250000 };

        SortMethods sM = new SortMethods();

        for (int[] array : arrays) {
            int size = array.length;

            Callable<Void> bubble = () -> {
                sM.sortBubble(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - BubbleSort: " + BenchMarking.medir_tiempo(bubble, size, "BubbleSort"));

            Callable<Void> bubbleAv = () -> {
                sM.sortBubbleAvanzado(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - BubbleAvanzado: " + BenchMarking.medir_tiempo(bubbleAv, size, "BubbleAvanzado"));

            Callable<Void> shell = () -> {
                sM.sortShell(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - ShellSort: " + BenchMarking.medir_tiempo(shell, size, "ShellSort"));

            Callable<Void> merge = () -> {
                sM.sortMerge(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - MergeSort: " + BenchMarking.medir_tiempo(merge, size, "MergeSort"));

            Callable<Void> insertion = () -> {
                sM.sortInserccion(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - InsertionSort: " + BenchMarking.medir_tiempo(insertion, size, "InsertionSort"));

            Callable<Void> selection = () -> {
                sM.sortSeleccion(array.clone());
                return null;
            };
            System.out.println("Array " + size + " - SelectionSort: " + BenchMarking.medir_tiempo(selection, size, "SelectionSort"));

            Callable<Void> quick = () -> {
                int[] copy = array.clone();
                sM.sortQuick(copy, 0, copy.length - 1);
                return null;
            };
            System.out.println("Array " + size + " - QuickSort: " + BenchMarking.medir_tiempo(quick, size, "QuickSort"));
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
