package m8

import (
	"fmt"
	"sort"
	"testing"
)

func Test4(t *testing.T) {
	fmt.Println(triangleNumber2([]int{1, 1, 3, 4}))
	fmt.Println(triangleNumber2([]int{2, 2, 3, 4}))
	fmt.Println(triangleNumber2([]int{5, 4, 2, 3, 4}))
	fmt.Println(triangleNumber2([]int{4, 2, 3, 4}))
}
func triangleNumber(nums []int) int {

	sort.Ints(nums)

	f := func(arr []int, a, b int) int {
		l, r := 0, len(arr)-1
		for l < r {
			mid := (l + r) / 2
			if a+b > arr[mid] && a+arr[mid] > b && b+arr[mid] > a {
				l = mid + 1
			} else {
				r = mid
			}
		}
		if a+b > arr[l] && a+arr[l] > b && b+arr[l] > a {
			l++
		}
		if l == 0 {
			return 0
		}
		return l
	}
	res := 0
	for i := 0; i < len(nums)-2; i++ {
		for j := i + 1; j < len(nums)-1; j++ {
			cnt := f(nums[j+1:], nums[i], nums[j])
			res += cnt
			fmt.Println(nums[i], nums[j], nums[j+1:], cnt)
		}
	}
	return res
}
func triangleNumber2(nums []int) int {

	sort.Ints(nums)
	res := 0
	for i := 0; i < len(nums)-2; i++ {
		for j, x := i+1, i+2; j < len(nums)-1; j++ {
			for x < len(nums) && nums[i]+nums[j] > nums[x] {
				x++
			}
			if x-j > 0 {
				res += x - j - 1
			}
		}
	}
	return res
}
