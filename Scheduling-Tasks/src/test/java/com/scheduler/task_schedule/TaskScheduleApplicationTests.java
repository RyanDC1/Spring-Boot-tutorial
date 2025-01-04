package com.scheduler.task_schedule;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.awaitility.Durations;
import static org.awaitility.Awaitility.await;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@SpringBootTest
class TaskScheduleApplicationTests {

	@MockitoSpyBean
	ScheduledTasks tasks;

	@Test
	public void reportCurrentTime() {
		await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
			verify(tasks, atLeast(2)).reportCurrentTime();
		});
	}

}
