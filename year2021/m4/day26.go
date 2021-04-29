package m4

import "math"

func shipWithinDays(weights []int, D int) int {

	res := math.MaxInt64
	sum := 0
	i := 0
	for ; i < len(weights); i++ {
		sum += weights[i]
		count, tmp := 1, 0
		flag := true
		for j := i + 1; j < len(weights); j++ {
			if weights[j] > sum {
				flag = false
				break
			}
			if weights[j]+tmp > sum {
				count++
				tmp = weights[j]
			} else if weights[j]+tmp == sum {
				tmp = 0
				count++
			} else {
				tmp += weights[j]
			}
			if count > D {
				break
			}
		}
		if !flag || count > D {
			continue
		}
		if count == D {
			if res > sum {
				res = sum
			}
		}
	}
	return res
}
