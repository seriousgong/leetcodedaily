package m7

import (
	"fmt"
	"sort"
	"strconv"
	"testing"
)

func Test714(t *testing.T) {
	verticalTraversal(&TreeNode{
		1,
		&TreeNode{
			2, nil, nil,
		},
		&TreeNode{
			3, nil, nil,
		},
	})
}

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func verticalTraversal(root *TreeNode) [][]int {
	res := make([][]int, 0)
	min, max, level := 0, 0, 0
	mp := map[string][]int{}
	var dfs func(node *TreeNode, x, y int)
	dfs = func(node *TreeNode, x, y int) {

		if node == nil {
			return
		}
		key := strconv.Itoa(x) + "_" + strconv.Itoa(y)
		if y < min {
			min = y
		}
		if y > max {
			max = y
		}
		if level < x {
			level = x
		}
		if _, ok := mp[key]; !ok {
			mp[key] = make([]int, 0, 1)
		}

		mp[key] = append(mp[key], node.Val)
		dfs(node.Left, x+1, y-1)
		dfs(node.Right, x+1, y+1)
	}
	dfs(root, 0, 0)
	fmt.Fprint()
	for i := min; i <= max; i++ {
		tmp := make([]int, 0)
		for j := 0; j <= level; j++ {
			key := strconv.Itoa(i) + "_" + strconv.Itoa(j)
			if arr, ok := mp[key]; !ok {
				break
			} else {
				sort.Ints(arr)
				tmp = append(tmp, arr...)
			}

		}
		res = append(res, tmp)
	}
	return res
}
