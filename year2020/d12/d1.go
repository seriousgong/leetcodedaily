package d12

/*寻找target 的首位与末位*/
func SearchRange(nums []int, target int) []int {

	res := []int{-1, -1}
	for l, r := 0, len(nums)-1; l <= r; {
		mid := l + (r-l)/2
		if nums[mid] == target {
			res[0] = mid
			for i := mid - 1; i >= 0 && nums[i] == target; i-- {
				res[0] = i
			}
			res[1] = mid
			for i := mid + 1; i < len(nums) && nums[i] == target; i++ {
				res[1] = i
			}
			break
		} else if nums[mid] > target {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return res
}
