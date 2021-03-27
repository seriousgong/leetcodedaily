package exam4

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {

	header := &ListNode{
		Next: head,
	}
	s := header
	f := header
	scnt, lcnt := 0, 0
	for f.Next != nil && f.Next.Next != nil {
		s = s.Next
		f = f.Next.Next
		scnt++
		lcnt += 2
	}
	if f.Next != nil {
		lcnt++
	}
	if lcnt-n > scnt {
		for i := 0; i < lcnt-n-scnt; i++ {
			s = s.Next
		}
		s.Next = s.Next.Next
	} else {
		tmp := header
		for i := 0; i < lcnt-n; i++ {
			tmp = tmp.Next
		}
		tmp.Next = tmp.Next.Next
	}
	return header.Next
}
