package m5

func hammingDistance(x int, y int) int {

	xor := x ^ y

	res := 0
	for ; xor > 0; xor /= 2 {
		if xor%2 != 0 {
			xor--
			res++
		}
	}
	return res
}
