package m1

func rotate(nums []int, k int) {
	le := len(nums)
	mid := k % le
	reverse := func(arr []int) {
		length := len(arr)
		for i := 0; i < length-i-1; i++ {
			arr[i], arr[length-1-i] = arr[length-i-1], arr[i]
		}
	}
	reverse(nums)
	reverse(nums[0:mid])
	reverse(nums[mid:])
}
