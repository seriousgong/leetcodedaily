package d12

func D15(N int) int {
	return monotoneIncreasingDigits(N)
}
func monotoneIncreasingDigits(N int) int {

	/*小于9直接返回*/
	if N < 9 {
		return N
	}
	/*计算数字位数*/
	bit := make([]int, 0)
	for i := 0; N > 0; i++ {
		bit, N = append(bit, N%10), N/10
	}
	l, res, n := len(bit), 0, 0
	for i := 0; i < l-1; i++ {
		if bit[i] < bit[i+1] {
			n = i + 1
			bit[i+1]--
		}
	}
	for x := l - 1; x >= 0; x-- {
		if x >= n {
			res = res*10 + bit[x]
		} else {
			res = res*10 + 9
		}
	}
	return res
}
