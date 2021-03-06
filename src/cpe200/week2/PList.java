package cpe200.week2;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        PNode tmp = new PNode();
        tmp.data = i;
        tmp.next=null;
        tail.next = tmp;
        tmp.prev = tail;
        tail=tmp;
        size++;
    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char temp = tail.data;
        if(head==tail)
            head=tail=null;
        else
            {tail=tail.prev;
                tail.next = null;
                size--;
            }
                return temp;
    }

    public boolean search(char i) {
        PNode temp = head;
        while(temp!=null)
            {
                if(temp.data == i)
                    return true;
                temp = temp.next;
            }
            return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;
        while(tmp!=head)
            {
                System.out.print(tmp.data);
                tmp = tmp.prev;
            }
            if(tmp!=null)
                System.out.println(tmp.data);
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
