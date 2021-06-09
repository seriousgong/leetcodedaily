package m6

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	tmp1, tmp2 := headA, headB
	for tmp1 != tmp2 {
		if tmp1 != nil {
			tmp1 = tmp1.Next
		} else {
			tmp1 = headB
		}
		if tmp2 != nil {
			tmp2 = tmp2.Next
		} else {
			tmp2 = headA
		}
	}
	return tmp1
}
