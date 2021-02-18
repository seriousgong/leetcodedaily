package d12

func countPrimes(n int) int {
	if n == 0 {
		return n
	}
	/*计数*/
	res := 0
	arr := make([]bool, n)
	for i := 2; i < n; i++ {
		if arr[i] {
			continue
		}
		res++
		for i1 := i * 2; i1 < n; i1 += i {
			arr[i1] = true
		}
	}
	return res
}
