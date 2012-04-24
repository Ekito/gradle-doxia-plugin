package com.ekito


import org.apache.maven.doxia.Converter
import org.apache.maven.doxia.ConverterException
import org.apache.maven.doxia.DefaultConverter
import org.apache.maven.doxia.UnsupportedFormatException
import org.apache.maven.doxia.wrapper.InputFileWrapper
import org.apache.maven.doxia.wrapper.OutputFileWrapper
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class DoxiaConverterTask extends DefaultTask {

	String inFile
	String fromFormat = "apt"
	String outFile
	String toFormat = "itext"


	@TaskAction
	def convert() {

		Converter converter = new DefaultConverter();
		try {
			InputFileWrapper input = InputFileWrapper.valueOf(inFile,
					fromFormat, "UTF-8", converter.getInputFormats());
			OutputFileWrapper output = OutputFileWrapper.valueOf(outFile,
					toFormat, "UTF-8", converter.getOutputFormats());

			converter.convert(input, output);
		} catch (UnsupportedFormatException e) {
			e.printStackTrace();
		} catch (ConverterException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
