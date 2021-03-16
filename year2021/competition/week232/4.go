package week232

func maximumScore(nums []int, k int) int {
	mins := make([][]int, k+1)
	for i := range mins {
		mins[i] = make([]int, len(nums)-k+1)
	}
	res := 0
	for l := k; l >= 0; l-- {
		for r := 0; r < len(nums)-k+1; r++ {
			if r == 0 && l == k {
				mins[l][r] = nums[k]
			} else if l != k && r == 0 {
				mins[l][r] = min(mins[l+1][r], nums[l])
			} else {
				mins[l][r] = min(nums[r+k], mins[l][r-1])
			}
			if res < mins[l][r]*(r-l+1) {
				res = mins[l][r] * (r + k - l + 1)
			}
		}
	}
	return res
}
func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
