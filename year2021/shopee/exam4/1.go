package exam4

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rightSideView(root *TreeNode) []int {
	res := make([]int, 0)

	var dfs func(node *TreeNode, level int)

	dfs = func(node *TreeNode, level int) {
		if node != nil {
			if level >= len(res) {
				res = append(res, node.Val)
			} else {
				res[level] = node.Val
			}
			dfs(node.Left, level+1)
			dfs(node.Right, level+1)
		}
	}
	dfs(root, 0)
	return res
}
