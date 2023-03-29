package com.canos.java8.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class ZonedDates {

	public static void main(String[] args) {
		
		/*
		 * UPDATE 1. Ver las zonas
		 */
		Set<String> allZones = ZoneId.getAvailableZoneIds().stream()
				.filter(p -> p.startsWith("Europe"))
				.collect(Collectors.toSet());
		
		System.out.println("all zones from europe:"+allZones);
		ZoneId zoneId = ZoneId.of("Europe/Madrid");
		ZoneId zoneUk = ZoneId.of("Europe/London");
		System.out.println("ZONA ID POR DEFECTO:"+ZoneId.systemDefault());
		
		/*
		 * UPDATE 1. 
		 * Nuevo representante de Fecha y hora
		 */
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString());
		
		/*
		 * UPDATE 2. Parsear fecha 
		 * Podemos usar los parseadores parecido DateTimeFormatter
		 */
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//		try {
//			java.util.Date fechaOldie = sdf.parse("25-10-1983 01:52");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime fecha = LocalDateTime.parse("25-10-1983 01:52", formatter);
		System.out.println("UPDATE 2: "+fecha);
		
		/*
		 * UPDATE 3. ZonedDateTime 
		 * Definimos la hora como Española
		 */
		ZonedDateTime spanishDate = now.atZone(zoneId);
		System.out.println("UPDATE 3: "+spanishDate);
		
		/*
		 * UPDATE 4. Hora en otro país
		 */
		ZonedDateTime ukDate = spanishDate.withZoneSameInstant(zoneUk);
		System.out.println("UPDATE 4: "+ukDate);
		

		/*
		 * UPDATE 5. Period
		 */
		ZonedDateTime pasadoManana = spanishDate.plusDays(2);
		int dif = Period.between(spanishDate.toLocalDate(), pasadoManana.toLocalDate())
				.getDays();
		System.out.println("UPDATE 5 Diferencia:"+dif);
		
		/*
		 * UPDATE 6. Duration
		 * Mantiene el timezone ;)
		 */
		long difSeconds = Duration.between(spanishDate, ukDate).getSeconds();
		System.out.println("UPDATE 6 Diferencia ES vs UK:"+difSeconds);
		
		difSeconds = Duration.between(spanishDate, fecha.atZone(zoneId)).getSeconds();
		System.out.println("UPDATE 6 bis diferencia:"+difSeconds);
		
		/*
		 * UPDATE 7. Instant
		 * Obtener un LocalDateTime de una fecha en formato antiguo java.util.Date
		 */
		Date legacyDate = new Date();
		Instant instant = legacyDate.toInstant();
		LocalDateTime.ofInstant(instant, zoneId);

		//LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.UTC);
		
		pasadoManana.toLocalDateTime();
		
	}

}
