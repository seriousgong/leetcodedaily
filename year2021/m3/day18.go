package m3

//Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	return loop(head, left, right)
	//return recursion(head, left, right)
}

/*迭代*/
func loop(head *ListNode, left int, right int) *ListNode {
	header := &ListNode{
		Val:  -1,
		Next: head,
	}
	lh, count := header, 1
	for ; head != nil && count != left; count++ {
		lh = head
		head = head.Next
	}
	if leftN := head; head != nil {
		for ; head != nil; count++ {
			tmp := head
			head = head.Next
			tmp.Next = lh.Next
			lh.Next = tmp
			if count == right {
				break
			}
		}
		leftN.Next = head
	}
	return header.Next
}

/*递归*/
func recursion(head *ListNode, left int, right int) *ListNode {
	var f func(head *ListNode, count int) (*ListNode, *ListNode)
	f = func(head *ListNode, count int) (*ListNode, *ListNode) {
		if count > right || head == nil {
			return head, nil
		}
		if count >= left && count < right {
			tmp, tmp2 := f(head.Next, count+1)
			head.Next = tmp2.Next
			tmp2.Next = head
			return tmp, head
		} else {
			t1, _ := f(head.Next, count+1)
			head.Next = t1
			return head, head
		}
	}
	res, _ := f(head, 1)
	return res
}
