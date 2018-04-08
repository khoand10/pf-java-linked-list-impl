public class LinkedListImpl<T> implements List<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected int currPos = 0;

    public LinkedListImpl() {
    }

//    public LinkedListImpl(T[] obj) {
//        add(obj);
//    }


    @Override
    public void add(int index, T t) {

    }

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = head;
        head = newNode;
        currPos++;
        if(tail == null)tail = head;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        if(tail == null) head = tail = newNode;
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        currPos++;
    }

    @Override
    public T remove(int index) {
        T val = null;
        if(currPos>=index) return null;
        else if(index == currPos-1)removeLast();
        else if(index == 0) removeFirst();
        else{
            Node<T> curr = head;
            Node<T> prev = null;
            for (int i = 0; i <= currPos; i++) {
                prev = curr;
                curr = curr.getNext();
            }
            val = curr.getData();
            prev.setNext(curr.getNext());
        }
        return val;
    }

    @Override
    public boolean remove(T t) {
        return false;
    }

    @Override
    public int size() {
        return currPos;
    }

    @Override
    public T cloneList() {
//        LinkedListImpl<T> listClone = new LinkedListImpl<>();
//        listClone.head = this.head;
//        listClone.tail = this.tail;
//        for (int i = 1; i < currPos; i++) {
//            listClone.add(get(i));
//        }
        return null;
    }

    @Override
    public boolean contains(T t) {
        boolean result = false;
        Node<T> curr = head;
        int count = 0;
        while (curr != tail){
            if (curr.getData().equals(t)){
                result = true;
            }
            curr = curr.getNext();
            count ++;
        }
        return result;
    }

    @Override
    public int indexOf(T t) {
        int indexOf = 1;
        Node<T> curr = head;
        while (!curr.getData().equals(t)){
            curr = curr.getNext();
            indexOf++;
        }
        return indexOf;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if(tail == null) head = tail = newNode;
        else{
            tail.next = newNode;
            tail = tail.next;
        }
        currPos++;
        return true;
    }

    @Override
    public void ensureCapacity(int minCapacity) {

    }

    @Override
    public T get(int index) {
        if(index >= currPos) {
            throw new RuntimeException("error" + index + ">" + currPos);
        } else {
            Node<T> curr = head;
            for(int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return curr.getData();
        }
    }

    @Override
    public T getFirst() {
        return head.getData();
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = head;
        currPos = 0;
    }

    @Override
    public T removeFirst() {
        if(head == null) return null;
        else{
            T val = head.getData();
            head = head.getNext();
            currPos --;
            return val;
        }
    }

    @Override
    public T removeLast() {
        if(currPos == 0)return null;
        else if(currPos == 1){
            Node<T> temp = head;
            head = tail = null;
            currPos = 0;
            return temp.getData();
        }else{
            Node<T> current = head;
            for (int i = 0; i < currPos - 2; i++) {
                current = current.next;
            }
            Node<T> temp = tail;
            tail = current;
            tail.next = null;
            currPos --;
            return temp.getData();
        }
    }
}
 class Node<T>{
    public Node<T> next;
    public T data;
    public Node(T data){
        this.data = data;
    }

     public Node<T> getNext() {
         return next;
     }

     public void setNext(Node<T> next) {
         this.next = next;
     }

     public T getData() {
         return data;
     }

     public void setData(T data) {
         this.data = data;
     }
 }
