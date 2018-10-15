/*
Reece Mercer
Java sets
Union, Intersect, Difference, Powersets and Cardinality
*/

// all set operations requiring 2 sets take one SetClass object as a parameter

import java.util.*;

class SetClass{
    int[] setValues;
    HashSet<Integer> setVar;

    public SetClass(int setSize){ // SetClass object's zero-arg constructor
        setValues = new int[setSize];
        for(int i = 0; i < setSize; i++){
            int random = (int)(Math.random() * 50 + 1); // set filled with random ints in range (1-50)
            setValues[i] = random;
        }
        // instantiation of new HashSet object
        setVar = new HashSet<Integer>();
    }

    void addValues(){
        for(int i = 0; i < setValues.length; i++){
            setVar.add(setValues[i]);
        }
    }

    void printSet(){
        System.out.println(setVar);
    }

    /*
     * the union operation provides a new set with all unique items from sets A and B
     * 1. a new set containing all set A's elements is created, named unionAB
     * 2. all of set B's elements are added to this set
     * 3. duplicates are automatically removed, leaving us with a set that is the result
     *    of A union B.
     */
    void union(SetClass setObj){
        Set<Integer> unionAB = new TreeSet<Integer>(setVar);
        unionAB.addAll(setObj.setVar);
        System.out.println(unionAB + "\n");

        /*
         * the use of TreeSet rather than HashSet means the sets containing the unions are
         * ordered, making the actual operation of the union easier to see.
         */
    }

    /*
     * the intersect of sets A and B gives a set that contains all the elements that
       both sets have in common
     */
    void intersect(SetClass setObj){
        Set<Integer> intersectAB = new TreeSet<Integer>(setVar);
        intersectAB.retainAll(setObj.setVar);
        System.out.println(intersectAB + "\n");
    }

    /*
     * the difference of sets A and B gives a set that contains all elemets present in A that are
       not present in set B
     */
    void difference(SetClass setObj){
        Set<Integer> differenceAB = new TreeSet<Integer>(setVar);
        differenceAB.removeAll(setObj.setVar);
        System.out.println(differenceAB + "\n");

    }

    /*
     * a powerset is a set of all subsets of a set. For example, creating a powerset of
       set A (usually denoted as P(A)) where A = {a,b,c} gives you a set containing the
       following values:    P(A) = {{},a,b,ab,c,ac,bc,abc}
     * the cardinality of a powerset is always 2 to the power of n, where n is the number
       of elements in the set that the powerset derives from.
     */

    /*
     *** HOW TO PROGRAMMATICALLY GET A POWERSET OF A SET ***
     * An explanation of this algorithm can be found in the readme
       file in the github repo.
     */


    void powerset(int setSize){
        double powersetSize = (Math.pow(2, setSize));
        System.out.println("Powerset will contain " + (int)powersetSize + " elements.");
        Integer[] arraySet = setVar.toArray(new Integer[setVar.size()]);

        for(int counter = 0; counter < powersetSize; counter ++){
            System.out.print("{");
            for(int j = 0; j < setSize; j ++){
                if((counter & (1 << j)) > 0){
                    System.out.print(arraySet[j] + " ");
                }
            }
            if(counter > 0) {
                System.out.print("\b}");
            }else{
                System.out.print("}");
            }
            System.out.println();
        }

    }

    int cardinality(){
        return setVar.size();
    }

}


class Sets{
    public static void main(String[] args){
        SetClass[] setArray = new SetClass[2]; // object array of type SetClass
        for(int i = 0; i < setArray.length; i++) { // creating SetClass objects
            setArray[i] = new SetClass(4);
            setArray[i].addValues();
            System.out.print("Set " + (i+1) + ": ");
            setArray[i].printSet();
            System.out.println("Cardinality (|" + (i+1) + "|) = " + setArray[i].cardinality() + "\n");
        }

        System.out.print("Set 1 union set 2: ");
        setArray[0].union(setArray[1]); // set 1 union with set 2

        System.out.print("Set 1 intersect set 2: ");
        setArray[0].intersect(setArray[1]); // set 1 intersect with set 2

        System.out.print("Set 1 difference set 2: ");
        setArray[0].difference(setArray[1]);

        System.out.print("Powerset of set 1: ");
        setArray[0].powerset(setArray[0].cardinality());

        System.out.print("Powerset of set 2: ");
        setArray[1].powerset(setArray[1].cardinality());
    }

    // test
}