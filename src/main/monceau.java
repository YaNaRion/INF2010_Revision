package src.main;

import java.util.Random;

public class monceau {

    public int array[];
    public int currentSize;

    public <AnyType extends Comparable<? super AnyType>>
    void insert( AnyType x ) {  
    if( currentSize == array.length - 1 )
        enlargeArray( array.length * 2 + 1 );
        // Percolate up
    int hole = ++currentSize;
    for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2)
        array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }

    /**
    * Remove the smallest item from the priority queue.
    * @return the smallest item, or throw UnderflowException, if empty.
    */
    public <AnyType extends Comparable<? super AnyType>>
    AnyType deleteMin( ) {

    //if( isEmpty( ) )
    //    throw new UnderflowException( );

    AnyType minItem = findMin( );
    array[ 1 ] = array [currentSize-- ];
    percolateDown( 1 );
    return minItem;
    }

    /**
    * Internal method to percolate down in the heap.
    * @param hole the index at which the percolate begins.
    */
    private <AnyType extends Comparable<? super AnyType>>
    void percolateDown( int hole ) {
        int child;
        AnyType tmp = array[ hole ];
        for( ; hole * 2 <= currentSize; hole = child ) {
            child = hole * 2; //Considérer fils de gauche
            if( child != currentSize && array[ child + 1 ].compareTo( array[ child ] ) < 0 ) //et fils droit<fils gauche
                child++; //Considérer fils droit
                if( array[ child ].compareTo( tmp ) < 0 )//fils considéré< élément à percoler
                    array[ hole ] = array[ child ];//Remonter le fils courrent de un niveau
                else
                    break; //sortir de la boucle. L’élément à percoler sera inséré à position hole
        }
        array[ hole ] = tmp; // Insérer l’élément à percoler à la position hole
    }

    public <AnyType extends Comparable<? super AnyType>>
    AnyType findMax( ) {
        AnyType max = array[1];
        for( int i = currentSize/2 + 1; i <= currentSize; i++ ) {
            if ( array[i].compareTo (max) > 0 )
                max = array[i];
        }
        return max;
        }
}