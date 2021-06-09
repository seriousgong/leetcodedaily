package m6

func checkSubarraySum(nums []int, k int) bool {

	prefix := make([]int, len(nums)+1)
	for i := 1; i < len(nums); i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	for i := 2; i <= len(nums); i++ {
		for j := 0; j <= len(nums)-i; j++ {
			if prefix[j+i]-prefix[j]%k == 0 {
				return true
			}
		}
	}
	return false
}
