package src.main;

import java.util.Random;

public class quickSort {

	public static void main(String[] args){
        System.out.println("xD");

        int nombreElement = 1000;
        Integer [] tableauASort = new Integer[nombreElement];
        Random rand = new Random();


        for(int i =0; i < tableauASort.length; i++){
            tableauASort[i] = rand.nextInt(10000);
        }
        /*        
        for(int i =0; i < tableauASort.length; i++){
            System.out.println(tableauASort[i]);
        }
         */
        

        long starDuration = System.nanoTime();
        quicksort(tableauASort);
        long endDuration = System.nanoTime();
        System.out.printf("le sort à pris: " + (endDuration-starDuration) + " nanoSeconde" + '\n');
        
        /*
        System.out.println("tableauSort");
        for(int i =0; i < tableauASort.length; i++){
            System.out.println(tableauASort[i]);
        }
         */


    }

    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a ) {
        //Appel de Quicksort pour trier tout le tableau a
        quicksort( a, 0, a.length - 1 );
    }
    /**
    2 * Internal quicksort method that makes recursive calls.
    3 * Uses median-of-three partitioning and a cutoff of 10.
    4 * @param a an array of Comparable items.
    5 * @param left the left-most index of the subarray.
    6 * @param right the right-most index of the subarray.
    7 */
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right ) {
            // Si suffisamment grand
        if( left + 10 <= right ) { //10 etait CUTFF, car si le array est trop petit il est plus efficace de le trier avec un algorythme simple
            AnyType pivot = median3( a, left, right ); //trouvon le pivot
            // Début du partitionnement du tableau a en fonction du pivot
            int i = left, j = right - 1; // i à l’extrémité gauche et j à l’extrémité droite (-1)
            for( ; ; ) {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { } //trouvons le premier élément dans la partie de gauche qui est plus grand que le pivot
                while( a[ --j ].compareTo( pivot ) > 0 ) { } //trouvons le premier élément dans la partie de droite qui est plus petit que  le pivot
                if( i < j )
                    swapReferences( a, i, j ); // permuter a[i] et a[j] on échange le premier élément de gauche qui est plus grand que le pivot et le premier élément de 
                                               // droite qui est plus petit que le pivot
                else
                    break; // sortir de la boucle car la partition du tableau est terminée, car à guache du pivot il y a que des < pivots et à droite > pivot
                }
            swapReferences( a, i, right - 1 ); // Permute a[i] et pivot (en rapport avec le dernier swapReferance)
            quicksort( a, left, i - 1 ); // Trier les éléments <= pivot
            quicksort( a, i + 1, right ); // Trier les éléments >= pivot
            } // Sinon tri par insertion
        else
            insertionSort( a, left, right );
    }

    private static <AnyType extends Comparable<? super AnyType>> //fonction fait maison
    void insertionSort(AnyType[] a, int left, int right) {
        int j;
        for(int p = left + 1; p < right + 1; p++){
            AnyType temp = a[p];

            for ( j = p ; j > left && temp.compareTo(a [j - 1]) < 0; j-- ){
                a[j] = a[j-1];
            }

            a[j] = temp;
        }
    }

    /**
    * Retourne une médiane de left, center et right.
    * Tri ses trois éléments comme suit: 1: le plus petit dans la position left
    * 2: le plus grand dans la position right
    * 3: le pivot dans la position right -1
    */
    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right ) {
        int center = ( left + right ) / 2; //on prend l'indice médiant
        if( a[ center ].compareTo( a[ left ] ) < 0 ) swapReferences( a, left, center ); // si l'élément médiant est plus petit que l'élément 
        if( a[ right ].compareTo( a[ left ] ) < 0 ) swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 ) swapReferences( a, center, right );
        //Les trois if font en sorte que l'élément à l'indice left est sur d'être le plus petit, que celui le plus à droite est le plus grand et que le centre soit entre les deux
        
        // Place le pivot à la position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void swapReferences(AnyType[] a, int x, int y){
        AnyType temp = a[y];
        a[y] = a[x];
        a[x] = temp;

    }
}