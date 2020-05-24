package com.udomomo.springboottodo.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskEntityTest {
  @Test
  void testCreateTaskEntity() {
    TaskEntity taskEntity = new TaskEntity("テスト", 3, 4);
    assertEquals("テスト", taskEntity.getContent());
    assertEquals(3, taskEntity.getUrgency());
    assertEquals(4, taskEntity.getImportance());
    assertFalse(taskEntity.isDone());
  }

  @Test
  void testCreateTaskEntityWithId() {
    TaskEntity taskEntity = new TaskEntity(1, "テスト", 3, 4);
    assertEquals(1, taskEntity.getId());
    assertEquals("テスト", taskEntity.getContent());
    assertEquals(3, taskEntity.getUrgency());
    assertEquals(4, taskEntity.getImportance());
    assertFalse(taskEntity.isDone());
  }

  @Test
  void testCreateTaskWithInvalidContent() {
    String content = "101letters101letters101letters101letters101letters"
                   + "101letters101letters101letters101letters101letters"
                   + "1";
    assertThrows(IllegalArgumentException.class, () -> {
      TaskEntity taskEntity = new TaskEntity(1, content, 3, 4);
    });
  }

  @Test
  void testCreateTaskWithInvalidUrgency() {
    assertThrows(IllegalArgumentException.class, () -> {
      TaskEntity taskEntity = new TaskEntity(1, "テスト", -1, 4);
    });
  }

  @Test
  void testCreateTaskWithInvalidImportance() {
    assertThrows(IllegalArgumentException.class, () -> {
      TaskEntity taskEntity = new TaskEntity(1, "テスト", 3, 6);
    });
  }
}
