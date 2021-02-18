package m1

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {

	h, hr := &ListNode{}, &ListNode{}
	var l, r *ListNode = h, hr
	for ; head != nil; head = head.Next {
		if head.Val < x {
			l.Next = head
			l = l.Next
		} else {
			if r == nil {
				r = head
			} else {
				r.Next = head
				r = r.Next
			}

		}
	}
	r.Next = nil
	l.Next = hr
	return h.Next
}
