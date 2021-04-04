package m4

func numRabbits(answers []int) int {
	alphet, res := make([]int, 1000), 0
	for _, answer := range answers {
		alphet[answer]++
	}
	for i := 0; i < len(alphet); i++ {
		if alphet[i] != 0 {
			num := (alphet[i]) / (i + 1)
			if (alphet[i])%(i+1) != 0 {
				num++
			}
			res += num * (i + 1)
		}
	}
	return res
}
