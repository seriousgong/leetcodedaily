package m1

import (
	"fmt"
	"sort"
)

func Day11(s string, pairs [][]int) string {
	var (
		leng    = len(s)
		ans     = make([]byte, leng)
		parents = make([]int, leng)
		find    func(i int) int
		union   func(a, b int)
	)
	for i := range parents {
		parents[i] = i // init parents
	}
	// find
	find = func(i int) int {
		for parents[i] != i {
			parents[i] = parents[parents[i]]
			i = parents[i]
		}
		return parents[i]
	}
	// union
	union = func(a, b int) {
		pa, pb := find(a), find(b)
		parents[pb] = pa
	}
	// union process
	for _, pair := range pairs {
		union(pair[0], pair[1])
	}
	fmt.Println(parents)
	// split into different groups
	var groups = make(map[int][]int)
	for i := range s {
		p := find(i)
		if group, ok := groups[p]; ok {
			groups[p] = append(group, i)
		} else {
			groups[p] = []int{i}
		}
	}

	for _, group := range groups {
		chs := make([]byte, len(group))
		for i := range group {
			chs[i] = s[group[i]]
		}
		sort.Slice(chs, func(i, j int) bool {
			return chs[i] <= chs[j]
		})

		cp := make([]int, len(group))
		copy(cp, group)
		sort.Ints(cp)

		for i := range cp {
			ans[cp[i]] = chs[i]
		}
	}
	return string(ans)

	return smallestStringWithSwaps(s, pairs)
}
func smallestStringWithSwaps(s string, pairs [][]int) string {

	arr := make([]byte, len(s))
	unionArr := make([]int, len(s))
	for i := range unionArr {
		unionArr[i] = i
	}
	var find func(a int) int
	var union func(a, b int)
	find = func(a int) int {
		if a != unionArr[a] {
			unionArr[a] = find(unionArr[a])
		}
		return unionArr[a]
	}
	union = func(a, b int) {
		unionArr[find(b)] = find(a)
	}

	for _, pair := range pairs {
		union(pair[0], pair[1])
	}
	mp := make(map[int][]int)
	for i, val := range unionArr {
		mp[val] = append(mp[val], i)
	}
	fmt.Println(mp)
	for _, ints := range mp {
		vp := make([]int, len(ints))
		cp := make([]int, len(ints))
		copy(vp, ints)
		copy(cp, ints)
		sort.Ints(vp)
		sort.Slice(cp, func(i, j int) bool {
			return s[i] <= s[j]
		})
		fmt.Println(vp, cp)
		for i := range vp {
			arr[vp[i]] = byte(cp[i])
		}
	}
	return string(arr)
}
