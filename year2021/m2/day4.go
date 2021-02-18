package m2

func findMaxAverage(nums []int, k int) float64 {
	num, sum := float64(k), 0
	for i := 0; i < k; i++ {
		sum += nums[i]
	}
	avg := float64(sum) / num
	for i, l := k, 0; i < len(nums); i, l = i+1, l+1 {
		sum += nums[i] - nums[l]
		if res := float64(sum) / num; res > avg {
			avg = res
		}
	}
	return avg
}
