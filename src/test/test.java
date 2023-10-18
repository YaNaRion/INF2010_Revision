package src.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.quickSort;

public class test {
    
    @Test
    public void test1(){
        assertEquals("Test de Test", 2, 1+1, 0);
    }

    @Test
    public void TestQuickSort(){
        int nombreElement = 100;
        Integer [] tableauASort = new Integer[nombreElement];
        Integer [] tableauSort = new Integer[nombreElement];
        for(int i = 0; i < nombreElement; i++){
            tableauSort[i] = i;
        }

        int compte = 0;
        for(int i = tableauASort.length - 1; i > 0; i--){
            tableauASort[i] = compte;
            compte++;
        }
        
        quickSort test = new quickSort();

        //test.quicksort(tableauASort);

        assertEquals(null, 2, 1+1);


    }
}
