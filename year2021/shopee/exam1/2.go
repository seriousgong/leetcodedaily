package exam1

/*给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 */
func removeKdigits(num string, k int) string {
	if len(num) == k {
		return "0"
	}
	res := []byte{}
	for i := 0; i < len(num); i++ {
		for len(res) > 0 && k > 0 && res[len(res)-1] > num[i] {
			res = res[:len(res)-1]
			k--
		}
		res = append(res, num[i])
	}
	for len(res) > 1 && res[0] == '0' {
		res = res[1:]
	}
	return string(res[:len(res)-k])
}
