class MyHashSet {
    
    class Entry{
        int key;
        Entry next;
        Entry(int key){
            this.key = key;
            this.next = null;
        }
    }
    private Entry buckets[];

    public MyHashSet() {
        this.buckets = new Entry[100000];
    }
    public int hashFunc(int key){
        return key%100000;
    }
    public void add(int key) {
        int index = hashFunc(key);
        Entry curr = buckets[index];
        while(curr!=null){
            if(curr.key == key)
                return;
            curr=curr.next;
        }
        Entry newEntry = new Entry(key);
        newEntry.next=buckets[index];
        buckets[index]=newEntry;

    }
    
    public void remove(int key) {
        int index = hashFunc(key);
        Entry curr = buckets[index];
        Entry prev=null;
        while(curr!=null){
            if(curr.key==key){
                if(prev==null){
                    buckets[index]=curr.next;
                }else{
                    prev.next=curr.next;
                }
                prev=curr;
                curr=curr.next;
                return;
            }
        }
        
        
    }
    
    public boolean contains(int key) {
        int index = hashFunc(key);
        Entry curr = buckets[index];
        while(curr!=null){
            if(curr.key==key)return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
