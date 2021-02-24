package m2

func maxSatisfied(customers []int, grumpy []int, X int) int {
	sum, maxSum, all := 0, 0, 0
	for i, l := 0, 0; i < len(grumpy); i++ {
		if grumpy[i] == 1 {
			// 冷静期内把生气的都加上
			sum += customers[i]
		} else {
			all += customers[i]
		}
		if i-l+1 > X {
			//超过冷静期时间 ，窗口往前挪1
			if grumpy[l] == 1 {
				sum -= customers[l]
			}
			l++
		}
		if i-l+1 == X && maxSum < sum {
			maxSum = sum
		}
	}
	return maxSum + all
}
