package dailypractice

func removeElement(nums []int, val int) int {
	res := len(nums)
	for i, r := 0, 0; r < len(nums); i++ {
		tmp := r
		for ; tmp < len(nums) && nums[tmp] == val; tmp++ {
			res--
		}
		if tmp < len(nums) && tmp != r {
			tp := nums[i]
			nums[i], nums[r] = nums[r], tp
			r++
		}
	}
	return res
}
