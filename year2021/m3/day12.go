package m3

/*前序遍历验证*/
func isValidSerialization(preorder string) bool {
	return O1Count(preorder)
	//return OnStack(preorder)
}

func O1Count(preorder string) bool {
	count := 1
	for i := 0; i < len(preorder); i++ {
		if preorder[i] == ',' {
			continue
		}
		if count == 0 {
			return false
		}
		if preorder[i] == '#' {
			count--
		} else {
			for ; i < len(preorder) && preorder[i] != ','; i++ {
			}
			count++
		}
	}
	return count == 0
}
func OnStack(preorder string) bool {
	stack := make([]byte, 1)
	// 压入栈首
	for i := 0; i < len(preorder); i++ {
		if preorder[i] == ',' {
			continue
		}
		if len(stack) == 0 {
			return false
		}
		if preorder[i] == '#' {
			stack = stack[:len(stack)-1]
		} else {
			for ; i < len(preorder) && preorder[i] != ','; i++ {
			}
			stack = append(stack, 0)
		}
	}
	return len(stack) == 0
}
