package m3

func partition(s string) [][]string {
	res := make([][]string, 0)
	var loop func(i int, arr []string)
	loop = func(i int, arr []string) {
		if i == len(s) {
			if len(arr) > 0 {
				nArr := make([]string, len(arr))
				copy(nArr, arr)
				res = append(res, nArr)
			}
			return
		}
		for j := i; j < len(s); j++ {
			if str := s[i : j+1]; isPalindrome(str) {
				arr = append(arr, str)
				loop(j+1, arr)
				arr = arr[:len(arr)-1]
			}
		}
	}
	loop(0, []string{})
	return res
}
func isPalindrome(str string) bool {
	for i, length := 0, len(str); i < length-i-1; i++ {
		if str[i] != str[length-i-1] {
			return false
		}
	}
	return true
}
