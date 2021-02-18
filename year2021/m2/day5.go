package m2

func equalSubstring(s string, t string, maxCost int) int {
	result, cost, startIndex, length, count := 0, 0, 0, 0, min5(len(s), len(t))
	diffArr := make([]int, 0)
	for i := 0; i < count; i++ {
		if a := int(s[i]) - int(t[i]); a > 0 {
			diffArr = append(diffArr, a)
		} else {
			diffArr = append(diffArr, -a)
		}
	}
	for i := 0; i < count; i++ {

		if diffArr[i] > maxCost {
			cost = 0
			length = 0
		} else {
			for cost+diffArr[i] > maxCost {
				cost -= diffArr[startIndex]
				startIndex++
				length--
			}
			cost += diffArr[i]
			length++
		}
		if length > result {
			result = length
		}
	}
	return result

}
func min5(l, r int) int {
	if l > r {
		return r
	}
	return l
}
