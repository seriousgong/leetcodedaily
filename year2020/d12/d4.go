package d12

import "fmt"

func isPossible(nums []int) bool {

	standard := nums[0]
	var count, endMax []int
	if standard < 0 {
		count, endMax = make([]int, nums[len(nums)-1]-nums[0]+2), make([]int, nums[len(nums)-1]-nums[0]+2)
	} else {
		count, endMax = make([]int, nums[len(nums)-1]+2), make([]int, nums[len(nums)-1]+2)
	}
	for _, val := range nums {
		count[val-standard]++
	}
	fmt.Println(count)
	for i := 0; i < len(count)-2; i++ {

		if i > 0 && count[i] == 0 {
			continue
		}
		for count[i] == 0 {
			if i > 0 && count[i] > 0 && endMax[i-1] > 0 {
				count[i]--
				endMax[i-1]--
				endMax[i]++
			} else if count[i] > 0 && count[i+1] > 0 && count[i+2] > 0 {
				count[i]--
				count[i+1]--
				count[i+2]--
				endMax[i+2]++
			} else {
				return false
			}
		}
	}
	for _, val := range count {
		if val != 0 {
			return false
		}
	}

	return true
}
func isPossible1(nums []int) bool {
	left := map[int]int{} // 每个数字的剩余个数
	for _, v := range nums {
		left[v]++
	}
	endCnt := map[int]int{} // 以某个数字结尾的连续子序列的个数
	for _, v := range nums {
		if left[v] == 0 {
			continue
		}
		if endCnt[v-1] > 0 { // 若存在以 v-1 结尾的连续子序列，则将 v 加到其末尾
			left[v]--
			endCnt[v-1]--
			endCnt[v]++
		} else if left[v+1] > 0 && left[v+2] > 0 { // 否则，生成一个长度为 3 的连续子序列
			left[v]--
			left[v+1]--
			left[v+2]--
			endCnt[v+2]++
		} else { // 无法生成
			return false
		}
	}
	return true
}
