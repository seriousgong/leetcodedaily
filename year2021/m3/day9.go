package m3

func removeDuplicates(S string) string {
	res := make([]byte, 0)
	for index := 0; index < len(S); index++ {
		if len(res) == 0 || res[len(res)-1] != S[index] {
			res = append(res, S[index])
		} else {
			res = res[:len(res)-1]
		}
	}
	return string(res)
}
