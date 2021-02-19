package m2

func longestOnes(A []int, K int) int {
	n, res, conut, l := len(A), 0, 0, 0
	for i := 0; i < n; i++ {
		if A[i] == 0 {
			conut++
		}
		if conut > K {
			for ; l < n && A[l] != 0; l++ {
			}
			if l < n {
				conut--
				l++
			}

		}
		if i-l+1 > res {
			res = i - l + 1
		}

	}
	return res
}
