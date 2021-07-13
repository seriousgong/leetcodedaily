package dailypractice

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rob1(root *TreeNode) int {
	var dfs func(node *TreeNode) (int, int)
	dfs = func(node *TreeNode) (int, int) {
		if node == nil {
			return 0, 0
		}
		v1, vv1 := dfs(node.Left)
		v2, vv2 := dfs(node.Right)
		return vv1 + vv2 + node.Val, max(v1, vv1) + max(v2, vv2)
	}
	return max(dfs(root))
}
func max1(a ...int) int {
	res := 0
	for i := 0; i < len(a); i++ {
		if a[i] > res {
			res = a[i]
		}
	}
	return res
}
