package dweek48

func minPatches(nums []int, n int) int {

	num := 0
	res := 0
	for i := 0; i < len(nums); i++ {
		if num < nums[i] {
			res++
			num *= 2
		} else {
			num = num + nums[i]
		}
	}
	for n > num {
		res++
		num *= 2
	}
	return res
}
