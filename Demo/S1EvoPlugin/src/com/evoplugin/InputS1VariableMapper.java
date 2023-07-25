package com.evoplugin;

import org.apache.log4j.Logger;

import com.crif.s1.core.plugins.evo.v1.IS1CategoryOccurrence;
import com.crif.s1.core.plugins.evo.v1.IS1Environment;
import com.crif.s1.core.plugins.evo.v1.IS1VariableOccurrence;
import com.crif.s1.core.plugins.evo.v1.S1VariableStatus;

import hex.genmodel.easy.RowData;

public class InputS1VariableMapper {

	static final Logger logger;

	private IS1Environment environment;
	private RowData rows;

	public InputS1VariableMapper(final IS1Environment environment) {
		this.environment = environment;
		this.rows = new RowData();
		logInputVariable();
		this.fillRowData();

	}

	public InputS1VariableMapper() {
	}

	public RowData getRows() {
		return this.rows;
	}

	private void logInputVariable() {
		InputS1VariableMapper.logger
				.debug(String.format("Name of input variables: %s", this.environment.getRootOccurrence().getName()));

	}

	private String normalizeValue(final Object value) {
		try {
			final Double dValue = Double.valueOf(String.valueOf(value));
			if (dValue.longValue() == dValue) {
				return String.format("%d", dValue.longValue());
			}
		} catch (NumberFormatException ex) {
		}
		return String.valueOf(value);
	}

	public String readInputVar(final String inVarName) {
		final IS1CategoryOccurrence rootCatOccurance = this.environment.getRootOccurrence();

		if (rootCatOccurance != null) {
			IS1VariableOccurrence varOccurance = rootCatOccurance.getVariableOccurrence(inVarName);
			if (varOccurance != null && varOccurance.getValue() != S1VariableStatus.Missing
					&& varOccurance.getValue() != S1VariableStatus.NotAvailable) {
				return this.normalizeValue(varOccurance.getValue());
			}
		}
		return null;

	}

	private void addRowData(final String key, final String value) {
		if (value == null || "".equals(value.trim())) {
			return;
		}
		this.rows.put((String) key, (Object) value);
		logger.info(this.rows.get(key));
		System.out.println("rows values" + this.rows.get(key));
	}

	private void fillRowData() {

		this.addRowData("NumAge", this.readInputVar("NumAge"));
		this.addRowData("AMNAPPLICATIONCAPITALRR", this.readInputVar("AMNAPPLICATIONCAPITALRR"));
		this.addRowData("Days_RInquiry", this.readInputVar("Days_RInquiry"));
		this.addRowData("No_inquiry", this.readInputVar("No_inquiry"));
		this.addRowData("NOO_FII", this.readInputVar("NOO_FII"));
		this.addRowData("Days_Since_First_Inquiry", this.readInputVar("Days_Since_First_Inquiry"));
		this.addRowData("No_inquiry_6M", this.readInputVar("No_inquiry_6M"));
		this.addRowData("No_inquiry_3M", this.readInputVar("No_inquiry_3M"));
		this.addRowData("FLGFIRSTORGANIZATIONENQUIRY", this.readInputVar("FLGFIRSTORGANIZATIONENQUIRY"));
		this.addRowData("Disb_from_FI", thi s.readInputVar("Disb_from_FI"));
		this.addRowData("No_Rej_contr", this.readInputVar("No_Rej_contr"));
		this.addRowData("Daysince_RN_contr", this.readInputVar("Daysince_RN_contr"));
		this.addRowData("NumPhone", this.readInputVar("NumPhone"));
		this.addRowData("AddressType", this.readInputVar("AddressType"));
		this.addRowData("MonthsinceLastAddress", this.readInputVar("MonthsinceLastAddress"));
		this.addRowData("LENCODIDCARD", this.readInputVar("LENCODIDCARD"));
		this.addRowData("LENNUMDOCUMENT", this.readInputVar("LENNUMDOCUMENT"));
		this.addRowData("CODDOCUMENTTYPE", this.readInputVar("CODDOCUMENTTYPE"));
		this.addRowData("GeoScore", this.readInputVar("GeoScore"));
		this.addRowData("WEEKDAY_OPERATION", this.readInputVar("WEEKDAY_OPERATION"));
		this.addRowData("EXCLUSION_E01", this.readInputVar("EXCLUSION_E01"));
		this.addRowData("EXCLUSION_E02", this.readInputVar("EXCLUSION_E02"));
		this.addRowData("EXCLUSION_E03", this.readInputVar("EXCLUSION_E03"));
		this.addRowData("EXCLUSION_E04", this.readInputVar("EXCLUSION_E04"));
		this.addRowData("EXCLUSION_E05", this.readInputVar("EXCLUSION_E05"));
		this.addRowData("EXCLUSION_E06", this.readInputVar("EXCLUSION_E06"));
		this.addRowData("EXCLUSION_E07", this.readInputVar("EXCLUSION_E07"));
		this.addRowData("EXCLUSION_E08", this.readInputVar("EXCLUSION_E08"));
		this.addRowData("EXCLUSION_E12", this.readInputVar("EXCLUSION_E12"));
		this.addRowData("EXCLUSION_E13", this.readInputVar("EXCLUSION_E13"));
		this.addRowData("EXCLUSION_E14", this.readInputVar("EXCLUSION_E14"));
		this.addRowData("EXCLUSION_E15", this.readInputVar("EXCLUSION_E15"));
		this.addRowData("EXCLUSION_E16", this.readInputVar("EXCLUSION_E16"));
		this.addRowData("EXCLUSION_E17", this.readInputVar("EXCLUSION_E17"));
		this.addRowData("EXCLUSION_E18", this.readInputVar("EXCLUSION_E18"));
		this.addRowData("EXCLUSION_E19", this.readInputVar("EXCLUSION_E19"));
		this.addRowData("FIRSTCHARDOCNUMBER_0", this.readInputVar("FIRSTCHARDOCNUMBER_0"));
		this.addRowData("FIRSTCHARDOCNUMBER_1", this.readInputVar("FIRSTCHARDOCNUMBER_1"));
		this.addRowData("FIRSTCHARDOCNUMBER_2", this.readInputVar("FIRSTCHARDOCNUMBER_2"));
		this.addRowData("FIRSTCHARDOCNUMBER_3", this.readInputVar("FIRSTCHARDOCNUMBER_3"));
		this.addRowData("FIRSTCHARDOCNUMBER_4", this.readInputVar("FIRSTCHARDOCNUMBER_4"));
		this.addRowData("FIRSTCHARDOCNUMBER_5", this.readInputVar("FIRSTCHARDOCNUMBER_5"));
		this.addRowData("FIRSTCHARDOCNUMBER_6", this.readInputVar("FIRSTCHARDOCNUMBER_6"));
		this.addRowData("FIRSTCHARDOCNUMBER_7", this.readInputVar("FIRSTCHARDOCNUMBER_7"));
		this.addRowData("FIRSTCHARDOCNUMBER_8", this.readInputVar("FIRSTCHARDOCNUMBER_8"));
		this.addRowData("FIRSTCHARDOCNUMBER_9", this.readInputVar("FIRSTCHARDOCNUMBER_9"));
		this.addRowData("FIRSTCHARDOCNUMBER_A", this.readInputVar("FIRSTCHARDOCNUMBER_A"));
		this.addRowData("FIRSTCHARDOCNUMBER_B", this.readInputVar("FIRSTCHARDOCNUMBER_B"));
		this.addRowData("FIRSTCHARDOCNUMBER_C", this.readInputVar("FIRSTCHARDOCNUMBER_C"));
		this.addRowData("FIRSTCHARDOCNUMBER_D", this.readInputVar("FIRSTCHARDOCNUMBER_D"));
		this.addRowData("FIRSTCHARDOCNUMBER_E", this.readInputVar("FIRSTCHARDOCNUMBER_E"));
		this.addRowData("FIRSTCHARDOCNUMBER_F", this.readInputVar("FIRSTCHARDOCNUMBER_F"));
		this.addRowData("FIRSTCHARDOCNUMBER_G", this.readInputVar("FIRSTCHARDOCNUMBER_G"));
		this.addRowData("FIRSTCHARDOCNUMBER_H", this.readInputVar("FIRSTCHARDOCNUMBER_H"));
		this.addRowData("FIRSTCHARDOCNUMBER_I", this.readInputVar("FIRSTCHARDOCNUMBER_I"));
		this.addRowData("FIRSTCHARDOCNUMBER_J", this.readInputVar("FIRSTCHARDOCNUMBER_J"));
		this.addRowData("FIRSTCHARDOCNUMBER_K", this.readInputVar("FIRSTCHARDOCNUMBER_K"));
		this.addRowData("FIRSTCHARDOCNUMBER_L", this.readInputVar("FIRSTCHARDOCNUMBER_L"));
		this.addRowData("FIRSTCHARDOCNUMBER_M", this.readInputVar("FIRSTCHARDOCNUMBER_M"));
		this.addRowData("FIRSTCHARDOCNUMBER_N", this.readInputVar("FIRSTCHARDOCNUMBER_N"));
		this.addRowData("FIRSTCHARDOCNUMBER_O", this.readInputVar("FIRSTCHARDOCNUMBER_O"));
		this.addRowData("FIRSTCHARDOCNUMBER_P", this.readInputVar("FIRSTCHARDOCNUMBER_P"));
		this.addRowData("FIRSTCHARDOCNUMBER_Q", this.readInputVar("FIRSTCHARDOCNUMBER_Q"));
		this.addRowData("FIRSTCHARDOCNUMBER_R", this.readInputVar("FIRSTCHARDOCNUMBER_R"));
		this.addRowData("FIRSTCHARDOCNUMBER_S", this.readInputVar("FIRSTCHARDOCNUMBER_S"));
		this.addRowData("FIRSTCHARDOCNUMBER_T", this.readInputVar("FIRSTCHARDOCNUMBER_T"));
		this.addRowData("FIRSTCHARDOCNUMBER_U", this.readInputVar("FIRSTCHARDOCNUMBER_U"));
		this.addRowData("FIRSTCHARDOCNUMBER_V", this.readInputVar("FIRSTCHARDOCNUMBER_V"));
		this.addRowData("FIRSTCHARDOCNUMBER_X", this.readInputVar("FIRSTCHARDOCNUMBER_X"));
		this.addRowData("FIRSTCHARDOCNUMBER_Y", this.readInputVar("FIRSTCHARDOCNUMBER_Y"));
		this.addRowData("FIRSTCHARDOCNUMBER_Z", this.readInputVar("FIRSTCHARDOCNUMBER_Z"));

	}

	static {
		logger = Logger.getLogger((Class<?>) InputS1VariableMapper.class);
	}

}
