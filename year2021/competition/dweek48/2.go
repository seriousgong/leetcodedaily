package dweek48

type AuthenticationManager struct {
	tokenMp    map[string]int //token 为key
	timeToLive int
}

func Constructor(timeToLive int) AuthenticationManager {
	return AuthenticationManager{tokenMp: map[string]int{}, timeToLive: timeToLive}
}

func (this *AuthenticationManager) Generate(tokenId string, currentTime int) {
	this.tokenMp[tokenId] = currentTime + this.timeToLive
}

func (this *AuthenticationManager) Renew(tokenId string, currentTime int) {
	if this.tokenMp[tokenId] > currentTime {
		this.tokenMp[tokenId] = currentTime + this.timeToLive
	}
}

func (this *AuthenticationManager) CountUnexpiredTokens(currentTime int) int {
	count := 0
	for s := range this.tokenMp {
		if this.tokenMp[s] > currentTime {
			count++
		} else {
			delete(this.tokenMp, s)
		}
	}
	return count
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * obj := Constructor(timeToLive);
 * obj.Generate(tokenId,currentTime);
 * obj.Renew(tokenId,currentTime);
 * param_3 := obj.CountUnexpiredTokens(currentTime);
 */
