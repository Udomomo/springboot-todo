package com.udomomo.springboottodo.domain.model;

public enum Score {
  LOWEST(1),
  LOW(2),
  MIDDLE(3),
  HIGH(4),
  HIGHEST(5);

  private Integer score;

  Score(Integer score) {
    this.score = score;
  }

  public static boolean isValidScore(Integer score) {
    for (Score s : Score.values()) {
      if (s.score.equals(score)) {
        return true;
      }
    }
    return false;
  }

}
