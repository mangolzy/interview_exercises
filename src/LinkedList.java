 /* Definition for singly-linked list.  */
class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/*   conclusion for dummy trick (normally)  :
 *   1. when it's related to delete
 *   2. when dealing with two list to get one new list
 */

public class LinkedList {
	//  reverse list
	//  tricky point : prev initialized as null.. new a next each pass
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;   
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
        }
        return prev;
    }
	
	// reverse from m to n
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	       
	        ListNode start = null;
	        ListNode pre = null;
	        ListNode end = null;
	        ListNode hd = head;
	        for(int i = 1; i <= n; i++){
	            if(i == m-1)
	                pre = hd;
	            if(i == m)
	                start = hd;
	            if(i == n)
	                end = hd;
	                
	            hd = hd.next;
	        }
	        if(pre == null){  // m = 1
	        
	            head = end;
	            
	        }
	        else{
	            pre.next = end;
	            
	        }
	        ListNode newhead = null;         // start play the role as prev in reverse list
	        ListNode cur = start.next;       // head -> (pre) -> start -> end -> rest
	        start.next = end.next;
	        for(int i = 0; i < n-m; i++){
	            ListNode next = cur.next;
	            cur.next = start;
	            start = cur;
	            cur = next;
	        }
	       
	        return head;
	    }
	
	// delete node : given its pointer
	// pay attention to the last pointer
	// 1 -> 2 -> 3 -> 4 ; 3 return 1->2->4
	 public void deleteNode(ListNode node) {
	        if(node == null)
	            return ;
	        if(node.next == null){
	            node = null;
	            return ;
	        }
	        node.val = node.next.val;
	        node.next = node.next.next;
	        
	 }
	 
	 // remove node : given element value
	 // Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	 // Return: 1 --> 2 --> 3 --> 4 --> 5
	 public ListNode removeElements(ListNode head, int val) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode cur = dummy;
	        while(cur.next != null){
	            
	            if(cur.next.val == val)
	                cur.next = cur.next.next;
	            else
	                cur = cur.next;
	            
	        }
	        return dummy.next;
	 }
	
	
	// delete duplicate, make all element distinct
		//   1-1-2-2-3-4
		//   1-2-3-4
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null && head.next != null){
            
            if(head.next.val == head.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return dummy.next;
    }
	
	// delete duplicate, but don't keep one sample of elements that shown more than once
	// sorted list
	
	public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode dummy = new ListNode(-1);
        ListNode cur = pHead;
        ListNode pre = dummy;
        dummy.next = pHead;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
                 
            }
            else{
                pre = cur;
                cur = cur.next;
                
            }
                 
        }
        return dummy.next;
    }
	
	// remove from end 
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int len = 0;
        
        while(fast.next != null && len < n){
            fast = fast.next;
            len++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        // ... -> slow -> del ->.. -> fast(null)
    
        if(slow.next != null)
            slow.next = slow.next.next;
        
        return dummy.next;
    }
	
	// first common point // interaction of two list
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        int lena = 0, lenb = 0;
        while(a != null){
            a = a.next;
            lena ++;
        }
        while(b != null){
            b = b.next;
            lenb ++;
        }
        int gap = lena > lenb?lena-lenb:lenb-lena;
        
        if(lena > lenb){
            while(gap-- > 0)
                headA = headA.next;
        }
        else{
            while(gap-- > 0)
                headB = headB.next;
        }
        while(headA != null && headB != null){
            if(headA.val == headB.val)
                return headA;
            else{
                headA = headA.next;
                headB = headB.next;
            }
                
        }
        return null;
    }
	
	// merge two sorted list
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
       ListNode dummy = new ListNode(0);
       ListNode cur = dummy;
   
       
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            
        }
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        return dummy.next;
    }
	
	// add two numbers
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int up = 0;
       
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
        
           
            cur.next = new ListNode((up + l1.val + l2.val) % 10);
            up = (up + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            
            cur = cur.next;
            
        }
        while(l1 != null){
            cur.next = new ListNode( (up + l1.val) % 10);
            up = (up + l1.val) / 10;
            l1 = l1.next;
            
            cur = cur.next;
        }
            
        while(l2 != null){
            cur.next = new ListNode((up + l2.val) % 10);
            up = (up + l2.val) / 10;
            l2 = l2.next;
            
            cur = cur.next;
        }
        if(up != 0)
           cur.next  = new ListNode(up);
        
        return dummy.next;
    }
 
	
	// palindrome
	
	// first do a reverse from until mid..
	// then compare
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
     
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        while(p2.next != null && p2.next.next != null){
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }                                //p3->p1->p2
        
        if(p2.next == null)  // odd?   move from the mid to one lefter..
            p1 = p1.next;
        else                       // p1 -> ..    ; p3 ->
            ;
            
        while(p3 != null){
            if(p3.val != p1.val)
                return false;
            p3 = p3.next;
            p1 = p1.next;
        }
        return true;
    }
	
	// odd-even swap
	// Given 1->2->3->4->5->NULL,
	// return 1->3->5->2->4->NULL.
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
	
	// swap neighbours
	// Given 1->2->3->4, you should return the list as 2->1->4->3.
	 public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode pre = dummy;
	        ListNode first = head;
	        ListNode second = head.next;
	        while(first != null && first.next != null){
	            pre.next = second;
	            first.next = second.next;
	            second.next = first;
	        
	            pre = first;
	            first = first.next;
	            if(first != null)
	                second = first.next;
	        }
	        return dummy.next;
	        
	    }
	 
	 // circles
	 public boolean hasCycle(ListNode head) {
	        ListNode fast = head;
	        
	        while(fast != null && fast.next != null){
	            fast = fast.next.next;
	            head = head.next;
	            if(head == fast)
	                return true;
	        }
	        return false;
	    }
	 
	 // detect from which point the circle starts
	 
	 public ListNode detectCycle(ListNode head) {
	       
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast != null && fast.next != null){
	            fast = fast.next.next;
	            slow = slow.next;
	            if(fast == slow){   // actually, it comes in the circle  but not necessary at the begining of the circle
	                                // so we have to find the start point here
	                ListNode start = head;
	                while(start != slow){
	                    start = start.next;
	                    slow = slow.next;
	                }
	                return slow;
	            }
	                
	        }
	        return null;
	    }
	 
	 // rotate list ... we also has rotate array
	 
	 public ListNode rotateRight(ListNode head, int k) {
	        if(k==0||head==null) return head;
	        ListNode fast = head;
	        ListNode slow = head;
	        int len = 0;
	        while(fast !=null && len < k){
	            fast = fast.next;
	            len++;
	        }
	        if(fast == null)
	            return rotateRight(head, k % len);
	        while(fast.next != null){
	            fast = fast.next;
	            slow = slow.next;
	        }
	        fast.next = head;
	        head = slow.next;
	        slow.next = null;
	        return head;
	        
	        
	    }
}
