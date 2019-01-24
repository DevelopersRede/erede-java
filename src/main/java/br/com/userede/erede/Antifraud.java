package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Antifraud {

  @SerializedName("recommendation")
  private String recommendation;

  @SerializedName("riskLevel")
  private String riskLevel;

  @SerializedName("score")
  private int score;

  @SerializedName("success")
  private boolean success = false;

  public String getRecommendation() {
    return recommendation;
  }

  public Antifraud setRecommendation(String recommendation) {
    this.recommendation = recommendation;
    return this;
  }

  public String getRiskLevel() {
    return riskLevel;
  }

  public Antifraud setRiskLevel(String riskLevel) {
    this.riskLevel = riskLevel;
    return this;
  }

  public int getScore() {
    return score;
  }

  public Antifraud setScore(int score) {
    this.score = score;
    return this;
  }

  public boolean isSuccess() {
    return success;
  }

  public Antifraud setSuccess(boolean success) {
    this.success = success;
    return this;
  }
}
