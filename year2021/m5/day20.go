package m5

func topKFrequent(words []string, k int) []string {
	mp := make(map[string]int, 0)
	arr := make([]string, 0)
	for i := 0; i < len(words); i++ {
		if mp[words[i]] == 0 {
			arr = append(arr, words[i])
		}
		mp[words[i]]++
	}
	var qs func(l, r int)
	qs = func(l, r int) {
		x, y := l, r
		std := arr[l]
		for x < y {
			for x < y && mp[arr[y]] > mp[std] {
				y--
			}
			for x < y && mp[arr[x]] <= mp[std] {
				x++
			}
			if x > y {
				break
			}
			tmp := arr[x]
			arr[x], arr[y] = arr[y], tmp
		}
		if x == y {
			arr[l], arr[x] = arr[x], std
		}
		qs(l, x-1)
		qs(x+1, r)
	}
	qs(0, len(arr)-1)
	return arr[0:k]
}
