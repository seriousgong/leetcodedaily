package m4

func numRabbits(answers []int) int {
	alphet, res := make([]int, 1000), 0
	for _, answer := range answers {
		alphet[answer]++
	}
	for i := 0; i < len(alphet); i++ {
		if alphet[i] != 0 {
			res += (alphet[i] + i) / (i + 1) * (i + 1)
		}
	}
	return res
}
