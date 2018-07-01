package com.example.demo.domain;

public class CrickScore {
	private String player;
	private int score;
	public CrickScore(String player, int score) {
		this.player = player;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [player=" + player + ", score=" + score + "]";
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
