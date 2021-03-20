package main

import (
	"fmt"
)

func main() {
	a := Constructor(5)
	a.Renew("aaa", 1)
	a.Generate("aaa", 2)
	a.CountUnexpiredTokens(6)
	a.Generate("bbb", 7)
	fmt.Println("asdasd", a.timeMp, a.timeMp[7], a.tokenMp)
	a.Renew("aaa", 8)
	fmt.Println("asdasd", a.timeMp, a.timeMp[7], a.tokenMp)
	a.Renew("bbb", 10)
	a.CountUnexpiredTokens(15)
	fmt.Println("asdasd", a.timeMp, a.timeMp[7], a.tokenMp)
}

type AuthenticationManager struct {
	tokenMp    map[string]int         //token 为key
	timeMp     map[int]map[string]int //时序 为key
	timeToLive int
}

func Constructor(timeToLive int) AuthenticationManager {
	return AuthenticationManager{tokenMp: map[string]int{}, timeMp: map[int]map[string]int{}, timeToLive: timeToLive}
}

func (this *AuthenticationManager) Generate(tokenId string, currentTime int) {
	this.tokenMp[tokenId] = currentTime + this.timeToLive
	if this.timeMp[currentTime+this.timeToLive] == nil {
		this.timeMp[currentTime+this.timeToLive] = map[string]int{}
	}
	this.timeMp[currentTime+this.timeToLive][tokenId] = 1
}

func (this *AuthenticationManager) Renew(tokenId string, currentTime int) {
	for i := 0; i <= currentTime; i++ {
		if this.timeMp[i] != nil {
			for i2 := range this.timeMp[i] {
				delete(this.tokenMp, i2)
			}
			delete(this.timeMp, i)
		}
	}
	if this.tokenMp[tokenId] != 0 {
		expireTime := this.tokenMp[tokenId]
		delete(this.timeMp[expireTime], tokenId)
		if this.timeMp[currentTime+this.timeToLive] == nil {
			this.timeMp[currentTime+this.timeToLive] = map[string]int{}
		}
		this.timeMp[currentTime+this.timeToLive][tokenId] = 1
	}

}

func (this *AuthenticationManager) CountUnexpiredTokens(currentTime int) int {
	fmt.Println(this.tokenMp)
	for i := 0; i <= currentTime; i++ {
		for i2 := range this.timeMp[i] {
			delete(this.tokenMp, i2)
		}
		delete(this.timeMp, i)
	}
	fmt.Println(this.tokenMp)
	return len(this.timeMp)
}
