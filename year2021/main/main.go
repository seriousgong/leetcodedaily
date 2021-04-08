package main

import (
	"fmt"
)

func main() {
	fmt.Println(findMin([]int{1, 2, 3, 4}))
	fmt.Println(findMin([]int{4, 5, 1, 2, 3}))
	fmt.Println(findMin([]int{3, 1, 2}))
	fmt.Println(findMin([]int{3, 4, 5, 1, 2}))
	fmt.Println(findMin([]int{4, 5, 6, 7, 0, 1, 2}))
	fmt.Println(findMin([]int{2, 1}))
	fmt.Println(findMin([]int{3, 2, 1}))
	fmt.Println(findMin([]int{1, 2, 3}))

}
func findMin(nums []int) int {
	// 因为原先是个升序数组，所有无论怎么旋转，如果[0]元素<[last]元素，那么 该数组即原数组
	i, j := 0, len(nums)-1
	for i < j {
		mid := (i + j) / 2
		if nums[mid] < nums[len(nums)-1] {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return nums[i]
}
