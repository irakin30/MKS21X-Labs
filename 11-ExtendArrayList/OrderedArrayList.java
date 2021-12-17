public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
    
    public OrderedArrayList() {
        super(); 
    }
    
    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    } 

    private int whereToPlace(T value){
        for(int i = 1; i < size(); i++) {
            if (value.compareTo(get(i)) < 0) {
                return i; 
            }
        }
        return size(); 
    } 

    public boolean add(T t) {
        super.add(whereToPlace(t), t);
        return true;
    } 

    public void add(int index, T t) {
        add(t); 
    } 

    public T set(int index, T t){
        super.remove(index);  
        add(t); 
        return t; 
    }
}
