package m5

import "fmt"

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isCousins(root *TreeNode, x int, y int) bool {
	var parent1, val1, deep1 int
	var dfs func(parent, deep int, node *TreeNode) bool
	dfs = func(parent, deep int, node *TreeNode) bool {
		if node == nil {
			return false
		}
		if node.Val == x || node.Val == y {
			if val1 != 0 {
				if deep1 == deep && parent1 != parent {
					return true
				}
				fmt.Printf("node1:%v,parent1:%v,deep1:%v\n", val1, parent1, deep1)
				fmt.Printf("node:%v,parent:%v,deep:%v\n", node.Val, parent, deep)
				return false
			}
			val1 = node.Val
			parent1 = parent
			deep1 = deep
		}
		return dfs(node.Val, deep+1, node.Left) || dfs(node.Val, deep+1, node.Right)
	}
	return dfs(0, 0, root)
}
