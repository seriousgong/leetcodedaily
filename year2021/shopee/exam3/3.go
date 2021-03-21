package exam3

import "sort"

func nextGreaterElement(n int) int {
	arr := make([]int, 32)
	for i := len(arr) - 1; i >= 0 && n > 0; i-- {
		arr[i], n = n%10, n/10
		if i < len(arr)-1 && arr[i] < arr[i+1] {
			num := arr[i]
			arr = arr[i:]
			sort.Ints(arr)
			index := sort.SearchInts(arr, arr[0])
			for arr[index] <= num {
				index++
			}
			n = n*10 + arr[index]
			arr = append(arr[:index], arr[index+1:]...)
			break
		}
	}
	for i := 0; n > 0 && i < len(arr); i++ {
		n = n*10 + arr[i]
	}
	if n > 1<<31-1 || n == 0 {
		return -1
	}
	return n
}
