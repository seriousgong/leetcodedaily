package m1

func findRedundantConnection(edges [][]int) []int {
	root := make([]int, len(edges)+1)
	for i := range root {
		root[i] = i
	}
	var find func(a int) int
	find = func(a int) int {
		if a != root[a] {
			root[a] = find(root[a])
		}
		return root[a]
	}
	var union func(a, b int) bool
	union = func(a, b int) bool {
		val1, val2 := find(a-1), find(b-1)
		if val1 != val2 {
			root[val2] = val1
			return false
		}
		return true
	}
	for _, edge := range edges {

		if union(edge[0], edge[1]) {
			return edge
		}
	}
	return nil
}
