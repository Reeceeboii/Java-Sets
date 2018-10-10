# Java-Sets
Implementation of sets and some basic set operations in Java

**This Java code has the following functionality:**
    *Creation of sets
    *Cardinality of sets
    *Union of sets
    *Intersect of sets
    *Difference of sets
    *Powersets of sets



##How powerset algorithm works##
A Powerset is a set that contains all subsets of a given set; usually denoted as P(A) where A is the set you want the powerset for.
For example, if A = {a, b, c}, then P(A) = {{},a,b,ab,c,ac,bc,abc}. Note that the empty set is always a subset of any set.
The cardinality of a powerset is 2ⁿ where n is the cardinality of the set of which the powerset itself is a derivative. See above. The cardinality of set A is 3, and 2³ is 16, the cardinality of P(A). 

Working this out in Java is as follows:
*Convert the HashSet object to an array, as these are a lot simpler to iterate over.
*
