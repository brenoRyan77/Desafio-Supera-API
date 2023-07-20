package br.com.banco.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Utilidades {

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	public static boolean ehNullOuVazio(Object valor) {

		return valor == null || valor.toString().trim().equals("");
	}// ehNullOuVazio

	public static LocalDateTime formatarHoraBanco(String data) {
        String fusoHorario = "+03";

        LocalDate date = LocalDate.parse(data);
        LocalTime horaMeiaNoite = LocalTime.MIDNIGHT;
        ZoneId fuso = ZoneId.of("GMT" + fusoHorario);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, horaMeiaNoite, fuso);
        return zonedDateTime.toLocalDateTime();
    }
}
