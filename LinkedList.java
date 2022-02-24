class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
class MyLinkedList {
    Node head;
    int len;
    public MyLinkedList() {
        this.head = null;
        this.len=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=this.len)
            return -1;
        Node curr=this.head;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        
        Node newNode = new Node(val);
        newNode.next=this.head;
        this.head=newNode;
        this.len++;
        //print();
    }
    
    public void addAtTail(int val) {
        if(this.head==null){
            addAtHead(val);
            return;
        }
        Node curr=this.head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=new Node(val);
        this.len++;
        //print();
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>this.len)return;
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==this.len){
            addAtTail(val);
            return;
        }
        Node curr=this.head;
        for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        Node temp = curr.next;
        Node newNode = new Node(val);
        curr.next=newNode;
        newNode.next=temp;
        this.len++;
        //print();
        
    }
    // public int len(){
    //     Node curr = this.head;
    //     int l=0;
    //     while(curr!=null){
    //         l++;
    //         curr=curr.next;
    //     }
    //     return l;
    // }
    public void print(){
        Node curr=this.head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
            System.out.println();
        
    }
    
    public void deleteAtIndex(int index) {
        
        //System.out.println(len());
        if(index<0 || index>=this.len)
            return;
        Node prev=null,curr=this.head;
        for(int i=0;i<index;i++){
            prev=curr;
            curr=curr.next;
        }
        if(prev==null) this.head=this.head.next;
        else
        prev.next=curr.next;
        this.len--;
        //print();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);

 */
