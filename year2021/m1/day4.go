package m1

func largeGroupPositions(s string) [][]int {
	result := make([][]int, 0)
	for i := 0; i < len(s)-2; i++ {
		j := i + 1
		for ; s[i] == s[j]; j++ {
		}
		if j-i > 3 {
			result = append(result, []int{i, j - 1})
		}
	}
	return result
}
