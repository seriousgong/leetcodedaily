package m3

func deleteDuplicates(head *ListNode) *ListNode {
	header := &ListNode{}
	tmp := header
	for head != nil {
		node := head.Next
		for node != nil && node.Val == head.Val {
			node = node.Next
		}
		if node == head.Next {
			tmp.Next = head
			tmp = tmp.Next
			tmp.Next = nil
		}
		head = node
	}
	return header.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}
