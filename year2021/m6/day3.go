package m6

func findMaxLength(nums []int) int {
	in := -1
	xor, res := 0, 0
	prefix := make([]int, len(nums)) //记录1的个数
	for i := 0; i < len(nums); i++ {
		prefix[i] = prefix[i] + nums[i] ^ 0
		xor ^= nums[i] // 异或
		if xor == 1 {  // 异或值为1表示 1 0 个数相差1
			if in == -1 { // 第一次遇见异或值为1的记录索引
				in = i
			}
		}
		// 异或值为0时，判断0 1 个数
		// 异或值为1时，判断 当前前缀和-第一次遇到异或为1的索引=区间1的个数，该数的两倍要等于i-第一次遇到异或值为1
		if 2*prefix[i] != i+1 && in != -1 && 2*(prefix[i]-prefix[in]) != i-in {
			continue
		}
		cnt := i
		if xor == 1 {
			cnt -= in
		}
		if cnt > res {
			res = cnt
		}
	}
	return res
}
