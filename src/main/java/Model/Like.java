package Model;

public class Like {
	@Override
	public String toString() {
		return "Like [videoId=" + videoId + ", likeCount=" + likeCount + "]";
	}
	private String videoId;
	private Long likeCount;
	public Like(String videoId, Long likeCount) {
		
		this.videoId = videoId;
		this.likeCount = likeCount;
	}
	public Like() {
		
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
