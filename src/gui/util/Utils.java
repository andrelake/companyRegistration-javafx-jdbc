package gui.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Utils {
	
	public static Stage currentStage(ActionEvent event) {                      //captura a janela atual
		return (Stage)((Node)event.getSource()).getScene().getWindow();
	}

	public static void formatDatePicker(DatePicker datePicker, String format) {      // to format datepicker
		datePicker.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);

			{
				datePicker.setPromptText(format.toLowerCase());
			}

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		});
	}
	
	public static Integer tryParseToInt(String string) {     // to convert Id in String
		try {
			return Integer.parseInt(string);
		}
		catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static Date tryLocalDateToDate(DatePicker datePicker) {
		
		LocalDate ld = datePicker.getValue();
		
		return Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
