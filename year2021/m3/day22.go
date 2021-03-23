package m3

func hammingWeight(num uint32) int {

	res := 0
	for num > 0 {
		if num%2 == 1 {
			res++
			num--
		}
		num %= 2
	}
	return res
}
