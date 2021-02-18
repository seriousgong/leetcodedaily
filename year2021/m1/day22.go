package m1

func addToArrayForm(A []int, K int) []int {
	carry := 0
	for i := len(A); K > 0 || i >= 0 || carry > 0; i-- {
		var sum = carry
		if K > 0 {
			sum += K % 10
		}
		if i >= 0 {
			sum += A[i]
		}
		carry = 0
		if sum >= 10 {
			sum, carry = sum-10, 1
		}
		if i >= 0 {
			A[i] = sum
		} else {
			A = append([]int{sum}, A...)
		}
		K = K / 10
	}

	return A
}
