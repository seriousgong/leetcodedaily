package m3

/*正常 for 卡在 37测试案例 ，尴尬的是找不出问题出在哪，只能写成递归了*/
func calculate(s string) int {
	var loop func(l, r int) (int, int)
	loop = func(l, r int) (int, int) {
		res, flag := 0, 1
		for i := l; i < r; i++ {
			switch s[i] {
			case ' ':
			case '+':
				flag = 1
			case '-':
				flag = -1
			case '(':
				//fmt.Println(flag)
				num, index := loop(i+1, r)
				res, i = res+num*flag, index
			case ')':
				return res, i
			default:
				num := 0
				for ; i < r && s[i] >= '0' && s[i] <= '9'; i++ {
					num = num*10 + int(s[i]-'0')
				}
				res, i = res+num*flag, i-1
			}
		}
		return res, r
	}
	res, _ := loop(0, len(s))
	return res
}
