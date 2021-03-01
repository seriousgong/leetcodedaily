package m2

func isMonotonic(A []int) bool {
	if len(A) == 1 {
		return true
	}
	up, down := true, true
	for i := 1; i < len(A); i++ {
		if A[i]-A[i-1] > 0 {
			down = false
		} else if A[i]-A[i-1] < 0 {
			up = false

		}
	}

	return up || down
}
