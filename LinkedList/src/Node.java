public class Node {
    int data;
    public Node next;
    public Node front;

    void init(){
        front = null;
    }

    Node makeNode(int num){
        Node n = new Node();
        n.data = data;
        n.next = null;
        return n;
    }

    Node findTail(){
        Node current;
        current = front;
        while(current!=null){
            current = current.next;
        }
        return current;
    }

    void basicMe(int numNode){
        Node tail;
        init();
        for(int i=0; i<numNode; i++){
            if(i ==0){
                front = makeNode(i);
            }else {
                tail = findTail();
                tail.next = makeNode(i);
            }
        }
    }

    void showList(){
        Node current;
        current = front;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void main(String[] args) {
        Node n = new Node();
        basicMe(10);
        showList();
    }
}
