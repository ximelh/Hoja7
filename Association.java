/**
 * Association
 */
public class Association<K,V> {
    protected K theKey; // the key of the key-value pair
    protected V theValue; // the value of the key-value pair
    
    
    /*
    for example:
    Association<String,Integer> personAttribute =
    new Assocation<String,Integer>("Age",34);
    */
    public Association(K key, V value){
        if (key != null) {
            theKey = key;
            theValue = value;
        }
    }

    /**
     * Returns the value
     * @return
     */
    public V getValue(){
        return theValue;
    }

    /**
     * Key getter
     * @return
     */
    public K getKey(){
        return theKey;
    }

    /**
     * Sets association's value to value
     * @param value
     * @return
     */
    public V setValue(V value){
        theValue = value;
        return theValue;
    }
    
}