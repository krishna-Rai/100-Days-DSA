class MyHashMap {
    class Entry{
        int key,value;
        Entry next = null;
        Entry(int key,int value){
            this.key = key;
            this.value = value;
            this.next=null;
        }
    }
    Entry buckets[];
    int cap;
    int size;
    public MyHashMap() {
        this.size=0;
        this.cap = 10000;
        buckets = new Entry[cap];
    }
    
    public void put(int key, int value) {
        int index = key%this.cap;
        Entry curr = buckets[index];
        while(curr!=null){
            if(curr.key==key){
                curr.value=value;
                return;
            }
            curr=curr.next;
        }
        
        Entry newEntry = new Entry(key,value);
        newEntry.next=buckets[index];
        buckets[index]=newEntry;
        this.size++;
    }
    
    public int get(int key) {
        int index = key%this.cap;
        Entry curr = buckets[index];
        while(curr!=null){
            if(curr.key==key){
                return curr.value;
            }
            curr=curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key%this.cap;
        Entry curr = buckets[index];
        Entry prev = null;
        while(curr!=null){
            if(curr.key==key){
                if(prev==null){
                    buckets[index]=buckets[index].next;
                }else{
                    prev.next=curr.next;
                }
                this.size--;
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
