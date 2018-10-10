# Java-Sets
Implementation of sets and some basic set operations in Java

**This Java code has the following functionality:**

    * Creation of sets
    * Cardinality of sets
    * Union of sets
    * Intersect of sets
    * Difference of sets
    * Powersets of sets



## How powerset algorithm works ##
A Powerset is a set that contains all subsets of a given set; usually denoted as P(A) where A is the set you want the powerset for.
For example, if A = {a, b, c}, then P(A) = {{}, a, b, ab, c, ac, bc, abc}. Note that the empty set is always a subset of any set.
The cardinality of a powerset is 2ⁿ where n is the cardinality of the set of which the powerset itself is a derivative. See above - the cardinality of set A is 3, and 2³ is 16, the cardinality of P(A). 

The main underlying concept that makes this easy to understand is that the cardinality is in powers of 2. And what else is all in powers of 2? Binary! So all we do is generate all the permutations of binary digits up to and including 2ⁿ⁻¹. So, for a set A = {a, b, c}, we have 2³ elements in the powerset (16). 2³⁻¹ gives us 3 bits to work with, and we fill the powerset with sets that contain the elements that match each 1 in the binary sequence: 
* 000 = {}
* 001 = {c}
* 010 = {b}
* 011 = {b, c}
* 100 = {a}
* 101 = {a, c}
* 110 = {a, b}
* 111 = {a, b, c}

The repo contains a pre-compiled .class file, and to execute this, just open a shell or CMD window in the file's directory, or `cd` to the directory containing this file. 
Then type `java Sets` and hit enter to run.
