package m6

func removeElements(head *ListNode, val int) *ListNode {
	header := &ListNode{}
	last := header
	for node := head; node != nil; node = node.Next {
		if node.Val != val {
			last.Next, last = node, last.Next
		}
	}
	last.Next = nil
	return header.Next
}
