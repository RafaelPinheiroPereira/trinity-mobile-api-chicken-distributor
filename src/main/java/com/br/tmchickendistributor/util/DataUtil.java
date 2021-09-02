package com.br.tmchickendistributor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	private DataUtil() {
		throw new IllegalStateException("Utility class");
	}

	private static SimpleDateFormat getFormatadorDDMMYYYY() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}

	private static SimpleDateFormat getFormatadorDDMMYYYYHHMM() {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm");
	}

	public static String formatarData(java.util.Date dateToFormat) {

		return getFormatadorDDMMYYYY().format(dateToFormat);
	}

	public static java.util.Date formatarDateParaddMMyyyyhhmm(java.util.Date dateToFormat) throws ParseException {

		String strDate = getFormatadorDDMMYYYYHHMM().format(dateToFormat);

		return getFormatadorDDMMYYYYHHMM().parse(strDate);
	}

	public static String formatarDataHora(java.util.Date dateToFormat) {

		return getFormatadorDDMMYYYYHHMM().format(dateToFormat);
	}

	public static String retirarBarrasDaData(java.util.Date dateToFormat) {

		return getFormatadorDDMMYYYY().format(dateToFormat).replace("/", "");
	}

	public static Date converterStringParaDate(String dataSTR) throws ParseException {

		return getFormatadorDDMMYYYY().parse(dataSTR);
	}

	public static boolean ehUmPeriodoValido(Date dataInicial, Date dataFinal) {
		return dataInicial.before(dataFinal);

	}

}
