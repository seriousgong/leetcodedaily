package m5

func decode(encoded []int) []int {
	n := len(encoded)
	a, b, ans := 0, n+1, make([]int, n+1)
	for i := 0; i < n; i++ {
		if i%2 == 0 {
			a ^= encoded[i]
		}
		b ^= i + 1
	}
	ans[n] = a ^ b
	for i := n - 1; i >= 0; i-- {
		ans[i] = ans[i+1] ^ encoded[i]
	}
	return ans
}
