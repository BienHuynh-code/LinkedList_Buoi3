package mylinkedlist;

import java.util.LinkedList;

public class MyLinkedList {
    public Node head, tail;
    
    public boolean isEmpty(){
        return head == null;
    }
    //Them vao dau toa tau
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;          
        }
    }
    //Them vao cuoi toa tau
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head; //tao ra ban sao cho head
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;     
    }
    public void addIndex(int data, int index){
        Node newNode = new Node(data);
        if(index < 0){
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }

    // BTVN: Viet code cho cac ham sau
    // 1. public int length()
    // 2. public void display()
    // 3. public void deleteFirst()


    public int length(){
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
            return count;
    }

    // public int length2() {
    //     int count;
    //     if (head == null) {
    //         return 0;
    //     } else {
    //         Node temp = head;
    //         While(temp.next != null){
    //             count++;
    //             temp = temp.next;
    //         }
    //         return count;
    //     }
    // }

        public void display(){
            if(head == null) {
                return;
            }
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + "-> ");
                temp = temp.next;
            }
            System.out.println(" ");
        }

        public void deleteFirst(){
            if(isEmpty()){
                return;
            } else{
                head=head.next;
            }
        }

        public void deleteLast(){
            if(head == null) {
               return; 
            }
            //LinkedList chỉ có 1 node
            if(head.next == null){
                deleteFirst();
            }
            //privious ghi lai cai node đứng truoc temp
            Node temp = head; //temp tim ra node cuoi cung de xoa
            Node previous = null; //ghi lai node dung truoc temp
            while(temp.next != null){
                previous = temp;
                temp=temp.next;
            }
            previous.next=null;
        }
        
        public void delete(int index){
             if(index == 0){
                deleteFirst();
                return;
             } else if(index == length()-1){
                deleteLast();
                return;
             } else{
                Node preNodeDNode = head; //tim vi tri muon xoa <tim node tai vitri index>
                for(int i = 1; i < index; i++){
                    preNodeDNode=preNodeDNode.next;
                }
                preNodeDNode.next=preNodeDNode.next.next;
             }
        }

        public Node delete2(int index){
            Node temp = head;
            int count = 0;
            while (temp != null && count < index) {
                count ++;
                head = head.next;
            }
            return head;
        }

        //BTVN1: Viết hàm delete theo while. Hint: dùng count++;
        //BTVN2: Viết cho anh hàm sort() Lớn -> bé;
        //BTVN3:
        // public boolean search(int data){
        //     if(head == null);
        //     return false;
        //     Node temp = head;
        /*
        --temp != null: Sử dụng khi các em muốn cầm tất cả các node trong linkedlist đem ra xử lý, hay làm gì đó. Căn bản là câu lệnh này sẽ bốc từ 
        code đầu tiên đến khi nào kết thúc(temp = null)
        --temp.next = null sử dụng khi các em cần tìm ra cái nốt cuối cùng và gán cho temp 
         */    
        // while(temp !=  null){
        //     if(temp.getData() == data)
        //         return true;
        //     }
        //     return false;
        // }
        
        // public void sort(){
        //     int n = length();
        //     for(int i = 0; i < n - 1; i++){
        //         for(int j = i + 1; j < n; j++){
        //             Node p = searchatPosition(i);
        //             Node q = searchatPosition(j);
        //             if(p.data > q.data){
        //                 int temp = p.data;
        //                 p.data = q.data;
        //                 q.data = temp;
        //             }
        //         }
        //     }
        // }

        public void sort() {
            if (head == null || head.next == null) return; // Kiểm tra danh sách rỗng hoặc chỉ có 1 phần tử
        
            for (Node i = head; i != null; i = i.next) {
                for (Node j = i.next; j != null; j = j.next) {
                    if (i.data < j.data) {  // Đổi chỗ nếu i.data < j.data
                        int temp = i.data;
                        i.data = j.data;
                        j.data = temp;
                    }
                }
            }
        }

        public Node searchatPosition(int index){
            if(index < 0 || index >= length()){
                return null;
            }
            Node temp = head;
            for(int i = 0; i <= index; i++){
                temp = temp.next;
            }
            return temp;
        }

     public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println("AddFirst:");
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.display();

        System.out.println("AddLast:");
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.display();
        System.out.println("length = "+linkedList.length());

        System.out.println("AddIndex:");
        linkedList.addIndex(23, 1);
        linkedList.display();

        System.out.println("DeleteLast:");
        linkedList.deleteLast();
        linkedList.display();

        System.out.println("Delete");
        linkedList.delete(2);
        linkedList.display();

        linkedList.sort();
        linkedList.display();

    }

}
