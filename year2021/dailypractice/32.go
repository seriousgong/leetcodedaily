package dailypractice

func longestValidParentheses(s string) int {

	stack := make([]int, 0)
	res := 0
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '(':
			stack = append(stack, i)
		case ')':
			if len(stack) > 0 && stack[len(stack)-1] == '(' {
				stack = stack[:len(stack)-1]
				l := -1
				if n := len(stack); n != 0 {
					l = stack[n-1]
				}
				if i-l > res {
					res = i - l
				}
			} else {
				stack = append(stack, i)
			}
		}
	}
	return res
}
