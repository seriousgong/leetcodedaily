package d12

import "math"

func S(S string) []int {
	return splitIntoFibonacci(S)
}
func splitIntoFibonacci(S string) []int {
	res = make([]int, 0)
	if dfs([]byte(S), 0, 0, 0) {
		return res
	} else {
		return nil
	}
}

var res []int

func dfs(arr []byte, start, lastSum, last int) bool {

	if start >= len(arr) {
		if len(res) < 3 {
			return false
		} else {
			return true
		}
	}
	sum := 0
	for i := start; i < len(arr); i++ {
		sum = sum*10 + int(arr[i]-'0')
		if sum > math.MaxInt32 {
			break
		}
		if sum != 0 && arr[start]-'0' == 0 {
			break
		}
		if len(res) >= 2 {
			if lastSum < sum {
				break
			} else if lastSum > sum {
				continue
			}
		}
		res = append(res, sum)
		if dfs(arr, i+1, last+sum, sum) {
			return true
		}
		res = res[:len(res)-1]
	}

	return false
}
