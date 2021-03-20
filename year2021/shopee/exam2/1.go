package exam1

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	rev, tmp := 0, x
	for ; tmp > 0; tmp /= 10 {
		rev = rev*10 + tmp%10
	}
	return rev == x
}
