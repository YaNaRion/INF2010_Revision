package src.main;
import java.util.Random;

public class mergeSort {

	public static void main(String[] args){

        int nombreElement = 40;
        Integer [] tableauASort = new Integer[nombreElement];
        Random rand = new Random();

        for(int i =0; i < tableauASort.length; i++){
            tableauASort[i] = rand.nextInt(1000);
        }
        
        for(int i =0; i < tableauASort.length; i++){
            System.out.println(tableauASort[i]);
        }
        

        long starDuration = System.nanoTime();
        mergeSort(tableauASort);
        long endDuration = System.nanoTime();
        System.out.printf("le sort à pris: " + (endDuration-starDuration) + " nanoSeconde" + '\n');
        
        System.out.println("tableauSort");
        for(int i =0; i < tableauASort.length; i++){
            System.out.println(tableauASort[i]);
        }
        
	}

    public static <AnyType extends Comparable<? super AnyType>> 
    void mergeSort( AnyType [ ] a ) { 

        //Création d’un tableau temporaire, exactement pareil de type et grandeur 
        AnyType [ ] tmpArray = (AnyType[]) new Comparable[ a.length ]; 
        //Appel de mergeSort pour trier tout le tableau a 
        mergeSort( a, tmpArray, 0, a.length - 1 ); 
        }

    private static <AnyType extends Comparable<? super AnyType>> 
    void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray, int left, int right ) { 
        // Si le tableau contient au moins 1 élément 
        if( left < right ) { 
            int center = ( left + right ) / 2; 
            mergeSort( a, tmpArray, left, center );// Trier la partie gauche, center devient le int droite 
            mergeSort( a, tmpArray, center + 1, right );// Trier la partie droite center+ 1 devient le int gauche 
            merge( a, tmpArray, left, center + 1, right ); // Fusionner les deux parties 
        }    
    }

    private static <AnyType extends Comparable<? super AnyType>> 

    void merge( AnyType [ ] a, AnyType [ ] tmpArray, int leftPos, int rightPos, int rightEnd ) { 
        int leftEnd = rightPos - 1; // Extrémité droite de la partie gauche 
        int tmpPos = leftPos; 
        int numElements = rightEnd - leftPos + 1; 
    
        while( leftPos <= leftEnd && rightPos <= rightEnd ) 
            if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 ) 
                tmpArray[ tmpPos++ ] = a[ leftPos++ ]; //le ++ ce fait après l'insersion
            else 
                tmpArray[ tmpPos++ ] = a[ rightPos++ ]; 

        while( leftPos <= leftEnd ) // Copier le reste de la partie gauche soit le while de droite soit le while de gauche va copier le reste l'autre sera dejà à la bonne pos
            tmpArray[ tmpPos++ ] = a[ leftPos++ ]; 
    
        while( rightPos <= rightEnd ) // Copier le reste de la partie de droite 
            tmpArray[ tmpPos++ ] = a[ rightPos++ ]; 
        // Copier le résultat de la fusion dans la partie correspondante du tableau a 
        for( int i = 0; i < numElements; i++, rightEnd-- ) 
            a[ rightEnd ] = tmpArray[ rightEnd ]; 
    } 

}
