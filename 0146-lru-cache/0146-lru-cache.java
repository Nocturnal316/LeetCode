class LRUCache {
    
    public class Node{
        int val;
        int key;
        Node next;
        Node prev;
    }
    
    int cap;
    int size;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        moveToHead(node); 
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
             node = new Node();
            node.key = key;
            node.val = value;
            map.put(key,node);
            addNode(node);
            size+=1;
            if(size > cap){
                Node n =  tail.prev;
                removeNode(n);
                map.remove(n.key);
                size-=1;
            }
        }else{
            node.val = value;
            moveToHead(node); 
        }
    }
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void moveToHead(Node node){
        
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */