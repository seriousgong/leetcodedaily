package m2

import "fmt"

func maxTurbulenceSize(arr []int) int {
	if arr == nil {
		return 0
	}
	if len(arr) == 1 {
		return 1
	}
	for i := 0; i < len(arr)-1; i++ {
		arr[i] = arr[i+1] - arr[i]
	}
	fmt.Println(arr)
	res, length := 0, 2
	for i := 0; i < len(arr)-1; i++ {
		if i == 0 {
			if arr[i] == 0 {
				length = 1
			} else {
				length = 2
			}
		} else {

			if arr[i] > 0 {
				if arr[i-1] > 0 {
					length = 2
				} else if arr[i-1] < 0 {
					length++
				} else {
					length = 2
				}
			} else if arr[i] == 0 {
				length = 1
			} else {
				if arr[i-1] < 0 {
					length = 2
				} else if arr[i-1] > 0 {
					length++
				} else {
					length = 2
				}
			}
		}
		if res < length {
			res = length
		}
	}
	return res
}
