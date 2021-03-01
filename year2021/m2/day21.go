package m2

func LongestSubarray(nums []int, limit int) int {
	min, max, count := 0, 0, 0
	res := 0
	for i := 0; i < len(nums); i++ {
		if count == 0 {
			if 0 <= limit {
				min, max = nums[i], nums[i]
				count = 1
			} else {
				return 0
			}
		} else {
			if min == max {
				if
				
			}
			if nums[i] > min {
				if min == max {
					max = nums[i]
				}
				count++
			} else if nums[i] < max {
				if min == max {
					min = nums[i]
				}
				count++
			} else if nums[i] == max || nums[i] == min {
				count++
			} else if nums[i] > max && nums[i]-min <= limit {
				count++
				max = nums[i]
			} else if nums[i] < min && max-nums[i] <= limit {
				count++
				min = nums[i]
			} else {
				min, max = nums[i], nums[i]
				count = 1
			}
		}
		if count > res {
			res = count
		}
	}
	return res
}
