package m2

func D9(A []int, K int) int {
	return subarraysWithKDistinct(A, K)
}
func subarraysWithKDistinct(A []int, K int) int {
	l1, l2, r1, r2, res := 0, 0, 0, 0, 0
	a, b := make([]int, len(A)+1), make([]int, len(A)+1)
	for i := range A {
		if a[A[i]] == 0 {
			r1++
		}
		a[A[i]]++
		if b[A[i]] == 0 {
			r2++
		}
		b[A[i]]++
		for ; r1 > K; l1++ {
			a[A[l1]]--
			if a[A[l1]] == 0 {
				r1--
			}
		}
		for ; r2 > K-1; l2++ {
			b[A[l2]]--
			if b[A[l2]] == 0 {
				r2--
			}
		}
		res += l2 - l1
	}
	return res
}
