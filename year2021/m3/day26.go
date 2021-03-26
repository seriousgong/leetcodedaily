package m3

func deleteDuplicates(head *ListNode) *ListNode {
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
