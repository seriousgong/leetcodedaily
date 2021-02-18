package d12

func findTheDifference(s string, t string) byte {
	var res byte = 0
	for i := 0; i < len(s); i++ {
		res ^= s[i]
		res ^= t[i]
	}
	res ^= t[len(t)-1]
	return res
}
