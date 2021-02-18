package m1

func Day14(A []int) []bool {
	return prefixesDivBy5(A)
}
func prefixesDivBy5(A []int) []bool {
	res := make([]bool, 0)
	sum := 0
	for _, i2 := range A {
		sum = sum<<1 | i2
		res = append(res, sum%5 == 0)
		sum %= 10
	}
	return res
}
