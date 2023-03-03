package com.inditex.consumer.builder;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FakeClock {

	private static Map<Integer, LocalDateTime> dateTimeSeeds = new HashMap<>();
	private static Map<Integer, LocalDate> dateSeeds = new HashMap<>();
	public static LocalDateTime seed = LocalDateTime.now();
	public static LocalDate date = LocalDate.now();

	private static LocalDateTime getLocalDateTime() {
		return LocalDateTime.of(
			seed.getYear(),
			seed.getMonthValue(),
			seed.getDayOfMonth(),
			seed.getHour(),
			seed.getMinute(),
			seed.getSecond()
		);
	}

	private static LocalDate getLocalDate() {
		return LocalDate.of(
			date.getYear(),
			date.getMonthValue(),
			date.getDayOfMonth()
		);
	}

	public static LocalDateTime now() {
		return getLocalDateTime();
	}

	public static LocalDateTime future() {
		return getLocalDateTime().plusDays(Math.min(10, new Random().nextInt(86400)));
	}

	public static LocalDate futureDate() {
		return getLocalDate().plusDays(Math.min(10, new Random().nextInt(86400)));
	}

	public static LocalDateTime pastDateTime() {
		return getLocalDateTime().minusSeconds(Math.min(10, new Random().nextInt(86400)));
	}

	public static LocalDate past() {
		return getLocalDate().minusDays(Math.min(10, new Random().nextInt(86400)));
	}

	public static Clock nowClock() {
		return Clock.fixed(now().toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
	}

	public static LocalDate localDateNow() {
		return getLocalDateTime().toLocalDate();
	}

	public static ZonedDateTime zoneNow() {
		return ZonedDateTime.of(
			now(),
			ZoneId.of("Europe/Madrid")
		);
	}

	public static LocalDateTime dateTime(int seed) {
		if(!dateTimeSeeds.containsKey(seed)) {
			dateTimeSeeds.put(
				seed,
				LocalDateTime.now()
					.minusSeconds(new Random().nextInt(86400) + 10)
					.plusSeconds(new Random().nextInt(86400) + 10)
			);
		}

		return dateTimeSeeds.get(seed);
	}

	public static LocalDate date(int seed) {
		if(!dateSeeds.containsKey(seed)) {
			dateSeeds.put(
				seed,
				LocalDate.now()
					.minusDays(new Random().nextInt(365) + 1)
					.plusDays(new Random().nextInt(365) + 1)
			);
		}

		return dateSeeds.get(seed);
	}
}
