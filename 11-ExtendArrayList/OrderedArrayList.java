public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
    
    public OrderedArrayList() {
        super(); 
    }
    
    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    } 

    private int whereToPlace(T value){
        int index = size(); 
        
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
