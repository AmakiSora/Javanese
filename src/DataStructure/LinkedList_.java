package DataStructure;

/**
 * 链表
 */
public class LinkedList_ {
    public Node head;    		//头结点
    private int size;			//链表元素个数

    public LinkedList_(){//构造函数
        this.head = null;
        this.size = 0;
    }
    public class Node{//节点
        public String str;
        public Node next;
        public Node(String str,Node next){
            this.str = str;
            this.next = next;
        }
        public Node(String str){
            this(str,null);
        }
    }
    public void addFirst(String str){//链表头部添加元素
        Node node = new Node(str);	//节点对象
        node.next = this.head;
        this.head = node;
        //this.head = new Node(e,head);等价上述代码
        this.size++;
    }
    public void addLast(String str){//向链表尾部插入元素
        this.add(str, this.size);
    }

    public void add(String str,int index){//向链表中间插入元素
        if (index <0 || index >size){
            throw new IllegalArgumentException("链表长度出错");
        }
        if (index == 0){
            this.addFirst(str);
            return;
        }
        Node preNode = this.head;
        //找到要插入节点的前一个节点
        for(int i = 0; i < index-1; i++){
            preNode = preNode.next;
        }
        Node node = new Node(str);
        //要插入的节点的下一个节点指向preNode节点的下一个节点
        node.next = preNode.next;
        //preNode的下一个节点指向要插入节点node
        preNode.next = node;
        this.size++;
    }
    public void insert(String str,String des){//在某个元素前面插入,如果没有就不插入
        //构造虚拟头结点，并且下一个结点指向head
        Node dummy = new Node(null,this.head);
        //构造要插入的结点
        Node dNode = new Node(des);
        //声明变量cur指向虚拟头结点
        Node cur = dummy;
        while(cur.next != null){
            if(cur.next.str.equals(str)){
                dNode.next = cur.next;
                cur.next = dNode;
                this.size++;
                break;
            }
            else {
                cur = cur.next;
            }
        }
        this.head = dummy.next;
    }
    public void remove(String str){//删除链表元素
        int s = size;
        if(head == null){
            System.out.println("无元素可删除");
            return;
        }
        //要删除的元素与头结点的元素相同
        while(head != null && head.str.equals(str)){
            head = head.next;
            this.size--;
        }
        //上面已经对头节点判别是否要进行删除
        //所以要对头结点的下一个结点进行判别
        Node cur = this.head;
        while(cur != null && cur.next != null){
            if(cur.next.str.equals(str)){
                this.size--;
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        if (s==size){
            System.out.println(str+"不存在");
        }
    }
    public String removeFirst(){//删除链表第一个元素
        if(this.head == null){
            System.out.println("无元素可删除");
            return null;
        }
        Node delNode = this.head;
        this.head = this.head.next;
        delNode.next =null;
        this.size--;
        return delNode.str;
    }

    public String removeLast(){//删除链表的最后一个元素
        if(this.head == null){
            System.out.println("无元素可删除");
            return null;
        }
        //只有一个元素
        if(size == 1){
            return this.removeFirst();
        }
        Node cur = this.head;	//记录当前结点
        Node pre = this.head;	//记录要删除结点的前一个结点
        while(cur.next != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        this.size--;
        return cur.str;
    }
    public boolean contains(String str){//链表中是否包含某个元素
        Node cur = this.head;
        while(cur != null){
            if(cur.str.equals(str)){
                return true;
            }
            else {
                cur = cur.next;
            }
        }
        return false;
    }
    public Node getNode(int n){//返回链表的一个节点
        Node node = this.head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node;
    }
    public void setNode(Node o,int n){//设置链表n个位置的节点的下一个节点(bug:size未考虑)
        Node node = this.head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        node.next = o;
    }
    public void show(){//遍历输出
        if (head==null){
            System.out.println("无链表");
            return;
        }
        Node n = head;
        System.out.println(n.str);
        while (n.next!=null){
            n = n.next;
            System.out.println(n.str);
        }
    };
    public void test(){//测试
        show();
        addFirst("11");
        addLast("222");
        addLast("3333");
        addLast("44444");
        addLast("555555");
        show();
    }
}
