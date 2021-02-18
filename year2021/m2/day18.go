package m2

func minKBitFlips(A []int, K int) int {

	cnt, res, lcnt := make([]int, len(A)+1), 0, 0
	for i := 0; i < len(A); i++ {
		num := A[i]
		lcnt += cnt[i]
		if lcnt%2 != 0 {
			/*奇数取反数*/
			num ^= 1
		}
		if num == 0 {
			/*需要翻转*/
			if K > len(A)-i {
				return -1
			}
			lcnt++
			/*子数组k翻转次数+1*/
			cnt[i+K]--
			res++
		}
	}
	return res
}
