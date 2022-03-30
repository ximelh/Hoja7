
import java.security.Key;
import java.util.Map;
public class ComparableAssociation<K extends Comparable<K>,V>
    extends Association<K,V>
    implements Comparable<ComparableAssociation<K,V>>
    , Map.Entry<K,V>
{
    /**
     * Construct an association that can be ordered, from only a key.
     * The value is set to null.
     *
     * @pre key is non-null
     * @post constructs comparable association with null value
     * 
     * @param key The (comparable) key.
     */
    public ComparableAssociation(K key)
    {
        this(key,null);
    }

    /**
     * Construct a key-value association that can be ordered.
     *
     * @pre key is non-null
     * @post constructs association between a comparable key and a value
     * 
     * @param key The (comparable) key.
     * @param value The (possibly comparable) associated value.
     */
    public ComparableAssociation(K key, V value)
    {
        super(key,value);
    }

    /**
     * Determine the order of two comparable associations, based on key.
     *
     * @pre other is non-null ComparableAssociation
     * @post returns integer representing relation between values
     * 
     * @param other The other comparable association.
     * @return Value less-than equal to or greater than zero based on comparison
     */
    public int compareTo(ComparableAssociation<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Construct a string representation of the ComparableAssociation.
     *
     * @post returns string representation
     * 
     * @return The string representing the ComparableAssociation.
     */
    public String toString()
    {
        return theKey.toString();
    }

    public boolean equals(ComparableAssociation<K,V> compared){

        boolean equal = theKey.equals(compared.getKey());
        return equal;
    }
}