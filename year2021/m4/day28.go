package m4

func judgeSquareSum(c int) bool {
	mp := map[int]int{}
	for i := 0; i <= c/2+1; i++ {
		if val := i * i; val > c {
			break
		} else if val == c {
			return true
		}
		mp[i*i] = 1
	}
	for i := range mp {
		if mp[c-i] == 1 {
			return true
		}
	}
	return false
}
