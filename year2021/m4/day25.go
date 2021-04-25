package m4

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func increasingBST(root *TreeNode) *TreeNode {
	header := &TreeNode{}
	a := header
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		node.Left = nil
		a.Right = node
		a = a.Right
		b := node.Right
		node.Right = nil
		dfs(b)
	}
	dfs(root)
	return header.Right

}
