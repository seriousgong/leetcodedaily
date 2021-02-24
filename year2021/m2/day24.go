package m2

func flipAndInvertImage(A [][]int) [][]int {
	l, w := len(A), len(A[0])
	for x := 0; x < l; x++ {
		//首尾指针
		for y := 0; y <= w-y-1; y++ {
			A[x][y], A[x][w-y-1] = A[x][w-y-1]^1, A[x][y]^1
		}
	}
	return A
}
