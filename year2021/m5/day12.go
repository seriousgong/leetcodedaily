package m5

func xorQueries(arr []int, queries [][]int) []int {
	prefixSums := make([]int, len(arr))
	prefixSums[0] = arr[0]
	for i := 1; i < len(prefixSums); i++ {
		prefixSums[i] = prefixSums[i-1] ^ arr[i]
	}
	res := make([]int, len(queries))
	for i := 0; i < len(queries); i++ {
		l, r := queries[i][0], queries[i][1]
		res[i] = prefixSums[r]
		if l > 0 {
			res[i] ^= prefixSums[l-1]
		}
	}
	return res
}
