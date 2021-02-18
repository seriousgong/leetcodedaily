package com.dailyproblem;

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class Twitter {

    HashMap<Integer, Tweet> users = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> userFollow = new HashMap<>();
    private  static  PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>();
    private static int twitterCount = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        List<String> tweetLogs = new ArrayList<>();
        HashMap<Integer, List<String>> users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = users.get(userId);
        if (tweet == null) tweet = new Tweet(tweetId, ++twitterCount);
        else {
            Tweet newTweet = new Tweet(tweetId, ++twitterCount);
            newTweet.next = tweet;
            users.put(userId, newTweet);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
//    public List<Integer> getNewsFeed(int userId) {
//        HashSet<Integer> integers = userFollow.get(userId);
//        Tweet myTweet = users.get(userId);
//        int[] news10 = new int[10];
//        Tweet tmpTweet =myTweet;
//        while (myTweet!=null) {
//            priorityQueue.offer(myTweet);
//            myTweet=myTweet.next;
//        }
//        if (integers==null) return priorityQueue.toArray();
//        Iterator<Integer> iterator = integers.iterator();
//
//
//    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> userFollow = this.userFollow.get(followerId);
        if(userFollow==null) userFollow= new HashSet<>();
        userFollow.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> userFollow = this.userFollow.get(followerId);
        if (userFollow != null) userFollow.remove(followeeId);

    }
    private class Tweet {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}
