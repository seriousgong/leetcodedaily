package d12

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	result := make([][]int, 0)
	queue1 := make([]*TreeNode, 0)
	queue2 := make([]*TreeNode, 0)

	queue1 = append(queue1, root)
	for len(queue1) > 0 || len(queue2) > 0 {
		level1 := make([]int, 0)
		for i := len(queue1); i >= 0; i-- {
			node := queue1[i]
			if node != nil {
				level1 = append(level1, node.Val)
				queue2 = append(queue2, node.Left, node.Right)
			}
		}
		queue1 = queue1[:0]
		if len(level1) != 0 {
			result = append(result, level1)
		}
		level2 := make([]int, 0)
		for i := len(queue2) - 1; i >= 0; i-- {
			node := queue2[i]
			if node != nil {
				level2 = append(level2, node.Val)
				queue1 = append(queue1, node.Right, node.Left)
			}
		}
		queue2 = queue2[:0]
		if len(level2) != 0 {
			result = append(result, level2)
		}

	}
	return result
}
