package d12

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	i1 := 0
	res := 0
	for i := 0; i < len(g) && i1 < len(s); {
		if g[i] <= s[i1] {
			res++
			i++
		}
		i1++
	}
	return res
}
