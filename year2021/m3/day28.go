package m3

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BSTIterator struct {
	Nodes []int
	index int
}

func Constructor(root *TreeNode) BSTIterator {
	nodes := make([]int, 0)
	var mid func(node *TreeNode)
	mid = func(node *TreeNode) {
		if node != nil {
			mid(node.Left)
			nodes = append(nodes, node.Val)
			mid(node.Right)
		}
	}
	return BSTIterator{
		Nodes: nodes,
	}
}

func (this *BSTIterator) Next() int {
	val := this.Nodes[this.index]
	this.index++
	return val
}

func (this *BSTIterator) HasNext() bool {
	return this.index < len(this.Nodes)
}
