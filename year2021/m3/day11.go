package m3

/* 递归没想好方案，先用迭代做了，然后省去栈空间，记忆上次操作符即可*/
func calculate(s string) int {
	// res 表示 结果 tmp表示每次连续乘除块的值 flag 表示当前乘除操作 aflag表示当前乘除快正负值
	res, tmp, flag, aflag := 0, 0, 0, true
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case ' ':
		case '+', '-':
			if aflag {
				res += tmp
			} else {
				res -= tmp
			}
			tmp = 0
			flag = 0
			aflag = s[i] == '+'
		case '*':
			flag = 1
		case '/':
			flag = -1
		default:
			num := 0
			for ; i < len(s) && s[i] >= '0' && s[i] <= '9'; i++ {
				num = num*10 + int(s[i]-'0')
			}
			if flag == 1 {
				tmp *= num
			} else if flag == -1 {
				tmp /= num
			} else {
				tmp = num
			}
			i--
		}
	}
	if !aflag {
		tmp = -tmp
	}
	res += tmp
	return res
}
