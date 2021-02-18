package m1

func fib(n int) int {
	if n == 0 {
		return 0
	} else if n == 1 {
		return 1
	} else {
		l, r := 0, 1
		for i := 2; i < n; i++ {
			temp := l + r
			l = r
			r = temp
		}
		return r
	}
}
