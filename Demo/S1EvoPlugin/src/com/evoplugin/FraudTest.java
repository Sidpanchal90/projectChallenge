package com.evoplugin;

import java.net.URL;

import org.apache.log4j.Logger;

import com.crif.s1.core.plugins.evo.v1.IS1Environment;
import com.crif.s1.core.plugins.evo.v1.IS1Plugin;

import hex.genmodel.GenModel;
import hex.genmodel.ModelMojoReader;
import hex.genmodel.MojoModel;
import hex.genmodel.MojoReaderBackend;
import hex.genmodel.MojoReaderBackendFactory;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.prediction.BinomialModelPrediction;

public class FraudTest implements IS1Plugin {

	static final Logger logger;

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void load() {

	}

	@Override
	public boolean unload() {
		return false;
	}

	public void logEnvironmentInfo(final IS1Environment environment) {
		FraudTest.logger.debug((Object) String.format("Execution mode: %s", environment.getExecutionMode()));
		FraudTest.logger.debug((Object) String.format("Inquiry code: %s", environment.getInquiryCode()));
		FraudTest.logger.debug((Object) String.format("Organization code: %s", environment.getOrganizationCode()));
		FraudTest.logger.debug((Object) String.format("Layout version: %d", environment.getLayoutVersion()));
		FraudTest.logger.debug((Object) String.format("Process version: %d", environment.getProcessVersion()));
		FraudTest.logger.debug((Object) String.format("Process code: %s", environment.getProcessCode()));
		FraudTest.logger.debug((Object) String.format("Process description: %s", environment.getProcessDescription()));
		final URL mojoURL = FraudTest.class.getResource("/XGBoost_model_python_1670821263417_9.zip");

	}

	public void doRun(final IS1Environment environment) throws Exception {

		final InputS1VariableMapper inVariableMapper = new InputS1VariableMapper(environment);
		final RowData row = inVariableMapper.getRows();
		logger.info("RowData obj : " + row.toString());
		System.out.println("RowData obj : " + row.toString());

		final URL mojoURL = FraudTest.class.getResource("/XGBoost_model_python_1670821263417_9.zip");
		logger.info("URL mojoURL  :" + mojoURL);
		logger.debug("URL mojoURL :" + mojoURL);
		System.out.println("URL mojoURL : " + mojoURL.toString());

		final MojoReaderBackend reader = MojoReaderBackendFactory.createReaderBackend(mojoURL,
				MojoReaderBackendFactory.CachingStrategy.MEMORY);
		logger.info("MojoReaderBackend reader :  " + reader);
		System.out.println("MojoReaderBackend reader : " + reader.toString());

		final MojoModel model = ModelMojoReader.readFrom(reader);
		logger.info("MojoModel model :" + model._mojo_version);
		logger.info("MojoModel model : " + model);
		System.out.println("mojoURL model" + model.toString());

		final EasyPredictModelWrapper.Config config = new EasyPredictModelWrapper.Config().setModel((GenModel) model)
				.setConvertUnknownCategoricalLevelsToNa(true);
		System.out.println("EasyPredictModelWrapper config : " + config);

		final EasyPredictModelWrapper modelWrapper = new EasyPredictModelWrapper(config);
		System.out.println("EasyPredictModelWrapper modelWrapper :  " + modelWrapper.toString());

		final BinomialModelPrediction bmp = modelWrapper.predictBinomial(row);
		logger.info("BinomialModelPrediction object value : " + bmp.classProbabilities[0]);
		logger.debug("debugging bmp :" + bmp.classProbabilities);
		System.out.println("BinomialModelPrediction bmp" + bmp.classProbabilities[0]);
		if (bmp != null && bmp.classProbabilities != null) {
			environment.getRootOccurrence().getVariableOccurrence("p0").setValue(bmp.classProbabilities[0]);

		} else {
			environment.getRootOccurrence().getVariableOccurrence("p0").setValueToMissing();
		}

		logger.debug(String.format("Output variables: %s",
				(environment.getRootOccurrence().getVariableOccurrence("p0").getName())));

	}

	public int run(final IS1Environment environment) {
		FraudTest.logger.debug((Object) String.format("plugin %s started.", FraudTest.class.getSimpleName()));

		this.logEnvironmentInfo(environment);

		try {
			this.doRun(environment);
		} catch (Exception e) {
			FraudTest.logger.error(
					(Object) String.format("plugin %s ended with error", FraudTest.class.getSimpleName()),
					(Throwable) e);
			return 124;
		}
		FraudTest.logger.debug((Object) String.format("plugin %s ended.", FraudTest.class.getSimpleName()));
		return 0;
	}

	static {
		logger = Logger.getLogger((Class<?>) FraudTest.class);
	}

}
