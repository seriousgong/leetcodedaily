package m4

func search(nums []int, target int) bool {
	for i, j := 0, len(nums)-1; i <= j; {
		mid := (i + j) / 2
		if target == nums[i] || target == nums[j] || nums[mid] == target {
			return true
		}
		if nums[mid] == nums[i] && nums[mid] == nums[j] {
			i++
			j--
		} else if target > nums[mid] {
			if target > nums[mid] && (nums[mid] >= nums[i] || target < nums[j]) {
				i = mid + 1
			} else {
				j = mid - 1
			}
		} else {
			if target >= nums[i] || nums[mid] <= nums[j] {
				j = mid - 1
			} else {
				i = mid + 1
			}
		}
	}
	return false
}
