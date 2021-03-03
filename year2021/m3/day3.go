package m3

func countBits(num int) []int {
	res := make([]int, num+1)
	for i := 1; i <= num; i++ {
		if i&1 == 1 {
			// 等于偶数+1 即末位补1
			res[i] = res[i-1] + 1
		} else {
			// *2 等于进位，总数不变
			res[i] = res[i/2]
		}
	}
	return res
}
