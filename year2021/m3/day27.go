package m3

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || k == 0 {
		return head
	}
	res, cnt, last := head, 0, head
	for ; head != nil; cnt++ {
		last, head = head, head.Next
	}
	last.Next = res
	move := cnt - k%cnt
	for ; move > 0; move-- {
		last = last.Next
	}
	res, last.Next = last.Next, nil
	return res
}
