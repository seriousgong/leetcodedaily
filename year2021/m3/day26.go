package m3

func deleteDuplicates(head *ListNode) *ListNode {
	//return withHeader(head)
	return withoutHeader(head)
}

func withoutHeader(head *ListNode) *ListNode {
	for tmp := head; tmp != nil && tmp.Next != nil; {
		if tmp.Val == tmp.Next.Val {
			tmp.Next = tmp.Next.Next
		} else {
			tmp = tmp.Next
		}
	}
	return head
}

func withHeader(head *ListNode) *ListNode {
	header := &ListNode{}
	for tmp := header; head != nil; {
		if tmp == header || tmp.Val != head.Val {
			tmp.Next = head
			tmp = tmp.Next
		}
		tp := head.Next
		head.Next, head = nil, tp
	}
	return header.Next
}
