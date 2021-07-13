package dailypractice

import (
	"fmt"
	"testing"
)

func Test(t *testing.T) {
	firstMissingPositive([]int{1, 2, 0})
}
func firstMissingPositive(nums []int) int {

	cnt := len(nums)
	for i := 0; i < len(nums); i++ {
		if nums[i] <= 0 {
			cnt--
		} else {
			if nums[i] >= cnt {
				nums[i] = -1
				cnt--
			} else {
				j := i
				for {
					if nums[j] <= 0 || nums[j] > cnt {
						break
					}

				}
				nums[nums[i]] = nums[i]
			}
		}
	}
	fmt.Println(cnt, nums)
	return 0
}
