package leetcode355;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twitter {
    class TwitterNode{
        private int userId;
        private int twitterId;
        public TwitterNode(int userId, int twitterId){
            this.userId = userId;
            this.twitterId = twitterId;
        }
    }
    
    HashMap<Integer, Set<Integer>> userManagement;
    ArrayList<TwitterNode> twitterNodeList;

    /** Initialize your data structure here. */
    public Twitter() {
        twitterNodeList = new ArrayList<>();
        userManagement = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	 if(!userManagement.containsKey(userId)){
             Set<Integer> tmp = new HashSet<>();
             tmp.add(userId);
             userManagement.put(userId,tmp);
         }
         TwitterNode node = new TwitterNode(userId,tweetId);
         twitterNodeList.add(0,node);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> res = new ArrayList<>();
        if(userManagement.containsKey(userId)){
            Set<Integer> follows = userManagement.get(userId);
            int count = 0;
            for(TwitterNode curNode:twitterNodeList){
                if(count == 10)
                    break;
                if(follows.contains(curNode.userId)){
                    res.add(curNode.twitterId);
                    count++;
                }
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	Set<Integer> focusSet;
        if(!userManagement.containsKey(followeeId)){//必须包含被关注者
            focusSet = new HashSet<>();
            focusSet.add(followeeId);
            userManagement.put(followeeId,focusSet);
        }
        if(!userManagement.containsKey(followerId)){
            focusSet = new HashSet<>();
            focusSet.add(followerId);
            userManagement.put(followerId,focusSet);           
        }
        userManagement.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(followerId != followeeId && userManagement.containsKey(followerId)){
            if(userManagement.containsKey(followeeId)){
            	userManagement.get(followerId).remove(followeeId);
            }
        }
    }
}